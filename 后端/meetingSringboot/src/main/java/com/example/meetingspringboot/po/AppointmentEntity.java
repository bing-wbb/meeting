package com.example.meetingspringboot.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName("appointment")
public class AppointmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员发布的会议室可预约信息id
     */
    @TableId(value = "appointment_id", type = IdType.AUTO)
    private Integer appointmentId;

    /**
     * 会议室id
     */
    private Integer appointmentRoomId;

    /**
     * 选择的日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;

    /**
     * 选择的时间段
     */
    private String appointmentPeriodIds;

    /**
     * 备注

     */
    private String bz;

    private String appointmentPeriodTimeProid;

}
