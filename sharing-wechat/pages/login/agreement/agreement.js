//agreement.js
//获取应用实例
var app = getApp()
Page({
  data:{ },
  bindViewTap: function(){
    // alert('hi, you clicked me')
  },
  onShareAppMessage: function () {
    return {
      title: '来飞凡，享优惠吧~',
      path: '/pages/index'
    }
  },
  onLoad: function () {
    console.log('onLoad')
    var that = this
  }
})
