//ticket/shop.js
//获取应用实例
var app = getApp()
Page({
  data:{
    num:'',
    productNo:'',//优惠券ID
    shopsData:[]
  },
  onShareAppMessage: function () {
    return {
      title: '来飞凡，享优惠吧~',
      path: '/pages/index'
    }
  },
  onLoad: function (options) {
    var that = this
    that.setData({
      productNo: options.productNo
    })


    // 获取经纬度
    wx.getLocation({
      type:'wgs84',
      success:function(res) {
        console.info('经纬度：',res)
        that.getShopData(res.latitude,res.longitude)
      }
    })
  },
  getShopData: function(latitude,longitude){
    wx.showToast({
      title: '数据加载中...',
      icon: 'loading',
      duration: 500
    })
    
    var that = this
    wx.request({
      url: 'https://api.ffan.com/ffan/coupon/v1/store',
      data: {
        cityId: '310100',//上海
        couponId: that.data.productNo,
        latitude: latitude,
        longitude: longitude,
        keyword: '广场',
        from: '0',
        size: '10'
      },
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      success: function(res) {
        console.log(res)
        if(res.statusCode === 200){
          that.setData({
            num : res.data.data.total,
            shopsData : res.data.data.list
          })
        }
      },error:function(res) {
        console.info(res.error)
      }
    })
  },
  onReady: function() {
    // Do something when page ready.
  }
})
