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
@TableName("building")
public class BuildingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 楼栋id
     */
    @TableId(value = "building_id", type = IdType.AUTO)
    private Integer buildingId;

    /**
     * 楼名字
     */
    private String name;

    /**
     * 备注
     */
    private String bz;


}
