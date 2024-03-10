package com.example.meetingspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.meetingspringboot.dao.UserMapper;
import com.example.meetingspringboot.po.NoticeEntity;
import com.example.meetingspringboot.dao.NoticeMapper;
import com.example.meetingspringboot.po.UserEntity;
import com.example.meetingspringboot.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private NoticeMapper noticeMapper;
    @Override
    public NoticeEntity noticeAdd(NoticeEntity noticeEntity) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        noticeEntity.setReleaseDate(date);
        noticeMapper.insert(noticeEntity);
        NoticeEntity noticeEntity1 = new NoticeEntity();
        BeanUtils.copyProperties(noticeEntity,noticeEntity1);
        return noticeEntity1;

    }

    @Override
    public int noticeUpdate(NoticeEntity noticeEntity) {
        int i=noticeMapper.updateById(noticeEntity);
        return i;
    }

    @Override
    public IPage<NoticeEntity> noticeSelect(Integer currentPage, Integer pageSize, NoticeEntity noticeEntity) {
        IPage<NoticeEntity>iPage=new Page<>(currentPage,pageSize);
        QueryWrapper<NoticeEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNoneBlank(noticeEntity.getSubject()),"subject",noticeEntity.getSubject());
        IPage<NoticeEntity> onlineMovieVOIPage = noticeMapper.selectNotice(iPage, queryWrapper);
        List<NoticeEntity> records = onlineMovieVOIPage.getRecords();
        onlineMovieVOIPage.setRecords(records);
        return onlineMovieVOIPage;
    }

    @Override
    public NoticeEntity noticeDetail(Integer id) {
        NoticeEntity noticeEntity=noticeMapper.selectById(id);
        return noticeEntity;
    }

    @Override
    public int noticeDelect(NoticeEntity noticeEntity) {
        int i=noticeMapper.deleteById(noticeEntity);
        return i;
    }
}
