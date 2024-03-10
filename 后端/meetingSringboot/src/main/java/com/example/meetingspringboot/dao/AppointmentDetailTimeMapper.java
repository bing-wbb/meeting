package com.example.meetingspringboot.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.meetingspringboot.po.AppointmentDetailTimeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.meetingspringboot.po.vo.AppointmentDetailVo;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Mapper
public interface AppointmentDetailTimeMapper extends BaseMapper<AppointmentDetailTimeEntity> {
    IPage<AppointmentDetailVo> selectAppointmentDetail(IPage<AppointmentDetailVo> iPage, @Param(Constants.WRAPPER) QueryWrapper<AppointmentDetailVo> queryWrapper);

}
