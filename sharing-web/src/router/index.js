import Vue from 'vue'
import Router from 'vue-router'
import Cookies from 'js-cookie'
import testRouter from './test.js'
import store from '../store'
// 登录
const Signin = resolve => require(['@/views/Signin/Signin'], resolve)

// 非登录页的包裹组件
const Layout = resolve => require(['@/views/Layout/Layout'], resolve)


// 404
const Notfound = resolve => require(['@/views/Notfound/Notfound'], resolve)
const lazyload = asyncComponent => {
  return async () => {
    store.commit('common/COMMON_CHANGE_LOADING_BAR', true)
    let component = null
    try {
      component = await asyncComponent()
    } catch (e) {
      // showMessage(e)
    }

    store.commit('common/COMMON_CHANGE_LOADING_BAR', false)
    return component
  }
}
const batchModule = module => {
  module.children.forEach(ch => {
    if (ch) {
      ch.component = lazyload(ch.component)
    }
  })

  return module
}
Vue.use(Router)

const router = new Router({
  routes: [
    // 首先是登录页的路由
    {
      path: '/signin',
      name: 'Signin',
      meta: {
        requireAuth: false
      },
      component: Signin
    },
    /*// 然后就是嵌套路由了，也就是登陆后的各个页面
     {
     path: '/',
     meta: {
     requireAuth: true
     },
     component: Layout,
     redirect: '/project-info', //重定向到第一个子路由，否则只渲染Layout组件
     children: [
     {
     path: 'project-info',
     meta: { requireAuth: true },
     component: ProjectInfo
     },
     {
     path: 'enroll-list',
     meta: { requireAuth: true },
     component: EnrollList
     },
     {
     path: 'weather',
     meta: { requireAuth: true },
     component: Weather
     },
     {
     path: 'cube',
     meta: { requireAuth: true },
     component: Cube
     },
     {
     path: 'authority-test',
     meta: { requireAuth: true },
     component: AuthorityTest
     }
     ]
     },*/
    // 最后是404页面
    {
      path: '*',
      meta: {requireAuth: true},
      component: Notfound
    },
    batchModule(testRouter)
  ]
})

// 当一个导航触发时，全局的 before 钩子按照创建顺序调用。钩子是异步解析执行，此时导航在所有钩子 resolve 完之前一直处于等待中。
router.beforeEach((to, from, next) => {
  // 判断该路由是否需要登录权限
  if (to.meta.requireAuth) {
    // 判断是否是登录状态
    if (Cookies.get('isLogin') == '1') {
      next()
    } else {
      // 否则跳回登录页
      next('/signin')
    }
  } else {
    // 如果不需要登录权限，就直接resolve这个钩子
    next()
  }
})

export default router
