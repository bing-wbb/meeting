const { getNotice} = require('../../../http/api')
Page({
 
    /**
     * 页面的初始数据
     */
    data: {
        noticeList:[{
            noticeId:"",
            subject: "",
            releaseDate: "",
            content: ""}
        ]
    //   myarray:[  
    //     ]
    },
   
   
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
        
      var myarray1 = [{
          picture_url: "/images/index/1.png",
          nikename: "露露和苏发收到公司化工污染个人物品但是关键时刻国防建设的客观减肥方法反反复复",
          describe: "温柔可人京东死哦哈我发给i哦好温柔i吃可爱多长大的",
          brief_introduction: "露露温柔可人吃可爱多长大的，露露温柔可人吃可爱多长大的，露露温柔可人吃可爱多长大的。露露温柔可人吃可爱多长大的。露露温柔可人吃可爱多长大",
          star_url: "/images/index/lunbo1.jpg",
          star_count: 246,
          char_url: "/images/index/lunbo1.jpg",
          chat_count: 230,
          createtime:"2023-11-1"
   
        },
        {
          picture_url: "/images/index/1.png",
          nikename: "壮壮",
          describe: "风流倜傥 玉树临风",
          brief_introduction: " 壮壮风流倜傥玉树临风， 壮壮风流倜傥玉树临风， 壮壮风流倜傥玉树临风， 壮壮风流倜傥玉树临风。",
          star_url: "/images/index/lunbo1.jpg",
          star_count: 67,
          char_url: "/images/index/lunbo1.jpg",
          chat_count: 60,
          createtime:"2023-11-1"
        },
        {
          picture_url: "/images/index/lunbo1.jpg",
          nikename: "妮妮",
          describe: "柔情似水 有灵性",
          brief_introduction: "妮妮柔情似水有灵性，妮妮柔情似水有灵性，妮妮柔情似水有灵性，妮妮柔情似水有灵性，妮妮柔情似水有灵性，妮妮柔情似水有灵性，妮妮柔情似水有灵性，妮妮柔情似水有灵性，妮妮柔情似水有灵性，妮妮柔情似水有灵性。",
          star_url: "/images/index/lunbo1.jpg",
          star_count: 200,
          char_url: "/images/index/lunbo1.jpg",
          chat_count: 199,
          createtime:"2023-11-1"
        },
        {
          picture_url: "/images/index/lunbo1.jpg",
          nikename: "娜娜",
          describe: "可爱迷人 听话懂事",
          brief_introduction: "娜娜可爱迷人听话懂事，娜娜可爱迷人听话懂事，娜娜可爱迷人听话懂事，娜娜可爱迷人听话懂事，娜娜可爱迷人听话懂事，娜娜可爱迷人听话懂事，娜娜可爱迷人听话懂事，娜娜可爱迷人听话懂事，娜娜可爱迷人听话懂事，娜娜可爱迷人听话懂事。",
          star_url: "/images/index/lunbo1.jpg",
          star_count: 300,
          char_url: "/images/index/lunbo1.jpg",
          chat_count: 280,
          createtime:"2023-11-1"
        },
        {
          picture_url: "/images/index/lunbo1.jpg",
          nikename: "欢欢",
          describe: "机灵调皮 熊孩子一枚",
          brief_introduction: "欢欢机灵调皮熊孩子一枚，欢欢机灵调皮熊孩子一枚，欢欢机灵调皮熊孩子一枚，欢欢机灵调皮熊孩子一枚，欢欢机灵调皮熊孩子一枚，欢欢机灵调皮熊孩子一枚，欢欢机灵调皮熊孩子一枚，欢欢机灵调皮熊孩子一枚，欢欢机灵调皮熊孩子一枚，欢欢机灵调皮熊孩子一枚。",
          star_url: "/images/index/lunbo1.jpg",
          star_count: 800,
          char_url: "/images/index/lunbo1.jpg",
          chat_count: 788,
          createtime:"2023-11-1"
        }
      ]
      this.setData({
        myarray: myarray1
      });
   
   
    },
    gotodetail(e){
        console.log(e.currentTarget.dataset.nid);
        wx.navigateTo({
            url: '/pages/user/ndetail/ndetail?id='+e.currentTarget.dataset.nid,
          })
    },
    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function() {

        //   将所有的会议室列表显示（按楼号)
        // a
        getNotice('noticeEntity/selectNotice?page=1&limit=100').then((res)=>{
            
            this.setData({
                noticeList:res.data.records
            });
            console.log(this.data.noticeList);
        })
    },
   
    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function() {
   
    },
   
    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function() {
   
    },
   
    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function() {
   
    },
   
    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function() {
   
    },
   
    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function() {
   
    },
   
    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function() {
   
    }
  })
  