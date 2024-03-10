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
@TableName("room")
public class RoomEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会议室id
     */
    @TableId(value = "room_id", type = IdType.AUTO)
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
     * 会议室所属系id（默认为1则是所有系）
     */
    private Integer roomCollegeId;

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
