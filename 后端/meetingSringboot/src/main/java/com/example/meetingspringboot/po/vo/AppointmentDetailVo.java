package com.example.meetingspringboot.po.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentDetailVo implements Serializable {
    /**
     * 预约具体时间点id
     */
    private Integer appoinmentDatailTimeId;


    /**
     * 管理员发布的会议预约id
     */
    private Integer datailAppointmentId;

    /**
     * 会议室id
     */
    private Integer appointmentRoomId;
    /**
     * 会议室日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datailAppointmentDate;
    /**
     * 会议室日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;
    /**
     * 时间段id
     */
    private Integer appointmentTimePeriodId;
    /**
     * 时间段比如8:00-9:00
     */
    private String period;

    /**
     * 该时间段的预约情况（0为未预约，1为已预约）
     */
    private Integer appointmentState;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expirationTime;
}
