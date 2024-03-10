package com.example.meetingspringboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.AppointmentEntity;
import com.example.meetingspringboot.po.NoticeEntity;
import com.example.meetingspringboot.po.RoomEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.meetingspringboot.po.vo.RoomEchartsVo;
import com.example.meetingspringboot.po.vo.RoomVo;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Service
public interface RoomService {
    //    会议室分页
    IPage<RoomVo> roomSelect(Integer currentPage, Integer pageSize, String roomName,Integer roomBuildingId);
    //    会议室停用
    RoomEntity roomStop(int id);
    //    会议室修改
    RoomEntity roomUpdate(RoomEntity roomEntity);
//    会议室增加
    RoomEntity roomAdd(RoomEntity roomEntity);
//    会议室详情
    RoomVo roomDetail(int id);

    IPage<AppointmentEntity> roomEchartsIndex(AppointmentEntity appointmentEntity);

}
