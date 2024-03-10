// pages/user/ndetail/ndetail.js
const { getDetail  } = require('../../../http/api')
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
    },
    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onLoad(options) {
   
    const int=parseInt(options.id)
    console.log(int);
    var json2={
        id:int
    }
    getDetail('noticeEntity/noticeDetail?id='+int)
    .then((res)=>{
        console.log("hfouwehf")
        console.log(res);
        const releaseDate=res.data.releaseDate;
        const currentDate = new Date();
        // 转换为年月日格式
        var dateList=[];
        dateList=releaseDate.split(/[-,T,:,.,+]/)
        console.log(dateList);
        const year = dateList[0];
        const month = dateList[1];
        const date = dateList[2];
        const hour = dateList[3];
        const mm = dateList[4];
        const ss = dateList[5];
        const dateString = `${year}-${month}-${date}  ${hour}:${mm}:${ss}`;
        this.setData({
            picture_url: "/images/index/1.png",
            content:res.data.content,
            subject: res.data.subject,
            brief_introduction: "露露温柔可人吃可爱多长大的，露露温柔可人吃可爱多长大的，露露温柔可人吃可爱多长大的。露露温柔可人吃可爱多长大的。露露温柔可人吃可爱多长大",
            releaseDate:dateString
        });
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