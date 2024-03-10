// pages/user/yuyue/yuyue.js
const { getRoom} = require('../../../http/api')
let heightArr=[0];//存放高度累计的数组 
Page({
  data: {
    menuArr: [{
      "id": 0,
      "title": "A楼",
      "subArr": [{
        "image": "/images/index/1.png",
        "price": "15",
        "imgDesc": "A101"
      }, {
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "A102"
      }, {
        "price": "15",
        "imgDesc": "A201",
        "image": "/images/index/1.png",
      }, {
        "price": "15",
        "imgDesc": "A202",
        "image": "/images/index/1.png",
      }, {
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "A301S"
      }]
    }, {
      "id": 1,
      "title": "B楼",
      "subArr": [{
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "b101"
      }, {
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "b102"
      }, {
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "b103"
      }, {
        "image": "/images/index/1.png",
        "imgDesc": "b201"
      }, {
        "price": "15",
        "image": "h/images/index/1.png",
        "imgDesc": "b202"
      }]
    }, {

      "id": 2,
      "title": "C楼",
      "subArr": [{
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "C101"
      }, {
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "C102"
      }, {
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "C103"
      }, {
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "C201"
      }, {
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "C301"
      }]
    }, {
      "id": 3,
      "title": "D楼",
      "subArr": [{
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "D101"
      }, {
        "price": "15",
        "image": "/images/index/1.png",
        "imgDesc": "D102"
      }]
    }],
    itemList:[{
        "id": 0,
        "title": "A楼",
        "subArr": [{
            "collegeName": "通用",
            "floor": 1,
            "max": 20,
            "name": "A楼",
            "roomBuildingId": 1,
            "roomCollegeId": 1,
            "roomDetail": "wjfif",
            "roomId": 1,
            "roomName": "hhuasd",
            "state": 0
        }]
      }, {
        "id": 1,
        "title": "B楼",
        "subArr": []
      }, {
  
        "id": 2,
        "title": "C楼",
        "subArr": []
      }, {
        "id": 3,
        "title": "D楼",
        "subArr": []
      },{
        "id": 4,
        "title": "E楼",
        "subArr": []
      },{
        "id": 5,
        "title": "F楼",
        "subArr": []
      },{
        "id": 5,
        "title": "T楼",
        "subArr": []
      },
    ],
    //右侧对应的id
    rightId: 'right0',
    //左侧的当前项
    leftNum:0,
    flag:true
  },
  onLoad(options) {
    // const userId = app.globalData.userId;
    // console.log(userId);
    var json1={
        page:1,
        limit:10
      }
    //   将所有的会议室列表显示（按楼号)
    // a
    getRoom('roomEntity/selectroom?page=0&limit=100&roomBuildingId=1').then((res)=>{
        var param = {};
        var string = "itemList["+0+"].subArr";
        param[string] = res.data.records;
        this.setData(param);
    })
    // b
    getRoom('roomEntity/selectroom?page=0&limit=100&roomBuildingId=2').then((res)=>{
        var param = {};
        var string = "itemList["+1+"].subArr";
        param[string] = res.data.records;
        this.setData(param);
    })
    // c
    getRoom('roomEntity/selectroom?page=1&limit=100&roomBuildingId=3').then((res)=>{
        var param = {};
        var string = "itemList["+2+"].subArr";
        param[string] = res.data.records;
        this.setData(param);
    })
    // d
    getRoom('roomEntity/selectroom?page=1&limit=100&roomBuildingId=4').then((res)=>{
        var param = {};
        var string = "itemList["+3+"].subArr";
        param[string] = res.data.records;
        this.setData(param);
    })
    // d
    getRoom('roomEntity/selectroom?page=1&limit=100&roomBuildingId=5').then((res)=>{
        var param = {};
        var string = "itemList["+4+"].subArr";
        param[string] = res.data.records;
        this.setData(param);
        // console.log(this.data.itemList[4]);
    })
    // e
    getRoom('roomEntity/selectroom?page=1&limit=100&roomBuildingId=6').then((res)=>{
        var param = {};
        var string = "itemList["+5+"].subArr";
        param[string] = res.data.records;
        this.setData(param);
        // console.log(this.data.itemList[5]);
    })
    // f
    getRoom('roomEntity/selectroom?page=1&limit=100&roomBuildingId=6').then((res)=>{
        var param = {};
        var string = "itemList["+5+"].subArr";
        param[string] = res.data.records;
        this.setData(param);
    })
    // t
    getRoom('roomEntity/selectroom?page=1&limit=100&roomBuildingId=7').then((res)=>{
        var param = {};
        var string = "itemList["+6+"].subArr";
        param[string] = res.data.records;
        this.setData(param);
    })
    console.log(this.data.itemList);
  },
  onReady() {
    //获取所有box的高度
    setTimeout(() => {
      const query = wx.createSelectorQuery()
      query.selectAll('.box').boundingClientRect()
      query.selectViewport().scrollOffset()
      query.exec(function (res) {
        // console.log(res[0])
        res[0].map(val=>{
          //永远拿heightArr一项来加上将要push进数组的这一项
          let result=val.height+heightArr[heightArr.length-1]
          heightArr.push(result) 
        })
        console.log(heightArr)
      })
      
    }, 100)
  
  },
  //左侧点击事件
  leftClickFn(e){
    console.log(e.currentTarget.dataset.index)
    this.setData({
      leftNum:e.currentTarget.dataset.index,
      rightId:'right'+e.currentTarget.dataset.index
    })
  },
  gotoyuyue(e){
      console.log(e.currentTarget.dataset.nid);
    wx.navigateTo({
    url: '/pages/user/calendar/calendar?roomId='+e.currentTarget.dataset.nid,
    })
  },
  //右侧滚动事件
  rightScroll(e) {
    
    let st=e.detail.scrollTop
    if(this.data.flag){
      for(let i=0;i<heightArr.length;i++){
        if(st>=heightArr[i]&&st<heightArr[i+1]-5){
          this.setData({
            leftNum:i,
          })
          return
        }
      }
    }
  },
  //触底事件
  lower(){
    console.log(heightArr.length)
    this.setData({
      flag:false,
      leftNum:heightArr.length-2,
    })
    setTimeout(()=>{
      this.setData({
        flag:true
      })
    },200)
    console.log('触底了')
  },
})
