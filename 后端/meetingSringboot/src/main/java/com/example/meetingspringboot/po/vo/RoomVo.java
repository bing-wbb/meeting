package com.example.meetingspringboot.po.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoomVo implements Serializable {
    private Integer roomId;

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

}
