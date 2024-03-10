package com.example.meetingspringboot.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.meetingspringboot.po.RoomEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import com.example.meetingspringboot.po.vo.RoomVo;
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
public interface RoomMapper extends BaseMapper<RoomEntity> {
    IPage<RoomVo> selectRoom(IPage<RoomVo> iPage, @Param(Constants.WRAPPER) QueryWrapper<RoomVo> queryWrapper);

}
