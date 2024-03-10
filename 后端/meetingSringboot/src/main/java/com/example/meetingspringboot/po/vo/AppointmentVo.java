package com.example.meetingspringboot.po.vo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentVo implements Serializable {
//    @TableId
    /**
     * 管理员发布的会议室可预约信息id
     */
    private Integer appointmentId;
    /**
     * 会议室id
     */
    private Integer appointmentRoomId;

    /**
     * 会议室名字
     */
    private String roomName;

    /**
     * 会议室详细情况（拥有设备等）
     */
    private String roomDetail;

    /**
     * 会议室所在的楼栋
     */
    private Integer roomBuildingId;
    /**
     * 楼名字
     */
    private String name;

    /**
     * 会议室所属系id（默认为1则是所有系）
     */
    private Integer roomCollegeId;
    /**
     * 院系名字
     */
    private String collegeName;
    /**
     * 会议室的楼层

     */
    private Integer floor;

    /**
     * 会议室最大容量
     */
    private Integer max;

    /**
     * 会议室状态（0为存在1为停用）
     */
    private Integer state;

    /**
     * 选择的日期
     */
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd ")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;

    /**
     * 选择的时间段
     */
    private String appointmentPeriodIds;
    private String appointmentPeriodTimeProid;

    /**
     * 备注

     */
    private String bz;


}
