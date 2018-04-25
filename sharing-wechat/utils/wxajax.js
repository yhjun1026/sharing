if (typeof Object.assign != 'function') {
  Object.assign = function(target, varArgs) { // .length of function is 2
    'use strict';
    if (target == null) { // TypeError if undefined or null
      throw new TypeError('Cannot convert undefined or null to object');
    }

    var to = Object(target);

    for (var index = 1; index < arguments.length; index++) {
      var nextSource = arguments[index];

      if (nextSource != null) { // Skip over if undefined or null
        for (var nextKey in nextSource) {
          // Avoid bugs when hasOwnProperty is shadowed
          if (Object.prototype.hasOwnProperty.call(nextSource, nextKey)) {
            to[nextKey] = nextSource[nextKey];
          }
        }
      }
    }
    return to;
  };
}

/**
 * wx.request
 */
function httpUtil(opts){
  let sessionLost = false
    const defOpts = {
        //url: 'test.php', //仅为示例，并非真实的接口地址
        // data: { },
        header: {
            'content-type': 'application/json'
        },
        method: 'GET'
        // ,
        // success: function(res) {},
        // fail: function(err) {},
        // complete: function() {}
    };
    let options = Object.assign({}, defOpts, opts)
    const ffanUser = wx.getStorageSync('ffanUser') || null
    if (ffanUser) {
      options.data.ffanUid = ffanUser.ffanUid
      options.data.sign = ffanUser.sign
      options.data.openId = ffanUser.openId
      options.data.timestamp = ffanUser.timestamp
    }

    options.success = function(res){
        console.log(res)
        let data = res.data;
        if(typeof data === "string"){
            data = JSON.parse(data.trim())
        }
        if(res.statusCode == 200){
          if(data.status == 4006 && !sessionLost){ //签名超时-服务端session丢失
            sessionLost = true
            ffanUser.sign = data.data.sign
            ffanUser.timestamp = data.data.timestamp

            options.data.sign = ffanUser.sign
            options.data.timestamp = ffanUser.timestamp
            wx.setStorageSync('ffanUser', ffanUser)
            // httpUtil(options)
            wx.request(options)
            return;
           }
           typeof opts.success === "function" && opts.success(data)
        }else{
           typeof(opts.fail) === "function" && opts.fail(data)
        }
    }
    options.fail = function(err){
        typeof(opts.fail) === "function" && opts.fail(err);
    }
    wx.request(options)
}

module.exports = {
  httpUtil: httpUtil
}
