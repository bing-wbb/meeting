// components/roomlist/roomlist.js
const app = getApp();
Page({
    /** 页面的初始数据*/
    data: {
        navigationSetting:{
            title:'食堂',
            height: app.globalData.navBarHeight,
            paddingTop: app.globalData.statusBarHeight,
            // backgroundColor:'red',
            size:'default'
        },
        tabList: ['一粟堂', '三清园', '七品居','九华厅'],
        tabNow: 0, //当前选中的tab标签索引
        search: "",
        tradeList: [['从前说','千千万万','千千万万','千千万万','千千万万'],['我记得']], //对应tab显示的商家列表
        list:[ //搜索后的list内容列表
            {Name:"一粟堂",arr:[
              {title: '烧卤家族', sale: 358, rating: 4.9, consumption: 15},
              {title: '烧卤家族', sale: 518, rating: 4.9, consumption: 35},
              {title: '烧卤家族', sale: 138, rating: 4.9, consumption: 23},
            ]},
            {Name:"三清园",arr:[
              {title: '汉味小吃', sale: 156, rating: 4.9, consumption: 25},
              {title: '汉味小吃', sale: 324, rating: 4.9, consumption: 17},
            ]},
            {Name:"七品居",arr:[
                {title: '古茗', sale: 156, rating: 4.9, consumption: 25},
                {title: '古茗', sale: 351, rating: 4.9, consumption: 19},
                {title: '古茗', sale: 324, rating: 4.9, consumption: 17},
            ]},
            {Name:"九华厅",arr:[
                {title: '汉味小吃', sale: 156, rating: 4.9, consumption: 25},
            ]}
        ],
    },
    selectTab (e) { //切换不同的tab
        this.setData({
            tabNow: e.currentTarget.dataset.id
        })
    },
    handleSwiperChange(e) { //对应改变tab
        this.setData({
          tabNow: e.detail.current
        })
    },
    getContent(e) {
        console.log("主页：",e)
        this.setData({
          search: e.detail
        })
    },
 
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
 
    },
 
    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {
 
    },
 
    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
 
    },
 
    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {
 
    },
 
    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {
 
    },
 
    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {
 
    },
 
    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {
 
    },
 
    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {
 
    }
})
