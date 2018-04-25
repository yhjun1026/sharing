//index.js
//获取应用实例
var app = getApp()
let mytoast
let { httpUtil } = require('../utils/wxajax.js')
//
Page({
  data: {
    // kvImg: 'https://nres.ffan.com/newh5/2017116/67a58c652239534502aeb2a63f0222d3e19dcbf8.jpg',
    kvImg: 'https://timg.ffan.com/convert/resize/url_T1PJbTB4WT1RCvBVdK/tfs/55bb36fcc587540724e0621fbb33d241.png',
    couponList: [],
    imgurl:'',
    currentCity:'上海',
    square:[
      '江桥万达广场'
    ],
    index:0,
    isRefresh: false,
    isNoMore: false
  },
  onShareAppMessage: function () {
    return {
      title: '来飞凡，享优惠吧~',
      path: '/pages/index'
    }
  },
  onLoad: function () {
    mytoast = new app.tools.Toast()
    this.getIndexData()

    this.Toast = new app.tools.Toast()
  },
  onReady: function(){
    var that = this
    that.refresh()
    app.func.broadcast.on('changeCityEvent', function(data, event) {
      if(data.city){
        that.setData({
          currentCity: data.city
        })
      }
    });
  },
  refresh: function(){
    var that = this
    // that.setData({
    //   couponList : dataSource
    // })
  },

  getIndexData: function(){
    //首页券列表
    var that = this
    httpUtil({
      url: 'https://api.ffan.com/ffan/v1/minaBlueWhale?action=fetchCoupons',
      data:{

      },
      success: function(res){
        console.log('首页列表：',res.data)
        if(res.status == 200){
          res.data.datas.forEach(item => {
            item.imgurl = that.getImageUrl(item.topPics[0]),
            item.couponStatus = 9,
            item.btnTxt = '立即领取'
          })

          that.setData({
            couponList : res.data.datas,
            num : res.data.count
          })
        }
      },
      fail: function(err){
        mytoast.toast({
          title: err.message,
          titleClassName: 'my_fftoast_title'
        })
      }
    })
  },

  getImageUrl (strImage) {
    // NOTE: 电影后台返回的空海报竟然用了双单引号作为空，那么多处理下吧
    if (strImage && strImage !== "''") {
      return "https://img1.ffan.com/norm_105/"+strImage
    } else {
      return ''
    }

  },
  changeCity: function() {
     mytoast.toast({
      // img: "",
      // imgClassName: "",
      // imgMode: "",
      title: '目前仅开放上海市，敬请期待其他城市的开启！',
      titleClassName: 'my_fftoast_title',
      // duration: 1500,
      success (data) {
        console.log(Date.now() + ': success')
      },
      fail (data) {
        console.log(Date.now() + ': fail')
      },
      complete (data) {
        console.log(Date.now() + ': complete')
      }
    })
  },

  getTicket: function (e,id) {
    app.func.auth.login({
      callback: (isLogined) => {
        if (isLogined) {
          console.log('getTicket')
          this.getCoupon(e,id)
        } else {
          this.Toast.toast({
            title: '登录失败请重试',
            titleClassName: 'my_fftoast_title'
          })
        }
      }
    })
  },

  bindPickerChange:function(e){
    this.setData({
      index: e.detail.value
    })
  },
  getCoupon:function(e){
    var that = this

    //领券接口
    console.log(e)
    var productNo = e.currentTarget.dataset.no
    var id = e.currentTarget.dataset.id

    that.data.couponList[id].btnTxt = '领券中...'

    that.setData({
      couponList : that.data.couponList
    })

    httpUtil({
      url:'https://api.ffan.com/ffan/v1/minaBlueWhale?action=sendCoupon',
      data: {
        productNo:productNo
      },
      success: function(res){
        console.info('getCoupondata:',res.data)
        if(res.status == 200){
          that.data.couponList[id].couponStatus = res.data[0].status
          that.data.couponList[id].couponNo = res.data[0].couponNo
          that.setData({
            couponList : that.data.couponList
          })
        }else {
          wx.showToast({
            title: '领取失败:'+res.message,
            icon: 'success',
            duration: 2000
          })
        }
      },
      fail: function(err){
        mytoast.toast({
          title: err.message,
          titleClassName: 'my_fftoast_title'
        })
      }
    })
  }
  // onPullDownRefresh: function() {
  //   // Do something when pull down.
  //   var that = this
  //   that.setData({
  //     isRefresh = true
  //   })
  // }
})
