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
@TableName("user_role")
public class UserRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId(value = "user_role_id", type = IdType.AUTO)
    private Integer userRoleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String bz;


}
