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
@TableName("college")
public class CollegeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 院系id

     */
    @TableId(value = "college_id", type = IdType.AUTO)
    private Integer collegeId;

    /**
     * 院系名字
     */
    private String collegeName;

    /**
     * 备注
     */
    private String bz;


}
