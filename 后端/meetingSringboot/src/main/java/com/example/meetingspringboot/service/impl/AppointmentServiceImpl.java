package com.example.meetingspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.meetingspringboot.dao.AppointmentDetailTimeMapper;
import com.example.meetingspringboot.dao.UserMapper;
import com.example.meetingspringboot.po.AppointmentDetailTimeEntity;
import com.example.meetingspringboot.po.AppointmentEntity;
import com.example.meetingspringboot.dao.AppointmentMapper;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import com.example.meetingspringboot.po.vo.RoomVo;
import com.example.meetingspringboot.service.AppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Service
public class AppointmentServiceImpl  implements AppointmentService {
    @Resource
    private AppointmentMapper appointmentMapper;
    @Resource
    private AppointmentDetailTimeMapper appointmentDetailTimeMapper;
    @Override
    public AppointmentEntity addAppointment(AppointmentEntity appointmentEntity) {
        appointmentMapper.insert(appointmentEntity);
        AppointmentEntity appointmentEntity1=appointmentMapper.selectById(appointmentEntity);
        appointmentEntity1.setBz("http://localhost:8090/qrcode/getQRCode?content="+appointmentEntity1.getAppointmentId()+"&logoUrl=https://img02.viwik.com/20181017/viwik_sy_11470747729356.jpg");
        System.out.println(appointmentEntity);
        String ids=appointmentEntity.getAppointmentPeriodIds();
        System.out.println(ids);
        String[] collection = ids.split(",");
        System.out.println(collection[1]);
        for(int i=0;i<collection.length;i++) {
            Date ddd=appointmentEntity.getAppointmentDate();
            //创建一个SimpleDateFormat类的对象，传入模板参数
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            // format(Date date) 将日期格式化成字符串
            String dateStr = simpleDateFormat.format(ddd);
            System.out.println(dateStr);
            String[] collection1 = dateStr.split("[: -]");
            String dd="";
            for (int j=0;j<collection1.length;j++){

                System.out.println(collection1[j]);
            }
            dd=dd+collection1[0]+"-"+collection1[1]+"-"+collection1[2]+" "+(Integer.parseInt(collection1[3])+Integer.parseInt(collection[i]))+":"+collection1[4]+":"+collection1[5];
            System.out.println("jdfidef:"+dd);
            try {
                Date date2 = simpleDateFormat1.parse(dd);
                System.out.println("data"+date2);
                AppointmentDetailTimeEntity appointmentDetailTimeEntity = new AppointmentDetailTimeEntity();
                appointmentDetailTimeEntity.setDatailAppointmentId(appointmentEntity.getAppointmentId());
                appointmentDetailTimeEntity.setDatailAppointmentDate(appointmentEntity.getAppointmentDate());
                appointmentDetailTimeEntity.setAppointmentTimePeriodId(Integer.parseInt(collection[i]));
                appointmentDetailTimeEntity.setAppointmentState(0);
                appointmentDetailTimeEntity.setExpirationTime(date2);
                appointmentDetailTimeMapper.insert(appointmentDetailTimeEntity);

            } catch (ParseException e) {
                e.printStackTrace();
            }


//
        }
        return appointmentEntity;
    }

    @Override
    public int deleteAppointment(AppointmentEntity appointmentEntity) {
        String placeAll="";
        QueryWrapper<AppointmentDetailTimeEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("appointment_detail_time.detail_appointment_id",appointmentEntity.getAppointmentId());
        List<Map<String,Object>>maps=appointmentDetailTimeMapper.selectMaps(queryWrapper);
        System.out.println(maps);
        for (Map<String,Object>map : maps){
            AppointmentDetailTimeEntity appointmentDetailTimeEntity=appointmentDetailTimeMapper.selectById((Serializable) map.get("appoinment_datail_time_id"));
            appointmentDetailTimeMapper.deleteById(appointmentDetailTimeEntity);
        }
        int i=appointmentMapper.deleteById(appointmentEntity);
        return i;
    }

    @Override
    public IPage<AppointmentVo> appointmentSelect(Integer currentPage, Integer pageSize, AppointmentVo appointmentVo) {
        IPage<AppointmentVo>iPage=new Page<>(currentPage,pageSize);
        QueryWrapper<AppointmentVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNoneBlank((CharSequence) appointmentVo.getAppointmentDate()),"appointment_date",appointmentVo.getAppointmentDate());
        queryWrapper.orderByDesc("appointment_date");
        IPage<AppointmentVo> appointmentVoIPage = appointmentMapper.selectAppointment(iPage, queryWrapper);
        List<AppointmentVo> records = appointmentVoIPage.getRecords();
        appointmentVoIPage.setRecords(records);
        return appointmentVoIPage;
    }
}
