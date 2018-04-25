//ticket/manual.js
//获取应用实例
var util = require('../../../utils/util.js')
var WxParse = require('../../../utils/wxParse/wxParse.js');

var app = getApp()
Page({
  data:{
    webDetail: '',
    validPeriod: '',
    buyNotify: '',
  },
  onShareAppMessage: function () {
    return {
      title: '来飞凡，享优惠吧~',
      path: '/pages/index'
    }
  },
  onLoad: function () {
    console.log('onLoad')
    var that = this;

    let startTime = util.formatTimeStamp(wx.getStorageSync('saleStartTime') || '');
    let endTime = util.formatTimeStamp(wx.getStorageSync('validEndTime') || '');
    this.setData({validPeriod: startTime + '至' + endTime});

    this.setData({webDetail: wx.getStorageSync('couponWebDetail') || ''});

    //var article = '<div>我是HTML代码</div>';
    WxParse.wxParse('article', 'html', this.data.webDetail, that,5);

  },
  onReady: function () {
    wx.setNavigationBarTitle({
      title: "使用须知"
    })
  }
})
