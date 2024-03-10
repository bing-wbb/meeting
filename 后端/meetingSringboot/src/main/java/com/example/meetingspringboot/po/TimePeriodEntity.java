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
@TableName("time_period")
public class TimePeriodEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 时间段id
     */
    @TableId(value = "period_id", type = IdType.AUTO)
    private Integer periodId;

    /**
     * 时间段比如8:00-9:00
     */
    private String period;


}
