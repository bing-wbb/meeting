package com.example.meetingspringboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.NoticeEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.meetingspringboot.po.UserEntity;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Service
public interface NoticeService {
    //    添加公告
    NoticeEntity noticeAdd(NoticeEntity noticeEntity);
    //    公告修改
    int noticeUpdate(NoticeEntity noticeEntity);
    //    公告分页
    IPage<NoticeEntity> noticeSelect(Integer currentPage, Integer pageSize,NoticeEntity noticeEntity);
    //    公告详情
    NoticeEntity noticeDetail(Integer id);
    //    公告删除
    int noticeDelect(NoticeEntity noticeEntity);
}
