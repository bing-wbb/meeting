// pages/my/myorder/myorder.js
var app = getApp() 
const { getRoom  } = require('../../../http/api')
Page({ 
 data: { 
	navbar: ['我的预约', '待审核', '已审核','审核失败'], 
	currentTab: 0 ,
	userAllList:[
	],
	userdaishenpiList:[
	],
	usershenpishibaiList:[
	],
	usershenpichenggongList:[
    ],
    userquxiaoList:[
	],
 }, 
 navbarTap: function(e){ 
  this.setData({ 
   currentTab: e.currentTarget.dataset.idx 
  }) 
 } ,
 gotodelete(e){
     console.log(e);
    wx.showModal({
        title:'提示',
        content: '是否取消订单',
        success (res) {
            if (res.confirm) {
                console.log('用户点击确定')
                var json1={
                    orderId:e.currentTarget.dataset.nid
                }
                getRoom("orderEntity/cancelOrder",json1).then((res)=>{
                    console.log(res);
                })
            } else if (res.cancel) {
                console.log('用户点击取消')
            }
        }
    })
    // wx.navigateTo({
    //     url: '/pages/my/myorderdetail/myorderdetail?id='+e.currentTarget.dataset.nid,
    //   })
},
	/**
 * 生命周期函数--监听页面加载
 */
onLoad: function(options) {
	const userId = app.globalData.userId;
    console.log(userId);
    
	getRoom("orderEntity/selectUserOrder?page=1&limit=1000&orderUserId="+userId+"&approval=1").then((res)=>{
		this.setData({
			userdaishenpiList:res.data.records,
		});
	})
	getRoom("orderEntity/selectUserOrder?page=1&limit=1000&orderUserId="+userId).then((res)=>{
		this.setData({
			userAllList:res.data.records,
		});
	})
	getRoom("orderEntity/selectUserOrder?page=1&limit=1000&orderUserId="+userId+"&approval=2").then((res)=>{
		this.setData({
			usershenpishibaiList:res.data.records,
		});
	})
	getRoom("orderEntity/selectUserOrder?page=1&limit=1000&orderUserId="+userId+"&approval=0").then((res)=>{
		this.setData({
			usershenpichenggongList:res.data.records,
		});
    })

	// this.setData({
	//   myarray: myarray1
	// });
	
	
    },
    gotodetail(e){
        console.log(e.currentTarget.dataset.nid);
        wx.navigateTo({
            url: '/pages/my/myorderdetail/myorderdetail?id='+e.currentTarget.dataset.nid,
          })
    },
}) 
