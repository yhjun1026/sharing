let {httpUtil}    = require('./utils/wxajax.js');
let {minaBlueWhale,plazas}    = require('./utils/services.js');
let {tracking}    = require('./utils/tracking.js');
let broadcast   = require('./utils/broadcast.js');
let util        = require('./utils/util.js')
let auth        = require('./utils/auth.js')
let { Toast }   = require('./templates/toast/toast.js');

//
App({
    onLaunch: function () {
        //调用API从本地缓存中获取数据
        var logs = wx.getStorageSync('logs') || []
        logs.unshift(Date.now())
        wx.setStorageSync('logs', logs)

        try {
        var res = wx.getSystemInfoSync()
        this.globalData.systemInfo = res;
        console.log(JSON.stringify(this.globalData.systemInfo))
        } catch (e) {
        // Do something when catch error
        }

        try {
        var value = wx.getStorageSync('uid')
        if (value) {
            this.globalData.uid = value;
        }else{
            let newUUID = util.uuid()
            this.globalData.uid = newUUID;
            wx.setStorage({
            key: 'uid',
            data: newUUID
            });

        }
        } catch (e) {
        // Do something when catch error
        }

    },
    onShow: function () {        
    },
    onHide: function () {        
    },
    globalData: {
        hasLogin: false,
        userInfo:null,
        systemInfo:null,
        ffanInfo:null,
        uid:null,
        auth: null,
        signature:null,
        openId:null
    },
    getUserInfo: function(cb){
        var that = this
        this.globalData.userInfo = null

        if(this.globalData.userInfo){
            typeof cb == "function" && cb(this.globalData.userInfo)
        }else{
            //调用登录接口
            wx.login({
                success: function () {
                wx.getUserInfo({
                    success: function (res) {
                    console.log('res:', res)
                    that.globalData.userInfo = res.userInfo
                    // that.globalData.signature = res.signature
                    console.info(that.globalData.userInfo)
                    // console.info(that.globalData.signature)
                    typeof cb == "function" && cb(that.globalData.userInfo)
                    }
                })
                }
            })
        }
    },
    func: {
        util: util,
        broadcast: broadcast,
        req: httpUtil,
        auth: auth,
        tracking: function(event_id, obj, callback){
            let app = getApp();
            let params = Object.assign({}, app.globalData.userInfo, app.globalData.systemInfo, {
                'user_id': app.globalData.uid
            }, obj)
            tracking(event_id, params, callback)
        }
    },
    services: {
        minaBlueWhale,
        plazas
    },
    tools: {
        Toast: Toast
    }
});