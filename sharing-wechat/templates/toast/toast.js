/**
 * FFan Toast for WX App
 * Created by Peter
 * 
 * DEMO
 * 
 * let mytoast = new app.tools.Toast()
 * mytoast.toast({
      // img: "",           //提示的图片，网络地址或base64
      // imgClassName: "",  //自定义图片样式时使用的class
      // imgMode: "",       //参考小程序image组件mode属性
      title: '加载中...',    //提示的内容
      titleClassName: 'my_fftoast_title',//自定义内容样式时使用的class
      // duration: 1500,    //提示的持续时间，默认1500毫秒
      success (data) {      //提示即将隐藏时的回调函数
        console.log(Date.now() + ': success')
      },
      fail (data) {         //调用过程抛出错误时的回调函数
        console.log(Date.now() + ': fail')
      },
      complete (data) {     //调用结束时的回调函数
        console.log(Date.now() + ': complete')
      }
    })
 * 
 */

function FfToastClass () {

    function FfToast () {
        let pages = getCurrentPages()
        let curPage = pages[pages.length - 1]
        this.__page = curPage
        this.__timeout = null

        //附加到page上，方便访问
        curPage.fftoast = this
        
        return this
    }

    //切换显示/隐藏
    FfToast.prototype.toast = function(data) {
        try {
            if (!data) {
                this.hide()
            } else {
                this.show(data)
            }
        } catch (err) {
            console.error(err)
            
            // fail callback
            data && typeof data.fail === 'function' && data.fail(data)
        } finally {
            // complete callback
            data && typeof data.complete === 'function' && data.complete(data)
        }
    }

    //显示
    FfToast.prototype.show = function(data) {
        let page = this.__page

        clearTimeout(this.__timeout)

        //display需要先设置为block之后，才能执行动画
        page.setData({
            '__fftoast__.reveal': true
        })

        setTimeout(()=>{
            let animation = wx.createAnimation()
            animation.opacity(1).step()
            data.animationData = animation.export()
            data.reveal = true
            page.setData({
                __fftoast__: data
            })
        },30)

        if (data.duration === 0) {
            // success callback after toast showed
            setTimeout (() => {
                typeof data.success === 'function' && data.success(data)
            }, 430)
        } else {
            this.__timeout = setTimeout(() => {
                this.toast()

                // success callback
                typeof data.success === 'function' && data.success(data)
            }, (data.duration || 1500) + 400)
        }

    }

    //隐藏
    FfToast.prototype.hide = function() {
        let page = this.__page
        
        clearTimeout(this.__timeout)

        if (!page.data.__fftoast__.reveal) {
            return
        }
        
        let animation = wx.createAnimation()
        animation.opacity(0).step()
        page.setData({
            '__fftoast__.animationData': animation.export()
        })
        
        setTimeout(() => {
            page.setData({
                __fftoast__: {'reveal': false}
            })
        }, 400)
    }

    return new FfToast()
}

module.exports = {
    Toast: FfToastClass
}