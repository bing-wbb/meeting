// pages/user/user/user.js
const app = getApp();
Page({

    /**
     * 页面的初始数据
     */
    data: {
        noticeList:[{'id':1,'title':''} ],
        userInfo: {},
    motto: 'Hello World',
    // orderItems
    orderItems: [
      {
        typeId: 0,
        name: '待审核',
        url: 'bill',
        imageurl: 'https://antique-weichat.oss-cn-beijing.aliyuncs.com/meeting/images/my/daishenhe.png',
      },
      {
        typeId: 1,
        name: '已约',
        url: 'bill',
        imageurl: 'https://antique-weichat.oss-cn-beijing.aliyuncs.com/meeting/images/my/yiyue.png',
      },
      {
        typeId: 2,
        name: '已核销',
        url: 'bill',
        imageurl: 'https://antique-weichat.oss-cn-beijing.aliyuncs.com/meeting/images/my/yihexiao.png'
      },
      {
        typeId: 3,
        name: '已取消',
        url: 'bill',
        imageurl: 'https://antique-weichat.oss-cn-beijing.aliyuncs.com/meeting/images/my/quxiao.png'
      }
    ],
      userInfo: {},
      hasUserInfo: false,
      canIUse: wx.canIUse('button.open-type.getUserInfo'),
      canIUseGetUserProfile: false,
      canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName') // 如需尝试获取用户信息可改为false
    },
  
    /**
     * 生命周期函数--监听页面加载
     */
     onLoad() {
      if (wx.getUserProfile) {
        this.setData({
          canIUseGetUserProfile: true
        })
      }
      console.log('onLoad')

    },
    getUserProfile(e) {
      // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
      wx.getUserProfile({
        desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
        success: (res) => {
          console.log(res)
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    },
    toUser:function(){
        wx.navigateTo({
            url: '../../user/userdertail/userdertail'
          })
    },
    toOrder: function () {
        wx.navigateTo({
          url: '../../my/myorder/myorder'
        })
      },
    getUserInfo(e) {
      // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
      console.log(e)
      this.setData({
        userInfo: e.detail.userInfo,
        hasUserInfo: true
      })
    }
  })