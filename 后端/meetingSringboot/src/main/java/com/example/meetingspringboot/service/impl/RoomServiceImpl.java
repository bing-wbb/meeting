package com.example.meetingspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.meetingspringboot.dao.*;
import com.example.meetingspringboot.po.*;
import com.example.meetingspringboot.po.vo.RoomEchartsVo;
import com.example.meetingspringboot.po.vo.RoomVo;
import com.example.meetingspringboot.service.RoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.pqc.math.linearalgebra.IntUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Service
public class RoomServiceImpl  implements RoomService {
    @Resource
    private RoomMapper roomMapper;
    @Resource
    private BuildingMapper buildingMapper;
    @Resource
    private CollegeMapper collegeMapper;
    @Resource
    private AppointmentMapper appointmentMapper;
    @Override
    public IPage<RoomVo> roomSelect(Integer currentPage, Integer pageSize, String roomName,Integer roomBuildingId) {
        IPage<RoomVo>iPage=new Page<>(currentPage,pageSize);
        QueryWrapper<RoomVo> queryWrapper=new QueryWrapper<>();
//        if (roomName!=null){
//            queryWrapper.eq("room_name",roomName);
//        }
//        queryWrapper.like(StringUtils.isNoneBlank(date),"appointment_date",date);
        queryWrapper.like(StringUtils.isNoneBlank(roomName),"room_name",roomName);
        if (roomBuildingId!=null){
            queryWrapper.eq("room_building_id",roomBuildingId);
        }
//        if (roomVo.getRoomBuildingId()!=null){
//            queryWrapper.eq("room_building_id",roomVo.getRoomBuildingId());
//
//        }
//        if (roomVo.getRoomCollegeId()!=null){
//            queryWrapper.eq("room_college_id",roomVo.getRoomCollegeId());
//
//        }
//        if (!String.valueOf(roomVo.getCollegeId()).equals("")){
//            queryWrapper.eq("college_id",roomVo.getCollegeId());
//        }
//        if (!String.valueOf(roomVo.getFloor()).equals("")){
////        if (roomVo.getFloor()!=null){
//            queryWrapper.eq("floor",roomVo.getFloor());
//        }
//        if (!String.valueOf(roomVo.getBuildingId()).equals("")){
////        if (roomVo.getBuildingId()!=null){
//            queryWrapper.eq("building_id",roomVo.getBuildingId());
//        }
//        queryWrapper.like(StringUtils.isNoneBlank(roomVo.getTitle()),"title",roomVo.getTitle());
//        queryWrapper.like(StringUtils.isNoneBlank(roomVo.getType()),"type",roomVo.getType());
//        queryWrapper.eq("state",roomVo.getState());
//        queryWrapper.eq("building_id",roomVo.getBuildingId());
//        queryWrapper.eq("college_id",roomVo.getCollegeId());
        IPage<RoomVo> onlineMovieVOIPage = roomMapper.selectRoom(iPage, queryWrapper);
        List<RoomVo> records = onlineMovieVOIPage.getRecords();
        onlineMovieVOIPage.setRecords(records);
        return onlineMovieVOIPage;
    }

    @Override
    public RoomEntity roomStop(int id) {
        RoomEntity roomEntity=roomMapper.selectById(id);
        roomEntity.setState(1);
        roomMapper.updateById(roomEntity);
        return roomEntity;
    }

    @Override
    public RoomEntity roomUpdate(RoomEntity roomEntity) {
        roomMapper.updateById(roomEntity);
        return roomEntity;
    }

    @Override
    public RoomEntity roomAdd(RoomEntity roomEntity) {
        roomMapper.insert(roomEntity);
        return roomEntity;
    }

    @Override
    public RoomVo roomDetail(int id) {
        RoomEntity roomEntity=roomMapper.selectById(id);
        BuildingEntity buildingEntity=buildingMapper.selectById(roomEntity.getRoomBuildingId());
        System.out.print(buildingEntity);
        CollegeEntity collegeEntity=collegeMapper.selectById(roomEntity.getRoomCollegeId());
        RoomVo roomVo=new RoomVo();
        roomVo.setRoomId(roomEntity.getRoomId());
        roomVo.setRoomName(roomEntity.getRoomName());
        roomVo.setRoomDetail(roomEntity.getRoomDetail());
        roomVo.setRoomBuildingId(roomEntity.getRoomBuildingId());
        roomVo.setRoomCollegeId(roomEntity.getRoomCollegeId());
        roomVo.setFloor(roomEntity.getFloor());
        roomVo.setMax(roomEntity.getMax());
        roomVo.setState(roomEntity.getState());
        roomVo.setName(buildingEntity.getName());
        roomVo.setCollegeName(collegeEntity.getCollegeName());
        return roomVo;
    }

    @Override
    public IPage<AppointmentEntity> roomEchartsIndex(AppointmentEntity appointmentEntity) {
        IPage<AppointmentEntity>iPage=new Page<>(0,200);
        QueryWrapper<AppointmentEntity> queryWrapper=new QueryWrapper<>();
//        System.out.println("appointmentEnti.getAppointmentDate()="+appointmentEntity.getAppointmentDate());
//        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String strDate3 = sdf3.format(appointmentEntity.getAppointmentDate());
//        System.out.println("strDate3:" + strDate3);
//
//        String str1 =strDate3;
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date myDate = null;
//        try {
//            myDate = sdf1.parse(str1);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//        String strDate1 = sdf2.format(myDate);
//        System.out.println("strDate1:" + strDate1);
//
//        String str11 = strDate1;
//        SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date myDate1 = null;
//        try {
//            myDate1 = sdf11.parse(str11);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("myDate1: "+myDate1);
//        System.out.println("appointmentEntity.getAppointmentDate()="+appointmentEntity.getAppointmentDate());
//        Date date=appointmentEntity.getAppointmentDate();
        Date date=new Date();
        System.out.println(date);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String strDate1 = sdf1.format(date);
        System.out.println("strDate1:" + strDate1);
            Date myDate1 = null;
            try {
                myDate1 = sdf1.parse(strDate1);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("myDate1: "+myDate1);
//        System.out.println(today);
//        System.out.println("appointmentEnti="+appointmentEntity);
//        queryWrapper.eq("appointment_room_id",appointmentDetailVo.getAppointmentRoomId());
//        queryWrapper.eq("appointment_date",appointmentEntity.getAppointmentDate());
//        queryWrapper.eq("appointment.appointment_date",strDate3);

        queryWrapper.eq("appointment.appointment_date", myDate1);
//        queryWrapper.eq("appointment.appointment_date",appointmentEntity.getAppointmentDate());
        IPage<AppointmentEntity> appointmentEntityIPage = appointmentMapper.selectRoomkong(iPage, queryWrapper);
        List<AppointmentEntity> records = appointmentEntityIPage.getRecords();
        System.out.println("jfiw="+appointmentEntityIPage);

        appointmentEntityIPage.setRecords(records);
        return appointmentEntityIPage;

    }
}
