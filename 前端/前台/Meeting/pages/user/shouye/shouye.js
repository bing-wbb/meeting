// pages/user/shouye/shouye.js
var app = getApp()
// const { addGoods  } = require('../../../http/api')
const { getNotice} = require('../../../http/api')
var Url = app.globalData.Url
var login = app.globalData.login
var register = app.globalData.register

Page({

  /**
   * 页面的初始数据
   */
  data: {
    username: "",
    password: "",
    logincard: true,
    registercard: false,
    loginanimation: "",
    registeranimation: "",
    newname: "",
    newpassword: "",
    geyan: "",
    userInfo: {},
      hasUserInfo: false,
      canIUse: wx.canIUse('button.open-type.getUserInfo'),
      canIUseGetUserProfile: false,
      canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName') // 如需尝试获取用户信息可改为false
  },
  getyuyue() {
    wx.switchTab({
      url: '/pages/user/yuyue/yuyue',
    })
  },
  getgonggao(){
    wx.switchTab({
        url: '/pages/user/notice/notice',
      })
  },
  gettongzhi(){
    wx.navigateTo({
        url: '/pages/user/notify/notify',
      })
    
  },
  getmyyuyue(){
    wx.navigateTo({
        url: '/pages/my/myorder/myorder',
      })
  },
  getmyaddress(){
    wx.switchTab({
        url: '/pages/user/calendar/calendar',
      })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    const userId = app.globalData.userId;
    console.log(userId);
    var that = this;
    wx.request({
        url: 'https://v1.hitokoto.cn',
        method: 'POST',
        success: function(res) {
          console.log(res.data.hitokoto);
          that.setData({
              geyan:res.data.hitokoto,
            })
        }
      });
      var json1={
        id:userId
      }
    getNotice('userEntity/userDetail?id='+userId).then((res)=>{
    // var param = {};
    // var string = "itemList["+0+"].subArr";
    // param[string] = res.data.records;
    console.log(res);
    that.setData({
        username:res.data.name
    });
    // console.log(this.data.noticeList);
    })

      
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  },
  getUsername(e) {
    console.log(e);
    this.setData({
      username: (e.detail.value).trim()
    })

  },
  getPassword(e) {
    this.setData({
      password:(e.detail.value).trim()
    })
  },
  getNewName(e) {
    this.setData({
      newname: (e.detail.value).trim()
    })
  },
  getNewPassword(e) {
    this.setData({
      newpassword: (e.detail.value).trim()
    })
  },
  login() {
    wx.switchTab({
        url: '/pages/user/shouye/shouye',
      })
    var that = this
    if (that.data.username == "") {
      wx.showToast({
        title: '账号不能为空',
        icon: 'none'
      })
    } else if (that.data.password == "") {
      wx.showToast({
        title: '密码不能为空',
        icon: 'none'
      })
    } else {
    }

  },
  switchCard() {
    if (this.data.logincard) {
      this.setData({
        loginanimation: 'fade-out-bck',
      })
      setTimeout(() => {
        this.setData({
          logincard: false,
          registercard: true,
          registeranimation: 'fade-in-bck',
          newname:"",
          newpassword:""
        })
      }, 500);
    } else {
      this.setData({
        registeranimation: 'fade-out-bck'
      })
      setTimeout(() => {
        this.setData({
          registercard: false,
          logincard: true,
          loginanimation: 'fade-in-bck',
          username:"",
          password:""
        })
      }, 500);
    }
  },
  register() {
    if (this.data.newname == "") {
      wx.showToast({
        title: '新账号不能为空',
        icon: 'none'
      })
    } else if (this.data.newpassword == "") {
      wx.showToast({
        title: '密码不能为空',
        icon: 'none'
      })
    } else {
      wx.request({
        url: Url + register,
        data: {
          newname:this.data.newname,
          newpassword:this.data.newpassword
        },
        success:(res)=>{
          if(res.data){
            wx.showToast({
              title: '注册成功，快去登陆吧:)',
              icon: 'none'
            })
          }else{
            wx.showToast({
              title: '此账号已存在',
              icon: 'none'
            })
          }
        }
      })
    }
  }
})
