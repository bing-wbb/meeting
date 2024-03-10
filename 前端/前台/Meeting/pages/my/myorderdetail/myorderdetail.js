// pages/my/myorderdetail/myorderdetail.js
// var app = getApp() 
const { getRoom  } = require('../../../http/api')
Page({

    /**
     * 页面的初始数据
     */
    data: {

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        console.log(options);
        var orderId=parseInt(options.id)
        console.log(orderId);
        getRoom("orderEntity/selectUserOrder?page=0&limit=1000&orderId="+orderId).then((res)=>{
            console.log(res);
            this.setData({
                detailList:res.data.records[0],
            });
                            // 将时间ids转化为时间段
        getRoom("orderEntity/idToTIme?ids="+res.data.records[0].appointmentPeriodIds).then((res)=>{
            console.log(res);
            this.setData({
                times:res.data
            });
        })
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

    }
})