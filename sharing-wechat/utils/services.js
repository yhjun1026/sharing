import { httpUtil } from './wxajax'

let APIURL = 'https://api.ffan.com/ffan/v1/minaBlueWhale'
let appID = 'wx7edeeb3edee2b00e'

// 1.获取小程序用户对应的飞凡用户profile以及sign接口(新增)
// 2.登陆即注册接口（新增）
// 3.短信验证码接口（新增）
// 4.获取我的票券列表（新增）
// 5.获取指定城市指定广场下的券列表接口(新增)
// 6.领券接口 (新增)

// 7.券详情接口(待徐敏确认)
// 8.获取券的适用门店接口

/**
 * 统一接口调用方法
 * opts: {
 * cmd: [getUserProfile,login,sendVerifyCode,fetchUserCoupons,fetchCoupons,sendCoupon]
 * 1. getUserProfile: {action,code,encryptedData,iv}
 * 2. login: {mobile,code,openId,encryptedData,verifyCode}
 * 3. sendVerifyCode: {mobile}
 * 4. fetchUserCoupons: {ffanUid,status,sign,openId}
 * 5. fetchCoupons: {}
 * 6. sendCoupon: {ffanUid,productNo,sign,openId}
 * }
 */
function minaBlueWhale(opts){
    if(opts.data==null) opts.data = {};
    let ffanUser = wx.getStorageSync('ffanUser') || '';
    opts.data.ffanUid = ffanUser.ffanUid;
    opts.data.openId = ffanUser.openId;
    // opts.data.appId = appID;

    let defaultOpts = {
        cmd: "getUserProfile",
        data: null
    }
    opts.url = APIURL + '?action='+ opts.cmd;

    httpUtil(opts);
}

/**
 * 广场列表
 */
function plazas(opts){
    opts.url = 'http://api.ffan.com/ffan/v2/city/plazas' //?cityId=310100
    httpUtil(opts);
}

module.exports = {
  minaBlueWhale: minaBlueWhale,
  plazas: plazas
}
