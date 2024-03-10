// pages/user/yuyuedetail/yuyuedetail.js
const { add} = require('../../../http/api')
var app = getApp()
Page({

    /**
     * 页面的初始数据
     */
    data: {
      publishInfoList: [],
      arr:['计算机','金融','机械','艺术'],
      index:0,
      path:"",
      hasFile: false,
      name: "",  
      phone: "",  
      member: "",  
      bumen: ""  ,
      emil:"",
      neirong:"",


      orderId:"",
      orderUserId:"",
      orderAppointmentId:"",
      orderPeriodIds:"",
      bz:"",
      createTime:"",
      orderState:"",
      orderMen:"",
      member:"",
      theme:"",
      approval:"",
      themeContent:"",
      member1:"",
      member2:"",
      member3:"",
    },
    formSubmit: function (e) {
   
        let { orderMen,theme,member, themeContent} = e.detail.value;
            // bumen=this.data.arr[0]
        console.log('form发生了submit事件，携带数据为：', e.detail.value);
        this.setData({
            member:member, 
            orderMen:orderMen,  
            theme:theme,
            themeContent:themeContent,
         warn: "",
         isSubmit: true,
        }),
        console.log(e);
        var addOrder={
            orderUserId:this.data.orderUserId,
            orderPeriodIds:this.data.orderPeriodIds,
            orderAppointmentId:this.data.orderAppointmentId,
            member:member, 
            orderMen:orderMen,  
            theme:theme,
            themeContent:themeContent,
        }
        console.log(addOrder);
        add('orderEntity/orderAdd',addOrder).then((res)=>{
            console.log(res);
            wx.showToast({
                title: '预约成功！',
                icon: 'success',
                duration: 2000 //持续的时间
              })
          
        })
        wx.showLoading({

            title: '预约中',
          })
           
          setTimeout(function () {
            wx.hideLoading(),
            wx.switchTab({
                url: '/pages/user/shouye/shouye',
              })
          }, 2000)
       },
       formReset: function () {
        console.log('form发生了reset事件')
       },

  submitFn: function(e){
console.log(e);
  },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        let that= this;
        console.log(options);
        const userId = app.globalData.userId;
        console.log(userId);
        that.setData({
            orderUserId:userId,
            orderPeriodIds:options.userIdsStr,
            orderAppointmentId:options.orderAppointmentId
        })
        console.log(that.data);
      
      wx.request({
        url: '',
        success(res) {
          if (res.statusCode == 200) {
            var allList = res.data.location
            f.setData({
              publishInfoList: allList
            })
          }
        }
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
  
    submitInfo(e) {
      this.setData({
          formId: e.detail.formId,
        },
        (res) => {})
    },
  
    pickerChange(value) {
      console.log(value)
      this.setData({
        index:value.detail.value
      })
    },
  
    /**
     * 选择图片
     */
    onChooseFile() {
      wx.chooseImage({
        success:(resp)=>{
          let imgPath=resp.tempFilePaths;
          console.log(imgPath);
          this.setData({path: imgPath, hasFile: true});
        }
      })
    }
  })
  