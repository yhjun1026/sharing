//ticket/detail.js
//获取应用实例
var util = require('../../../utils/util.js')

var app = getApp()
Page({
  data:{
    couponInfo: {},
    memberCouponInfo: {},
    title: '',
    validHint: '',
    btnText: '',
    productNo: '',
    couponNo: '',
    couponStatus: ''
  },
  onShareAppMessage: function () {
    return {
      title: '来飞凡，享优惠吧~',
      path: '/pages/index'
      ///pages/ticket/detail/detail?productNo={{ item.productNo }}&couponNo={{ item.couponNo }}&couponStatus={{ item.couponStatus }}
    }
  },
  onLoad: function (options) {
    //console.log('coupon detail onLoad', options);
    this.setData({productNo: options.productNo});
    this.setData({couponNo: options.couponNo});
    this.setData({couponStatus: options.couponStatus});

    var that = this;

    this.sendRequest({
      cmd: 'fetchCouponDetail',
      url: 'https://api.ffan.com/coupon/v2/products/'+this.data.productNo+'?source=1',
      success: (data) => {
        if(data.status == 200){
          for(let i = 0; i < data.data.topPics.length; i++){
            data.data.topPics[i] = 'http://img1.ffan.com/' + data.data.topPics[i];
          }
          that.setData({couponInfo: data.data});

          if(that.data.couponInfo.productType === 1001) {
            that.setData({title: '代金券'});
          }else if (that.data.couponInfo.productType === 1002) {
            that.setData({title: '兑换券'});
          }else if (that.data.couponInfo.productType === 1004) {
            that.setData({title: '停车券'});
          }
          wx.setStorageSync('couponWebDetail', data.data.webDetail);
          //wx.setStorageSync('saleStartTime', data.data.saleStartTime);
          //wx.setStorageSync('validEndTime', data.data.validEndTime);
          wx.setStorageSync('buyNotify', data.data.buyNotify);
        }else{
          wx.showToast({ title: data.message})
        }
      },
      fail: (err) => {
        console.log(err);
      },
    })

    /**
     * 获取指定城市指定广场下的券列表接口(新增)
     */
    //let ffanUser = wx.getStorageSync('ffanUser') || '';
    //console.log(app, typeof(app), typeof(app.services.minaBlueWhale));

    app.services.minaBlueWhale({
      cmd: 'getMemberCouponDetail',
      data: {
        limit: 1000,
        //couponNo: '206996068753',
        couponNo: this.data.couponNo,
        //ffanUid: '15000000001214707',
        //ffanUid: ffanUser.ffanUid;
      },
      success: function(data){
        if(data.status == 200){
          that.setData({memberCouponInfo: data.data});

          let endTime = util.formatTimeStamp(data.data.validEndTime/1000);
          that.setData({validHint: '有效期至：' + endTime});
          wx.setStorageSync('saleStartTime', data.data.validStartTime/1000);
          wx.setStorageSync('validEndTime', data.data.validEndTime/1000);
        }else{
          wx.showToast({ title: data.message})
        }
      },
      fail: function(err){
        console.log(err)
      }
    })

  },

  onReady: function() {
    const that = this;

    console.log('title: ', this.data.title);
    // Do something when page ready.
    wx.setNavigationBarTitle({
      title: this.data.title
    })
  },

  sendRequest: function(opts){
    //let APIURL = 'https://api.ffan.com/ffan/v1/minaBlueWhale';
    let appID = 'wxbed51387744b906f';

    if(opts.data==null) opts.data = {};
    opts.data.token = wx.getStorageSync('token') || '';
    opts.data.appId = appID;

    //opts.url = APIURL + '?action='+ opts.cmd;

    const defOpts = {
      //url: 'test.php', //仅为示例，并非真实的接口地址
      // data: { },
      header: {
        'content-type': 'application/json'
      },
      method: 'GET',
      success: function(res) {},
      fail: function(err) {},
      complete: function() {}
    };

    let options = Object.assign({}, defOpts, opts);
    options.success = function(res){
      if(res.statusCode == 200){
        console.log('success', res);
        typeof(opts.success) === "function" && opts.success(res.data)
      }else{
        typeof(opts.fail) === "function" && opts.fail(res.data)
      }
    }
    options.fail = function(err){
      console.log('fail', err);
      typeof(opts.fail) === "function" && opts.fail(err);
    }
    //console.log('options', options);
    wx.request(options)
  }
})