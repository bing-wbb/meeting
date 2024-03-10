// pages/user/userdertailupdatepassword/userdertailupdatepassword.js
var app = getApp() 
const { getRoom  } = require('../../../http/api')
Page({

    /**
     * 页面的初始数据
     */
    data: {
        username: '',
        gender: '男',
        array:['通用','金融','机械','计算机','艺术'],
        arraySex:['男','女'],
        index:0,
        userDetailList:[{
            collegeId: "",
            header: "",
            name:  "",
            number:  "",
            password:  "",
            phone:  "",
            role:  "",
            sex: "",
            state:  "",
            userId:  "",
        }]
            
        
      },
      bindPickerChange:function(e){
        console.log(e);
        var collegeId=String(e.detail.value) 
        this.setData({
            index: e.detail.value,
          })
      
      },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        const userId = app.globalData.userId;
        console.log(userId);
        var userNotion={
            collegeId: "",
            header: "",
            name:  "",
            number:  "",
            password:  "",
            phone:  "",
            role:  "",
            sex: "",
            state:  "",
            userId:  "",
        };
        getRoom("userEntity/userDetail?id="+userId).then((res)=>{
            console.log(res);
            userNotion.collegeId=res.data.collegeId
            userNotion.header=res.data.header
            userNotion.name=res.data.name
            userNotion.number=res.data.number
            userNotion.password=res.data.password
            userNotion.phone=res.data.phone
            userNotion.role=res.data.role
            userNotion.sex=res.data.sex
            userNotion.state=res.data.state
            userNotion.userId=res.data.userId

            this.setData({
            index: res.data.collegeId-1,
            userDetailList:userNotion
          })
        })
    },
    formSubmit:function(e){
        //表单返回的所有数据
        var formData=e.detail.value;
        var formData1={
            collegeId: "",
            name:  "",
            number:  "",
            password:  "",
            phone:  "",
            sex: "",
        };
        if(formData.password!=this.data.userDetailList.password){
            wx.showToast({
                title: '旧密码错误',
                icon: 'none',
                duration: 2000
              }); 
        }else if(formData.name==formData.password){
              wx.showToast({
                title: '新密码与旧密码重复',
                icon: 'none',
                duration: 2000
              }); 
        }else{
        formData1.name=formData.name,
        formData1.password=formData.password,
        formData1.userId=app.globalData.userId
        console.log("hfuowrhfiowr");
        console.log(formData1);
        wx.showModal({
            title:'提示',
            content: '是否修改',
            success (res) {
                if (res.confirm) {
                    console.log('用户点击确定')
                    getRoom("userEntity/updataUserPassword",formData1).then((res)=>{
                        console.log(res);
                        wx.switchTab({
                            url: '/pages/user/user/user',
                          })
                    })
                } else if (res.cancel) {
                    console.log('用户点击取消')
                }
            }
        })
        }

  
        console.log(e.detail.value);  
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

    }
})