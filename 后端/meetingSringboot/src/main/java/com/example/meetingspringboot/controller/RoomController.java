package com.example.meetingspringboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.AppointmentEntity;
import com.example.meetingspringboot.po.NoticeEntity;
import com.example.meetingspringboot.po.RoomEntity;
import com.example.meetingspringboot.po.UserEntity;
import com.example.meetingspringboot.po.vo.AppointmentDetailVo;
import com.example.meetingspringboot.po.vo.RoomVo;
import com.example.meetingspringboot.service.NoticeService;
import com.example.meetingspringboot.service.RoomService;
import com.example.meetingspringboot.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@RestController
@RequestMapping("/roomEntity")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @PostMapping("roomAdd")
    public JsonData addRoom(@RequestBody RoomEntity roomEntity){
        RoomEntity roomEntity1 = roomService.roomAdd(roomEntity);
        if(roomEntity1==null){
            return JsonData.buildError("用户已存在");
        }
        return JsonData.buildSuccess(roomEntity1);
    }
    @PostMapping("selectroom")
    public JsonData selectRoom(Integer page,Integer limit,String roomName ,Integer roomBuildingId){
        IPage<RoomVo> roomVoIPage = roomService.roomSelect(page, limit, roomName,roomBuildingId);
        if(roomVoIPage!=null){
            return JsonData.buildSuccess(roomVoIPage);
        }else {
            return JsonData.buildError("error");
        }
    }
    @PostMapping("updataRoom")
    public JsonData updataRoom(@RequestBody RoomEntity roomEntity){
        RoomEntity roomEntity1 = roomService.roomUpdate(roomEntity);
        if (roomEntity1!=null){
            return JsonData.buildSuccess(roomEntity1);
        }else {
            return JsonData.buildError("error");
        }
    }
    @PostMapping("roomDetail")
    public JsonData roomDetail( int id){

        RoomVo roomVo = roomService.roomDetail(id);
        return JsonData.buildSuccess(roomVo);
    }
    @PostMapping("stopRoom")
    public JsonData stopRoom(@RequestBody RoomEntity roomEntity){

        RoomEntity roomEntity1 = roomService.roomStop(roomEntity.getRoomId());
        return JsonData.buildSuccess(roomEntity1);
    }

    @PostMapping("/roomUpload")
    public JsonData roomUpload(@RequestBody List<Map<String, Object>> data) {
        // 处理上传的数据
        for (int i=0;i<data.size();i++){
            Map<String, Object> data1 = data.get(i); // 获取第一个人的信息
            System.out.println(data1);
            RoomEntity roomEntity=new RoomEntity();
            for (Map.Entry<String, Object> entry : data1.entrySet()) {

                switch (entry.getKey()) {
// 小括号中的表达式或者变量结果类型可以是：int char String byte short
                    case "roomName":
// 相当于if(num==1){}//case 后面的值必须是常量 'A' "星期一"
                        roomEntity.setRoomName((String) entry.getValue());
                        System.out.println(entry.getValue());
                        break;// 执行完毕一个case分支后跳出switch语句块
                    case "roomBuildingId":// 相当于if(num==2)
                        roomEntity.setRoomBuildingId((Integer) entry.getValue());
                        System.out.println(entry.getValue());

                        break;
                    case "roomCollegeId":// 相当于if(num==3)
                        roomEntity.setRoomCollegeId((Integer) entry.getValue());
                        System.out.println(entry.getValue());

                        break;
                    case "floor":// 相当于if(num==3)
                        roomEntity.setFloor((Integer) entry.getValue());
                        System.out.println(entry.getValue());

                        break;
                    case "max":// 相当于if(num==3)
                        roomEntity.setMax((Integer) entry.getValue());
                        System.out.println(entry.getValue());
                        break;
                    default:// 相当于else ,是可选的
                        System.out.println("再接再厉");

                        break;        }
            }
            System.out.println(roomEntity);
            roomService.roomAdd(roomEntity);
        }
        return JsonData.buildSuccess("上传成功");
    }
    @PostMapping("roomEchartsIndex")
    public JsonData roomEchartsIndex(@RequestBody AppointmentEntity appointmentEntity){
        System.out.println(appointmentEntity);
        IPage<AppointmentEntity> roomVoIPage = roomService.roomEchartsIndex(appointmentEntity);
        if(roomVoIPage!=null){
            return JsonData.buildSuccess(roomVoIPage);
        }else {
            return JsonData.buildError("error");
        }
    }
}

