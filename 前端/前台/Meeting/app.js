// app.js
App({
    globalData: {
        userId:1
      },
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
  },
  loadFontFace() {    
    const self = this
    wx.loadFontFace({
      family: 'Alibaba-PuHuiTi-Heavy',// 自定义字体的名字 随便起就可以
      source: 'url("/ttf/Alibaba-PuHuiTi-Heavy.ttf")',//这里填写第二步获取的下载地址
      success(res) {
        console.log(res.status)
        self.setData({ loaded: true })
      },
      fail: function(res) {
        console.log(res.status)
      },
      complete: function(res) {
       console.log(res.status)
      }
    });
    wx.loadFontFace({
        family: 'Alibaba-PuHuiTi-Bold',// 自定义字体的名字 随便起就可以
        source: 'url("/ttf/Alibaba-PuHuiTi-Bold.ttf")',//这里填写第二步获取的下载地址
        success(res) {
          console.log(res.status)
          self.setData({ loaded: true })
        },
        fail: function(res) {
          console.log(res.status)
        },
        complete: function(res) {
         console.log(res.status)
        }
      });
      wx.loadFontFace({
        family: 'Alibaba-PuHuiTi-Medium',// 自定义字体的名字 随便起就可以
        source: 'url("/ttf/Alibaba-PuHuiTi-Medium.ttf")',//这里填写第二步获取的下载地址
        success(res) {
          console.log(res.status)
          self.setData({ loaded: true })
        },
        fail: function(res) {
          console.log(res.status)
        },
        complete: function(res) {
         console.log(res.status)
        }
      });
  },
 

  ajax: {
    get: (url, data, header) => {
      return getApp().ajax.request(url, data, header, 'GET')
    },
    post: (url, data, header) => {
      return getApp().ajax.request(url, data, header, 'POST')
    },
    request(url, data, header = {}, method) {
      const vm = this
      wx.showLoading()
      if (wx.getStorageSync('userInfo').accessToken) {
        let token = {
          "access-token": wx.getStorageSync('userInfo').accessToken
        }
        Object.assign(header, token)
      }
      return new Promise((resolve, reject) => {
        wx.request({
          url: `http://localhost:8090`,
          data,
          header,
          method,
          success(res) {
            wx.hideLoading()
            if (res.statusCode == 200) {
              if (res.data.code == 200) {
                resolve(res.data)
              } else if (res.data.code == 401) {
                wx.showToast({
                  title: res.data.msg || '请重新登录！',
                  icon: "none"
                })
                reject(res.data)
                wx.navigateTo({
                  url: `/pages/index/index`
                })
              } else if (res.data.code == 402) {
                reject(res.data)
                wx.navigateTo({
                    url: `/pages/login/login`
                  })
              } else if (res.data.code == 403) {
                wx.showToast({
                  title: res.data.msg || '没有权限！',
                  icon: "none"
                })
                reject(res.data)
              } else {
                wx.showToast({
                  title: res.data.msg || '请求失败！',
                  icon: "none"
                })
                reject(res.data)
              }
            } else {
              wx.showToast({
                title: res.data.msg || '请求失败！',
                icon: "none"
              })
              reject(res)
            }
          },
          fail() {
            reject({
              msg: '请求失败',
              url: vm.withBaseURL ? vm.baseURL + url : url,
              method,
              data
            })
          }
        })
      })
    },
}
})

