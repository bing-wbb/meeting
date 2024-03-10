package com.example.meetingspringboot.po.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class RoomEchartsVo implements Serializable {
        private Integer empty;
        private Integer using;


}
