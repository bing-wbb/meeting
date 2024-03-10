package com.example.meetingspringboot.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.meetingspringboot.po.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.meetingspringboot.po.vo.UserVo;
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
public interface UserMapper extends BaseMapper<UserEntity> {
    IPage<UserVo> selectUser(IPage<UserVo> iPage, @Param(Constants.WRAPPER) QueryWrapper<UserVo> queryWrapper);

}
