// pages/user/log/log.js
const { addGoods} = require('../../../http/api')
var app = getApp()
var Url = app.globalData.Url
// var login = app.globalData.login
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
    number:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

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
        number: parseInt(e.detail.value)
    })

  },
  getPassword(e) {
    console.log(e);
    this.setData({
        password: e.detail.value
    })
  },
  getNewName(e) {
    console.log(e);
    this.setData({
      newname: (e.detail.value).trim()
    })
  },
  getNewPassword(e) {
    console.log(e);
    this.setData({
      newpassword: (e.detail.value).trim()
    })
  },
  login() {
      var json1={
        password:this.data.password,
        number:parseInt(this.data.number) 
      }
      console.log(json1);
      addGoods('userEntity/userLogin',json1).then((res)=>{
          console.log(res.data.name);
          if(res.data.name==null){
            app.globalData.userId= res.data.userId,
            console.log(app.globalData.userId);
            wx.navigateTo({
                url: `/pages/user/userdertail/userdertail`,
           })
          }else{
            app.globalData.userId= res.data.userId,
            console.log(app.globalData.userId);
            wx.switchTab({
                url: `/pages/user/shouye/shouye`,
           })
          }
          
      }).catch((err)=>{
        console.log(err);
    })
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
    var json2={
        password:this.data.newpassword,
        number:parseInt(this.data.newname) 
        }
        console.log(json2);
        addGoods('userEntity/register',json2).then((res)=>{
            console.log(res.data);
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
        }).catch((err)=>{
        console.log(err);
    })
    }
  }
})
