let cityObj   = require('./citylist.js');
//接口数据来自：https://api.ffan.com/v1/cdaservice/citys

//城市检索的首字母
var arrLetters = ["A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "W", "X", "Y", "Z"]

//对城市信息进行分组
function cityList() {
    
    var tempObj=[];
    for (var i = 0; i < arrLetters.length; i++) {
        var initial = arrLetters[i];
        var cityInfo = [];
        var tempArr = {};
        tempArr.initial = initial;
        for (var j = 0; j < cityObj.length; j++) {
            if (cityObj[j].cityPinYin.indexOf(initial.toLowerCase())==0) {
                cityInfo.push(cityObj[j]);
            }
        }
        tempArr.cityInfo = cityInfo;
        tempObj.push(tempArr);
    }
    return tempObj;
}

module.exports = {
    searchLetter: arrLetters,
    cityList: cityList
}