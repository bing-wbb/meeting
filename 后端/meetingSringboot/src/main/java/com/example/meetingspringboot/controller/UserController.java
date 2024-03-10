package com.example.meetingspringboot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.AppointmentEntity;
import com.example.meetingspringboot.po.UserEntity;
import com.example.meetingspringboot.po.vo.UserVo;
import com.example.meetingspringboot.service.UserService;
import com.example.meetingspringboot.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@RequestMapping("/userEntity")
public class UserController {
    @Autowired
    private UserService userService;
//    用户注册
    @PostMapping("register")
    public JsonData register(@RequestBody UserEntity userEntity){
        if (userEntity.getNumber()==null){
            return JsonData.buildError("输入空学号");
        }else {
            UserEntity userEntity1 = userService.userRegister(userEntity);
            if(userEntity1==null){
                return JsonData.buildError("用户已存在");
            }
            return JsonData.buildSuccess(userEntity1);
        }

    }
//用户登录
    @PostMapping("userLogin")
    public JsonData login(@RequestBody UserEntity userEntity){
        UserEntity login = userService.userLogin(userEntity);
        if(login!=null){
            return JsonData.buildSuccess(login);
        }
        return JsonData.buildError("账号或密码错误");

    }
//用户修改密码
    @PostMapping("updataPassword")
    public JsonData updatePassword(@RequestBody UserEntity user){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setNumber(user.getNumber());
        userEntity.setPassword(user.getPassword());
        UserEntity userVO = userService.userUpdatepassworld(userEntity);
        if(userVO==null){
            return JsonData.buildError("输入格式不正确");
        }else if (userEntity.equals(userVO)){
            return JsonData.buildError("输入格式不正确");
        }else {
            return JsonData.buildSuccess("修改成功");
        }
    }
    //用户页面
    @PostMapping("selectUser")
    public JsonData selectUser(Integer page, Integer limit, UserVo userVo){
        IPage<UserVo> UserEntityIPage = userService.userSelectuser(page+1, limit, userVo);
        if(UserEntityIPage!=null){
            return JsonData.buildSuccess(UserEntityIPage);
        }else {
            return JsonData.buildError("error");
        }
    }
    //用户修改
    @PostMapping("updataUser")
    public JsonData updataUser(@RequestBody UserEntity user){
        UserEntity userEntity = userService.userUpdateuser(user);
        if (userEntity!=null){
            return JsonData.buildSuccess(userEntity);
        }else {
            return JsonData.buildError("error");
        }
    }
    //用户详情
    @PostMapping("userDetail")
    public JsonData userDetail( int id){

        UserEntity userEntity = userService.userDetail(id);
        return JsonData.buildSuccess(userEntity);
    }
    //删除用户
    @DeleteMapping("DelectUser")
    public JsonData DelectUser(@RequestBody UserEntity user){

        int i  = userService.userDelect(user);
        return JsonData.buildSuccess(i);
    }
    @PostMapping("/userUpload")
    public JsonData userUpload(@RequestBody List<Map<String, Object>> data) {
        // 处理上传的数据
        for (int i=0;i<data.size();i++){
            Map<String, Object> data1 = data.get(i); // 获取第一个人的信息
            System.out.println(data1);
            UserEntity userEntity1=new UserEntity();
            for (Map.Entry<String, Object> entry : data1.entrySet()) {
                switch (entry.getKey()) {
// 小括号中的表达式或者变量结果类型可以是：int char String byte short
                    case "name":
// 相当于if(num==1){}//case 后面的值必须是常量 'A' "星期一"
                        userEntity1.setName((String) entry.getValue());
                        System.out.println(entry.getValue());
                        break;// 执行完毕一个case分支后跳出switch语句块
                    case "collegeId":// 相当于if(num==2)
                        userEntity1.setCollegeId((Integer) entry.getValue());
                        System.out.println(entry.getValue());

                        break;
                    case "number":// 相当于if(num==3)
                        userEntity1.setNumber((Integer) entry.getValue());
                        System.out.println(entry.getValue());

                        break;
                    case "password":// 相当于if(num==3)
                        userEntity1.setPassword((String) entry.getValue());
                        System.out.println(entry.getValue());

                        break;
                    case "phone":// 相当于if(num==3)
                        userEntity1.setPhone((Long) entry.getValue());
                        System.out.println(entry.getValue());
                        break;
                    case "sex":// 相当于if(num==3)
                        userEntity1.setSex((Integer) entry.getValue());
                        System.out.println(entry.getValue());
                        break;
                    default:// 相当于else ,是可选的
                        System.out.println("再接再厉");

                        break;        }
            }
            System.out.println(userEntity1);
            userService.userRegister(userEntity1);
        }
        return JsonData.buildSuccess("上传成功");
    }
    //用户修改密码
    @PostMapping("updataUserPassword")
    public JsonData updataUserPassword(@RequestBody UserEntity user){
        UserEntity userEntity = userService.userUpdatePassword(user);
        if (userEntity!=null){
            return JsonData.buildSuccess(userEntity);
        }else {
            return JsonData.buildError("error");
        }
    }

}

