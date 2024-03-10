package com.example.meetingspringboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.meetingspringboot.po.vo.UserVo;
import org.springframework.stereotype.Service;
import com.example.meetingspringboot.po.UserEntity;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Service
public interface UserService{
//    用户注册
    UserEntity userRegister(UserEntity userEntity);
//    用户登录
    UserEntity userLogin(UserEntity userEntity);
//    用户修改密码
    UserEntity userUpdatepassworld(UserEntity userEntity);
//    用户修改
    UserEntity userUpdateuser(UserEntity userEntity);
//    用户分页
    IPage<UserVo> userSelectuser(Integer currentPage, Integer pageSize, UserVo userVo);
//    用户详情
    UserEntity userDetail(int id);
//    用户删除
    int userDelect(UserEntity userEntity);
    //    用户密码修改
    UserEntity userUpdatePassword(UserEntity userEntity);
}
