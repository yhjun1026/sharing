const app = getApp()
// var pages = getCurrentPages()
// let curPage = pages[pages.length - 1]
// var Toast
Page({
  data: {
    images: {
      logo: '../../images/login/ffan_logo.png',
      phone: '../../images/login/login_phone_icon.png',
      sms: '../../images/login/login_image_sms.png'
    },
    isSendVerify: false,
    verifyText: '获取短信验证码',
    timmer: 0,
    isAgree: true,
    mobile: '',
    verifyCode: '',
    errorMessage: '',
    btnDisabled: true
  },
  onShareAppMessage: function () {
    return {
      title: '来飞凡，享优惠吧~',
      path: '/pages/index'
    }
  },

  onLoad: function () {
    this.Toast = new app.tools.Toast()
  },

  bindKeyMobile: function (e, type) {
    this.setData({
      mobile: e.detail.value
    })
    this.changeBtnDisabled()
  },

  bindKeyVerify: function (e, type) {
    this.setData({
      verifyCode: e.detail.value
    })
    this.changeBtnDisabled()
  },

  /**
   * 点击已阅读
   * @param  {[type]} e [description]
   * @return {[type]}   [description]
   */
  bindAgreeChange: function (e) {
    this.setData({
      isAgree: !!e.detail.value.length
    });
    this.changeBtnDisabled()
  },

  /**
   * 判断btn是否可点击
   */
  changeBtnDisabled: function () {
    const mobile = this.data.mobile
    const verifyCode = this.data.verifyCode
    const isAgree = this.data.isAgree

    if (mobile && /(^1\d{10})$/.test(mobile) && verifyCode && isAgree) {
      this.setData({
        btnDisabled: false
      })
    } else {
      this.setData({
        btnDisabled: true
      })
    }
  },

  /**
   * 倒计时
   */
  countDown: function () {
    let num = 60
    this.setData({
      verifyText: '60s后重新发送',
      isSendVerify: true
    })
    this.timmer = setInterval(() => {
      num--
      if (num <= 0) {
        this.setData({
          verifyText: '获取验证码',
          isSendVerify: false
        })
        clearInterval(this.timmer)
      } else {
        this.setData({
          verifyText: `${num}s后重新发送`
        })
      }
    }, 1000)
  },

  /**
   * 点击获取验证码
   * @param  {[type]} e [description]
   * @return {[type]}   [description]
   */
  bindGetVerify: function (e) {
    if (!this.data.isSendVerify) {
      if (!this.mobileVerification()) {
        return
      }
      this.countDown()
      app.func.req({
        url: 'https://api.ffan.com/ffan/v1/minaBlueWhale',
        data: {
          action: 'sendVerifyCode',
          mobile: this.data.mobile
        },
        success: (res) => {

        }
      })
    }
  },



  formSubmit: function (e) {
    let that = this
    app.func.auth.login({
      mobile: that.data.mobile,
      verifyCode: that.data.verifyCode,
      isFfanLogin: true,
      callback: function (isLogined, data) {
        if (isLogined) {
          wx.navigateBack()
        } else {
          let message = data && data.message ? data.message : '登录失败，请重试'
          that.setData({
            errorMessage: message
          })
        }
      }
    })
  },

  mobileVerification: function () {
    const mobile = this.data.mobile
    if (!mobile) {
      this.setData({
        errorMessage: '请输入手机号'
      })
      return false;
    } else if (!/(^1\d{10})$/.test(mobile)) {
      this.setData({
        errorMessage: '手机号码格式不正确，请重新输入'
      })
      return false;
    }
    this.setData({
      errorMessage: ''
    })
    return true;
  },

  /*formSubmit: function (e) {
    console.log('formSubmit')
    let obj = e.detail.value
    obj.type = 2
    if (!obj.mobile) {
      this.Toast.toast({
        title: '手机号输入为空',
        titleClassName: 'my_fftoast_title'
      })
      return false
    } else if(!/(^1\d{10})$/.test(obj.mobile)) {
      this.Toast.toast({
        title: '手机号码格式不正确，请重新输入',
        titleClassName: 'my_fftoast_title'
      })
      return false
    }

    if (!obj.verifyCode) {
      this.Toast.toast({
        title: '验证码输入为空',
        titleClassName: 'my_fftoast_title'
      })
      return false
    }
    console.log(11111)
  }*/

})
