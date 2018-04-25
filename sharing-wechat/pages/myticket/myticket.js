/**
 * 我的券
 */
var app = getApp()
var page = getCurrentPages()
var { httpUtil } = require('../../utils/wxajax.js')
var dateFormat = require('../../utils/dateformat.js')

var sliderWidth = 96; // 需要设置slider的宽度，用于计算中间位置
var dataSource = [];
//
Page({
  data: {
    text: "This is page data.",
    userInfo: {},
    tabs: [
      {
        text:'未使用',
        status:'3'
      },
      {
        text:'已使用',
        status:'4'
      },
      {
        text:'已过期',
        status:'6'
      }
    ],
    hasNoMore: false,
    hasRefesh: false,
    activeIndex: '',
    sliderOffset: 0,
    sliderLeft: 0,
    scrollHeight: 100,
    ticketList: dataSource,
    key:'',
    length:'1'
  },
  onShareAppMessage: function () {
    return {
      title: '来飞凡，享优惠吧~',
      path: '/pages/index'
    }
  },
  onLoad: function(options) {
    // var that = this;
    // console.info('第一次load')
    // that.pageDataOnload()
  },
  onReady: function() {
    // Do something when page ready.
  },
  onShow: function(e) {
    // this.show()
    // Do something when page show.
    var that = this;
    console.info('第二次show')
    that.pageDataOnload()
    console.info('activeIndex:',that.data.activeIndex)
  },
  onHide: function() {
    // Do something when page hide.
  },
  onUnload: function() {
    // Do something when page close.
  },
  onPullDownRefresh: function() {
    // Do something when pull down.
  },
  onReachBottom: function() {
    // Do something when page reach bottom.
  },
  pageDataOnload: function(){
    app.func.auth.login({
      callback: (isLogined) => {
        if(isLogined){
          var that = this

          //调用应用实例的方法获取全局数据
          app.getUserInfo(function(userInfo){
            console.info('userInfo:',userInfo)
            //更新数据
            that.setData({
              userInfo:userInfo
            })
          });
          
          wx.showToast({
            title: '数据加载中...',
            icon: 'loading',
            duration: 500
          })

          console.log('activeIndex:',that.data.activeIndex)
          console.log(typeof(that.data.activeIndex))
          if(that.data.activeIndex && that.data.activeIndex== '0'){
            that.setData({
              key:'3'
            })
          }else if(that.data.activeIndex && that.data.activeIndex == '1'){
            that.setData({
              key:'4'
            })
          }else if(that.data.activeIndex && that.data.activeIndex == '2'){
            that.setData({
              key:'6'
            })
          }else{
            that.setData({
              key:'3'
            })
          }

          if(that.data.key){
            console.log(that.data.key)
            that.fetchUserCoupons(that.data.key)
          }
          

          wx.getSystemInfo({
              success: function(res) {
                  that.setData({
                      sliderLeft: (res.windowWidth / that.data.tabs.length - sliderWidth) / 2,
                      scrollHeight: res.windowHeight - 100
                  });
              }
          });
        }else {
          console.ware('登录失败')
          this.Toast.toast({
            title: '登录失败请重试',
            titleClassName: 'my_fftoast_title'
          })
        }
      }

    })
  },
  fetchUserCoupons: function(key){
    //即将过期时间为3天 24*3*60*60 = 259200
    var timestamp = Date.parse(new Date());
    timestamp = timestamp / 1000;
    //当前时间戳为：1403149534
    console.log("当前时间戳为：" + timestamp);

    console.info('fetchUserCoupons')
    console.info('key:',key)
    var that = this
    httpUtil({
      url:'https://api.ffan.com/ffan/v1/minaBlueWhale?action=fetchUserCoupons',
      data:{
        limit: 1000,
        status:key
      },
      success: function(res){
        console.info('券：',res)
        if (res && res.status == 200) {
          res.data.coupons.forEach( item => {
            var itemendtime = item.validEndTime.toString().substring(0,10)
            if( itemendtime - timestamp <= 259200){
              console.info('即将过期，3天后过期')
              item.isoverdue = true
            }else {
              item.isoverdue = false
            }

            item.endtime = dateFormat(item.validEndTime,'yyyy-mm-dd HH:MM')
            item.usetime = dateFormat(item.useTime,'yyyy-mm-dd HH:MM')
          })
          that.setData({
            ticketList : res.data.coupons,
            length : res.data.coupons.length
          })
        } else {
          console.log(res.message)
        }
      },
      fail: function(){

      }
    })
  },
  // Event handler.
  tabClick: function (e) {
      var that = this
      wx.showToast({
        title: '数据加载中...',
        icon: 'loading',
        duration: 500
      })

      that.fetchUserCoupons(e.currentTarget.dataset.status)

      that.setData({
          sliderOffset: e.currentTarget.offsetLeft,
          activeIndex: e.currentTarget.id
      });

  },
  handleUpper: function(e){
    //refesh
    console.log("upper");
    var that = this;
    // that.setData({
    //     hasRefesh:true,
    // });
    wx.showNavigationBarLoading()
    // that.refresh();
    setTimeout(function(){wx.hideNavigationBarLoading();wx.stopPullDownRefresh();}, 2000);
  },
  handleLower: function(e){
    //loadMore
    console.log("Lower");
    var that = this;
    wx.showNavigationBarLoading();
    setTimeout(function(){wx.hideNavigationBarLoading();that.nextLoad();}, 1000);
  },
  onPullDownRefresh: function(){
    // Do something when pull down.
    console.log('刷新 onPullDownRefresh');
    var that = this;
    // that.setData({
    //   hasRefesh:true
    // });
  },
  onReachBottom: function(){
    // Do something when page reach bottom.
    console.log('onReachBottom 下一页');
    var that = this;

    // that.setData({
    //   hasRefesh : true,
    //   hasNoMore : false
    // });
  },
  refresh: function(){
    var key
    if(this.activeIndex == 0){
      key = 3
    }else if(this.activeIndex == 1){
      key = 4
    }else if(this.activeIndex == 2){
      key = 6
    }else{
      key = 3
    }

    this.fetchUserCoupons(key)
  },
  nextLoad: function(){

    console.log("continueload");

    if(this.data.ticketList.length > 20){
      // this.setData({
      //   hasRefesh: false,
      //   hasNoMore : true
      // })
      console.log('no more data');
      return;
    }

    var next_data = dataSource;
    this.setData({
      ticketList: this.data.ticketList.concat(next_data)
    });
  }
})
