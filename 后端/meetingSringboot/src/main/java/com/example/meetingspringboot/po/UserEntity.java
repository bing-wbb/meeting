package com.example.meetingspringboot.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wbb
 * @since 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 用户状态是否停用1为正在使用，2为停用
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

    /**
     * 0男，1女
     */
    private Integer sex;


}
