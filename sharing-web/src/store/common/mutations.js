import {
  COMMON_CHANGE_LOADING_BAR,
  COMMON_IS_SLIDEBAR_SHOW
} from './mutation-types'

const loadQueue = []

export default {
  [COMMON_CHANGE_LOADING_BAR] (state, isLoading) {
    if (isLoading) {
      loadQueue.push(true)
    } else {
      loadQueue.pop()
    }

    state.isLoading = loadQueue.length > 0
  },
  [COMMON_IS_SLIDEBAR_SHOW] (state, isSlideBarShow) {
    state.isSlideBarShow = isSlideBarShow
  }

}
