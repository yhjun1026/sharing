/**
 * 统一的事件管理中心
 * 
    var broadcast = require("./broadcast.js");
    //事件注册
    broadcast.on("testEvent", function(data, event) {
        console.log(event); // test
        console.log(data); // [1,2,3]
    });
    //事件广播
    broadcast.fire("testEvent", [1,2,3]);
 * 
 */

var broadcast;

broadcast = {
  on: function(name, fn) {
    var eventData;
    eventData = broadcast.data;
    if (eventData.hasOwnProperty(name)) {
      eventData[name].push(fn);
    } else {
      eventData[name] = [fn];
    }
    return this;
  },
  fire: function(name, data, thisArg) {
    var fn, fnList, i, len;
    thisArg = thisArg;
    fnList = broadcast.data[name];
    if (!fnList.length) {
      throw new Error("Cannot find broadcast event " + name);
    }
    for (i = 0, len = fnList.length; i < len; i++) {
      fn = fnList[i];
      fn.apply(thisArg, [data, name]);
    }
    return this;
  },
  data: {}
};

module.exports = broadcast;