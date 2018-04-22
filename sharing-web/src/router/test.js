/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2017，所有权利保留。
 * 项目名：vue-seed-master
 * 文件名：test
 * 模块说明：
 * 修改历史：
 * 2018/4/16 - lihuiming - 创建
 */
// 非登录页的包裹组件
/*const Layout = resolve => require(['@/views/Layout/Layout'], resolve)
// 项目信息
const ProjectInfo = resolve => require(['@/views/ProjectInfo/ProjectInfo'], resolve)

// 报名列表
const EnrollList = resolve => require(['@/views/EnrollList/EnrollList'], resolve)*/
const Layout = () => import('@/views/Layout/Layout')
const ProjectInfo = () => import('@/views/ProjectInfo/ProjectInfo')
const EnrollList = () => import('@/views/EnrollList/EnrollList')
const Weather = () => import('@/views/Weather/Weather')
const Cube = () => import('@/views/Cube/Cube')
const AuthorityTest = () => import('@/views/AuthorityTest/AuthorityTest')
const NewArticle = () => import('@/views/article/article-new')
const ArticleList = () => import('@/views/article/article-list')
const Cube1 = () => import('@/views/borrowandback/Cube')
// 天气预报
// const Weather = resolve => require(['@/views/Weather/Weather'], resolve)
// 立方体
/*const Cube = resolve => require(['@/views/Cube/Cube'], resolve)
// 权限测试
const AuthorityTest = resolve => require(['@/views/AuthorityTest/AuthorityTest'], resolve)*/
export default // 然后就是嵌套路由了，也就是登陆后的各个页面
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
      meta: {requireAuth: true},
      component: ProjectInfo
    },
    {
      path: 'enroll-list',
      meta: {requireAuth: true},
      component: EnrollList
    },
    {
      path: 'weather',
      meta: {requireAuth: true},
      component: Weather
    },
    {
      path: 'cube',
      meta: {requireAuth: true},
      component: Cube
    },
    {
      path: 'cube1',
      meta: {requireAuth: true},
      component: Cube1
    },
    {
      path: 'authority-test',
      meta: {requireAuth: true},
      component: AuthorityTest
    },
    {
      path: 'article-new',
      meta: {requireAuth: true},
      component: NewArticle
    },
    {
      path: 'article-list',
      meta: {requireAuth: true},
      component: ArticleList
    }
  ]
}
