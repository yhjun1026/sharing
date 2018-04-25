let { httpUtil } = require('./wxajax.js')
//let broadcast   = require('./broadcast.js');

module.exports = {
  apiBaseUrl: 'https://api.ffan.com/ffan/v1/minaBlueWhale',

  ffanLogin: function (wxAuth, param) {
    if (!wxAuth) {
      this.login()
      return
    }

    if (wxAuth) {
      let callback = param.callback
      httpUtil({
        url: `${this.apiBaseUrl}?action=login`,
        data: {
          mobile: param.mobile,
          verifyCode: param.verifyCode,
          // openId: ffanUser.openId, // TODO 不一定有
          code: wxAuth.code,
          encryptedData: wxAuth.encryptedData,
          iv: wxAuth.iv
        },
        success: function(res) {
          if (res.status == 200) {
            wx.hideToast()
            // 存储飞凡user profile
            wx.setStorageSync('ffanUser', res.data)
            // that.setData({
            //   name: res.data.nickName
            // })
            typeof callback == 'function' && callback(true, res)
            //broadcast.fire('broadcast events refresh')
          } else {
            typeof callback == 'function' && callback(false, res)
          }
        },
        fail: function(){
          typeof callback == 'function' && callback(false)
          console.error('微信获取用户信息失败')
        }
      })
    }
  },

  getUserProfile: function (wxAuth, callback) {
    httpUtil({
      url: `${this.apiBaseUrl}?action=getUserProfile`,
      data: {
        code: wxAuth.code,
        encryptedData: wxAuth.encryptedData,
        iv: wxAuth.iv
      },
      success: function(data) {

        if (data.status == 200) {
          wx.hideToast()
          // 存储飞凡user profile
          wx.setStorageSync('ffanUser', data.data)
          // this.setData({
          //   name: data.data.nickName
          // })
          typeof callback == 'function' && callback(true)
        } else {
          if (data.data.isRegistered == 0) {
            wx.navigateTo({
              url: "/pages/login/login"
            })
          }else {
            wx.showModal({
              title: '提示',
              content: data.message,
              showCancel: false
            })
          }
        }
      },
      fail: function () {
        typeof callback == 'function' && callback(false)
        console.error('ffan getUserProfile fail')
      }
    })
  },

  /**
   * @param.callback
   * @param.isFfanLogin
   * @param.mobile
   * @param.verifyCode
   */
  wxLogin: function (param) {
    wx.showToast({
        title: '登录中...',
        icon: 'loading',
        duration: 3000
    })
    let callback = param.callback
    wx.login({
      success: (loginRes) => {
        if(!loginRes.code) {
          wx.hideToast()
          return
        }

        wx.getUserInfo({
          success: (userInfoRes) => {
            if(!userInfoRes.encryptedData){
              typeof callback == 'function' && callback(false)
              wx.hideToast()
              return
            }

            const wxAuth = {
              code: loginRes.code,
              encryptedData: userInfoRes.encryptedData,
              iv: userInfoRes.iv
            }
            /*wx.setStorageSync('wxAuth', {
              code: loginRes.code,
              encryptedData: userInfoRes.encryptedData,
              iv: userInfoRes.iv
            })
            console.log('setStorageSync end')*/

            if (param && param.isFfanLogin) {
              this.ffanLogin(wxAuth, param)
            } else {
              this.getUserProfile(wxAuth, callback)
            }

          },
          fail: function (e) {
            if(e.errMsg == "getUserInfo:fail auth deny"){              
              wx.showModal({
                title: '提示',
                showCancel: false,
                content: '授权失败，请10分钟后允许授权再试～',
                success: function(res) {}
              })
            }
            // typeof callback == 'function' && callback(false)
            // console.error('getUserInfo fail')
          }
        })
      },
      fail: function () {
        typeof callback == 'function' && callback(false)
        console.error('wx.login fail')
      }
    })
  },

  /**
   * 登录
   * @param.callback
   * @param.isFfanLogin
   * @param.mobile
   * @param.verifyCode
   */
  login: function (param) {
    wx.showToast({
        title: '加载中...',
        icon: 'loading',
        duration: 3000
    })
    let that = this
    let callback = param.callback
    wx.checkSession({
      success: function () {
        console.log('checkSession success')
        wx.hideToast();

        wx.getUserInfo({
          success: function(res) {
            const ffanUser = wx.getStorageSync('ffanUser') || null
            if (!ffanUser) {
              that.wxLogin(param)
            } else {
              typeof callback == 'function' && callback(true)
            }
          },
          fail: function (e) {
            console.log('getUserInfo fail ' + JSON.stringify(e))
            wx.showModal({
              title: '提示',
              showCancel: false,
              content: '授权失败，请10分钟后允许授权再试～',
              success: function(res) {}
            })
            // if(e.errMsg == "getUserInfo:fail auth deny"){              
            //   // typeof callback == 'function' && callback(false)
            // }
            // else{
            //   that.wxLogin(param)
            // }
          }
        });

      },
      fail: function (e) {
        console.log('checkSession fail ' + e)
        wx.hideToast()
        that.wxLogin(param)
      }
    })
  }

}
