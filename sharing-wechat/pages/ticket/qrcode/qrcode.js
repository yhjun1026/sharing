//ticket/qrcode.js
//获取应用实例
var app = getApp()

Page({
  data:{ 
    ticketTitle:'来一份有过世界-18元优惠券',
    ticketCode:'8878 8893 9944',
    ticketQrcodeSrc:'',
    ticketBarcodeSrc:''
  },
  onShareAppMessage: function () {
    return {
      title: '来飞凡，享优惠吧~',
      path: '/pages/index'
    }
  },
  onLoad: function (options) {
    console.log('onLoad')
    var that = this
    var ticketcode = options.couponNo
    
    that.setData({
      ticketTitle : options.couponTitle,
      ticketCode : ticketcode,
      ticketBarcodeSrc: 'https://api.ffan.com/ffan/v1/barcode?text='+ ticketcode +'&imgHeight=40&imgType=png&codeBusinessType=coupon',
      ticketQrcodeSrc : 'https://api.ffan.com/qrcode/v1/qrcode?type=png&size=200&info=' + ticketcode
    })
     
  }
})
