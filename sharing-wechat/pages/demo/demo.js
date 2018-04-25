var app = getApp()
var pages = getCurrentPages()
let curPage = pages[pages.length - 1]
let mytoast

Page({
  data: {
    text: "This is page data.",
    demoLinks:[{
      type: 'tab',
      title: 'about',
      url: '../about/about'
    },{
      title: 'demo',
      url: '../demo/demo'
    },{
      title: 'login',
      url: '../login/login'
    }]
  },
  onShareAppMessage: function () {
    return {
      title: '来飞凡，享优惠吧~',
      path: '/pages/index'
    }
  },
  onLoad: function(option) {
    console.log(option.query)
    
    // Do some initialize when page load.
    mytoast = new app.tools.Toast()
  },
  onReady: function() {
    // Do something when page ready.
    wx.setNavigationBarTitle({
        title:'demo onReady'
    });

    /**
     * tracking Demo and broadcast DEMO
     */
    app.func.tracking('WXAPP-HOMEINDEX-ONLOAD')

    app.func.broadcast.on('eventH', function(data, event){
      console.log(data)
    });

    app.func.broadcast.fire('eventH', [1,2,3]);

    // app.func.apis.cities().then(function(res) {
    //   // console.log(res)
    // }, err=>{
    //   // console.error(err)
    // }).catch(err=>{
    //   // console.error(err)
    // });

    // app.func.apis.verifycode().then(function(res) {
    //   // console.log(res)
    // }, err=>{
    //   // console.error(err)
    // }).catch(err=>{
    //   // console.error(err)
    // });

  },
  onShow: function() {
    // Do something when page show.
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
  // Event handler.
  viewTap: function() {
    this.setData({
      text: 'Set some data for updating view.'
    })
  },
  customData: {
    hi: 'MINA'
  },
  formSubmit: function(e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
  },
  formReset: function() {
    console.log('form发生了reset事件')
  },
  handleTapToast: function(e){
    this.login();

    return

    wx.getUserInfo({
      success: function(res) {
        console.log(res);
      }
    })
    wx.login({
      success: function(res) {
        if (res.code) {
          //发起网络请求
          console.log(`res.code = ${res.code}`)
        } else {
          console.log('获取用户登录态失败！' + res.errMsg)
        }
      }
    })

    mytoast.toast({
      // img: "",
      // imgClassName: "",
      // imgMode: "",
      title: '加载中...',
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
    });
    
    /**
     * 获取指定城市指定广场下的券列表接口(新增)
     */
    app.services.minaBlueWhale({
      cmd: 'fetchCoupons',
      data: {
        test:'ok'
      },
      success: function(data){
        console.log(data)
      },
      fail: function(err){
        console.log(err)
      }
    });
    /**
     * 获取指定城市指定广场列表
     */
    app.services.plazas({
      data: {
        cityId:'310100'
      },
      success: function(data){
        console.log(data)
      },
      fail: function(err){
        console.log(err)
      }
    })

  },
  login: function(that){

        const ffanUser = wx.getStorageSync('ffanUser') || null
        if(ffanUser){
            // that.setData({
            //     name: ffanUser.name
            // })
            return
        }

        wx.showToast({
            title: '登录中...',
            icon: 'loading',
            duration: 3000
        })

        wx.login({
            success: (loginRes) => {

                if(!loginRes.code) {
                    wx.hideToast()
                    return
                }

                wx.getUserInfo({
                    success: (res) => {
                        if(!res.encryptedData){
                            wx.hideToast()
                            return
                        }

                        app.services.minaBlueWhale({
                          cmd: 'getUserProfile',
                          data: {code: loginRes.code, encryptedData: res.encryptedData, iv: res.iv},
                          success: function(data){
                            console.log(data)
                            if(data.status == 4001){
                                //New User
                                wx.navigateTo({ url: '/pages/login/login' })

                              }else if(data.status == 200){
                                wx.hideToast()
                                wx.setStorageSync('token', data.data.token)
                                wx.setStorageSync('ffanUser', data.data.ffanUser)
                                that.setData({
                                    name: data.data.name
                                });
                                //broadcast.fire('broadcast events refresh')
                              }

                          },
                          fail: function(err){
                            console.log(err)
                          }
                        });

                        // app.func.req({
                        //   url: 'api/sign',
                        //   data: {code: loginRes.code, encryptedData: res.encryptedData, iv: res.iv},
                        //   success: function(res) {

                        //       if(res.status==401){
                        //         //New User
                        //         wx.navigateTo({
                        //           url: 'pages/login/login'
                        //         })
                        //       }else if(res.status==200){
                        //         wx.hideToast()
                        //         wx.setStorageSync('token', data.data.token)
                        //         wx.setStorageSync('ffanUser', data.data.ffanUser)
                        //         that.setData({
                        //             name: data.data.name
                        //         });
                        //         //broadcast.fire('broadcast events refresh')
                        //       }

                        //   },
                        //   fail: function(){
                        //     //fail  
                        //   }
                        // })


                    }
                })
            }
        });


    }
})
