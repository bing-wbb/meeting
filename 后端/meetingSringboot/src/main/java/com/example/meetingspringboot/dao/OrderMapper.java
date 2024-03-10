package com.example.meetingspringboot.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.meetingspringboot.po.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import com.example.meetingspringboot.po.vo.OrderVo;
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
public interface OrderMapper extends BaseMapper<OrderEntity> {
    IPage<OrderVo> selectUserOrder(IPage<OrderVo> iPage, @Param(Constants.WRAPPER) QueryWrapper<OrderVo> queryWrapper);

}
