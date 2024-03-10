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
public class OrderVo implements Serializable {


    /**
     * 用户预约号
     */
    private Integer orderId;

    /**
     * 用户id
     */
    private Integer orderUserId;

    /**
     * 空闲会议室单号
     */
    private Integer orderAppointmentId;

    /**
     * 用户选择的时间段
     */
    private String orderPeriodIds;

    /**
     * 备注

     */
    private String bz;

    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 订单状态是否取消（0为正常，1为已取消）
     */
    private Integer orderState;

    /**
     * 预定人
     */
    private String orderMen;

    /**
     * 预定成员
     */
    private String member;

    /**
     * 会议主题
     */
    private String theme;

    /**
     * 审批状态（0审批通过，1待审批，2审批未通过）
     */
    private Integer approval;

    /**
     * 会议内容
     */
    private String themeContent;

    /**
     * 成员1（学号）
     */
    private Integer member1;

    /**
     * 成员2
     */
    private Integer member2;

    /**
     * 成员3
     */
    private Integer member3;



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
     * 楼名字
     */
    private String name;


    /**
     * 院系名字
     */
    private String collegeName;

    /**
     * 会议室名字
     */
    private String roomName;


    private Integer timeprice;
    /**
     * 会议室的楼层

     */
    private Integer floor;

    /**
     * 学号
     */
    private Integer number;
}