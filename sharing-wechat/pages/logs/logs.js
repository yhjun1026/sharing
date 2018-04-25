//logs.js
var app = getApp()
Page({
  data: {
    logs: []
  },
  onShareAppMessage: function () {
    return {
      title: '来飞凡，享优惠吧~',
      path: '/pages/index'
    }
  },
  onLoad: function () {
    this.setData({
      logs: (wx.getStorageSync('logs') || []).map(function (log) {
        return app.func.util.formatTime(new Date(log))
      })
    })
  }
})
