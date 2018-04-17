import Vue from 'vue'
import Vuex from 'vuex'
import common1 from './modules/common'
import module1 from './modules/module1'
import common from './common'
Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

export default new Vuex.Store({
  modules: {
    common1,
    module1,
    common
  },
  strict: debug
})
