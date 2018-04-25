/**
 * 
 * 埋点工具
 * 
 */
import { httpUtil } from './wxajax'
import CONFIGS      from './config'
import dateFormat from './dateformat';

const LOG_TYPE = 50
const  HOST = CONFIGS.APIHOST
let url = HOST + "ffan/v1/mxlog?"

let content = {
  "event_log": [
    {}
  ]
};

// 增加event_log里的值
function addEventLogParams(event_id) {
  let eventLog = content.event_log[0];

//   mergeData(DEFAULT_EVENT_DATA, eventLog);
  eventLog.event_time = dateFormat(new Date(), "yyyy-mm-dd HH:MM:ss");
  eventLog.promotion_from = "wxapp";
  eventLog.event_id = event_id;

//   if (!eventLog['user_id']) {
//     eventLog['user_id'] = app.globalData && app.globalData.uid;
//   }

}

/**
 * send
 * @param event_id
 * @param obj
 * @param callback
 */
function send(event_id, obj, callback){

    let eventLog = content.event_log[0];

    addEventLogParams(event_id);

    if (obj) {
        for (var key in obj) {
            eventLog[key] = obj[key]
        }
    }

    console && console.log('++++++++++++++');
    console && console.log(content);

    url += "content=" + encodeURIComponent(JSON.stringify(content)) + "&type=" + LOG_TYPE;
            
    httpUtil({
        url: url,
        complete: function() {
            if (typeof callback === 'function') {
                callback()
            }
        }
    });
}

module.exports = {
  tracking: send
}