// pages/user/calendar/calendar.js
const { getRoom} = require('../../../http/api')
Page({

    /**
     * 页面的初始数据
     */

    data: {
        ids:[],
        checkedAll: "",
        spot: ['2023-11-1', '2023/7/28', '2023/7/25', '2023/7/7', '2023/8/7'],
        appointment: ['2023/7/30'],
        appl: ['sdjfbskdjfs'],
        time:[
            {'timeid':1,'timeproid':'08:00-09:00'},
            {'timeid':2,'timeproid':'08:00-09:00'},
            {'timeid':3,'timeproid':'08:00-09:00'},
            {'timeid':4,'timeproid':'08:00-09:00'},
            {'timeid':5,'timeproid':'08:00-09:00'},
            {'timeid':6,'timeproid':'08:00-09:00'},
            {'timeid':7,'timeproid':'08:00-09:00'},
            {'timeid':8,'timeproid':'08:00-09:00'},
            {'timeid':9,'timeproid':'08:00-09:00'},
            {'timeid':10,'timeproid':'08:00-09:00'},
            {'timeid':11,'timeproid':'08:00-09:00'},
            {'timeid':12,'timeproid':'08:00-09:00'},
        ],
        roomId:'',
        orderAppointmentId:'',
        appointmentDate:'',
        timeList:[
           
        ],
    },

    dateChange(e){
        console.log(e.detail.dateString);
        this.setData({
            appointmentDate:e.detail.dateString,
        })

        this.getTimeList();
    },
    getTimeList(){
        var json1={
            roomId:this.data.roomId,
            appointmentDate:this.data.appointmentDate
        }
        getRoom("appointmentDetailTimeEntity/selectAppointmentDetail?page=1&limit=100&appointmentDate="+json1.appointmentDate+"&appointmentRoomId="+json1.roomId).then((res)=>{
            // console.log(res);
            this.setData({
                timeList:res.data.records,
                orderAppointmentId:res.data.records[0].datailAppointmentId,
                ids:[]
            })
            console.log(this.data.timeList);
            console.log(this.data.orderAppointmentId);
        }).catch((err)=>{
            this.setData({
                timeList:[],
            })
        })
    },
    checkboxChange(e) {
        console.log(e);
        var a = this.data.ids;
        console.log(e.detail.value);
        console.log('checkbox发生change事件，携带value值为：', e.currentTarget.dataset.index)
        if(parseInt(e.detail.value)==e.currentTarget.dataset.index){
            a.push(e.detail.value);
        }else{
            for (var i = 0; i < a.length; i++) {
                if (a[i] == String(e.currentTarget.dataset.index)) {
                  a.splice(i, 1);
                }
              }
        }
        console.log(a);
        this.setData({
            ids:a
        })
        console.log('a='+a);

    },
    yuyuedetail(){
    var IdsStr=null;
    var Ids = this.data.ids; 
    var IdsStr = Ids.join(','); //将数组转换成string串
    console.log("userIdsStr=", IdsStr)
    console.log("orderAppointmentId=", this.data.orderAppointmentId)
    if(IdsStr.length!=0){
        wx.navigateTo({
          url: '/pages/user/yuyuedetail/yuyuedetail?userIdsStr='+IdsStr+"&orderAppointmentId="+this.data.orderAppointmentId,
        })
    }else{
        console.log('df');
        wx.showToast({
            title: '请选择时间段！',
            icon: 'none',    //如果要纯文本，不要icon，将值设为'none'
            duration: 2000     
          })  
        
    }

    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
           
    const int=parseInt(options.roomId)
    console.log(int);
    this.setData({
        roomId:int
    })
    var json3={
        roomId:this.data.roomId,
        appointmentDate:this.data.appointmentDate
    }
    console.log(json3);
    getRoom("appointmentDetailTimeEntity/selectAppointmentDetail?page=1&limit=100&appointmentDate="+json3.appointmentDate+"&appointmentRoomId="+json3.roomId).then((res)=>{
        console.log(res);
        this.setData({
            timeList:res.data.records
        })
        // var param = {};
        // var string = "itemList["+0+"].subArr";
        // param[string] = res.data.records;
        // this.setData(param);
    })

    // var json2={
    //     id:int
    // }
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