package com.example.meetingspringboot.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@TableName("user_order")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户预约号
     */
    @TableId(value = "order_id", type = IdType.AUTO)
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


}
