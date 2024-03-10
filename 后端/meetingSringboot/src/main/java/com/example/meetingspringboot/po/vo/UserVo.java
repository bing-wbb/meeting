package com.example.meetingspringboot.po.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserVo implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 昵称
     */
    private String name;

    /**
     * 用户院系
     */
    private Integer collegeId;
    /**
     * 院系名字
     */
    private String collegeName;
    /**
     * 密码
     */
    private String password;

    /**
     * 学号
     */
    private Integer number;

    /**
     * 电话号码

     */
    private Long phone;

    /**
     * 用户状态是否停用
     */
    private Integer state;

    /**
     * 用户角色（1为普通用户，2为管理员）
     */
    private String role;

    /**
     * 用户头像
     */
    private String header;
    private Integer sex;

}
