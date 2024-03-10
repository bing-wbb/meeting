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
@TableName("appointment_detail_time")
public class AppointmentDetailTimeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预约具体时间点id
     */
    @TableId(value = "appoinment_datail_time_id", type = IdType.AUTO)
    private Integer appoinmentDatailTimeId;

    /**
     * 管理员发布的会议预约id
     */
    private Integer datailAppointmentId;

    /**
     * 会议室日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datailAppointmentDate;

    /**
     * 时间段id
     */
    private Integer appointmentTimePeriodId;

    /**
     * 该时间段的预约情况（0为未预约，1为已预约）
     */
    private Integer appointmentState;

    /**
     * 会议室日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expirationTime;



}
