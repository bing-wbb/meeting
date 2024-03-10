package com.example.meetingspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.meetingspringboot.po.UserEntity;
import com.example.meetingspringboot.dao.UserMapper;
import com.example.meetingspringboot.po.vo.UserVo;
import com.example.meetingspringboot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Service
public class UserServiceImpl implements UserService {
    Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private UserMapper userMapper;
    @Override
    public UserEntity userRegister(UserEntity userEntity) {

        int xuehao = userEntity.getNumber();
        UserEntity userEntity1 = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("number", xuehao));
        if(userEntity1==null){
            if (userEntity.getCollegeId()==null){
                userEntity.setCollegeId(1);
            }
            userMapper.insert(userEntity);
            UserEntity userEntity2 = new UserEntity();
            BeanUtils.copyProperties(userEntity,userEntity2);
            return userEntity2;
        }else {
            return null;
        }
    }

    @Override
    public UserEntity userLogin(UserEntity userEntity) {
        int xuehao = userEntity.getNumber();
        UserEntity userEntity1 = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("number", xuehao));
        System.out.println(userEntity1);
        if(userEntity1==null){
            return null;
        }
        if (userEntity1.getPassword().equals(userEntity.getPassword())){
            UserEntity userVO = new UserEntity();
            BeanUtils.copyProperties(userEntity1,userVO);
            return userVO;
        }
        return null;
    }

    @Override
    public UserEntity userUpdatepassworld(UserEntity userEntity) {
        int xuehao = userEntity.getNumber();
        UserEntity userEntity1 = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("number", xuehao));
        System.out.println(userEntity1);
        if(userEntity1!=null){
            String password=userEntity.getPassword();
            if (!password.equals(userEntity1.getPassword())){
                userEntity1.setPassword(password);
                userMapper.updateById(userEntity1);
                return userEntity1;
            }else {
                return userEntity;
            }

        }else {
            return null;
        }
    }

    @Override
    public UserEntity userUpdateuser(UserEntity userEntity) {
        UserEntity userEntity1 = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("user_id", userEntity.getUserId()));
        userMapper.updateById(userEntity);
        return userEntity;
    }

    @Override
    public IPage<UserVo> userSelectuser(Integer currentPage, Integer pageSize, UserVo userVo) {
        IPage<UserVo>iPage=new Page<>(currentPage,pageSize);
        QueryWrapper<UserVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("role","user_id");
        IPage<UserVo> onlineMovieVOIPage = userMapper.selectUser(iPage, queryWrapper);
        List<UserVo> records = onlineMovieVOIPage.getRecords();
        onlineMovieVOIPage.setRecords(records);
        return onlineMovieVOIPage;
    }

    @Override
    public UserEntity userDetail(int id) {
        //        UserEntity userEntity1 = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("id", id));
        UserEntity userEntity=userMapper.selectById(id);
        return userEntity;
    }

    @Override
    public int userDelect(UserEntity userEntity) {
        int i=userMapper.deleteById(userEntity);
        return i;
    }

    @Override
    public UserEntity userUpdatePassword(UserEntity userEntity) {
        UserEntity userEntity1 = userMapper.selectOne(new QueryWrapper<UserEntity>().eq("user_id", userEntity.getUserId()));
        userEntity1.setPassword(userEntity.getName());
        userMapper.updateById(userEntity1);
        return userEntity1;
    }
}
