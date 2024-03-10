package com.example.meetingspringboot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.NoticeEntity;
import com.example.meetingspringboot.service.NoticeService;
import com.example.meetingspringboot.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@RestController
@RequestMapping("/noticeEntity")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    //    添加通知
    @PostMapping("noticeAdd")
    public JsonData addNotice(@RequestBody NoticeEntity noticeEntity){
        if (noticeEntity.getSubject()==null){
            return JsonData.buildError("标题为空");
        }else {
            NoticeEntity noticeEntity1 = noticeService.noticeAdd(noticeEntity);
            if(noticeEntity1==null){
                return JsonData.buildError("用户已存在");
            }
            return JsonData.buildSuccess(noticeEntity1);
        }

    }
    //通知页面
    @PostMapping("selectNotice")
    public JsonData selectNotice(Integer page,Integer limit,NoticeEntity noticeEntity){
        IPage<NoticeEntity> noticeEntityIPage = noticeService.noticeSelect(page, limit, noticeEntity);
        if(noticeEntityIPage!=null){
            return JsonData.buildSuccess(noticeEntityIPage);
        }else {
            return JsonData.buildError("error");
        }
    }
    //通知修改
    @PostMapping("updataNotice")
    public JsonData updataNotice(@RequestBody NoticeEntity noticeEntity){
        int noticeEntity1 = noticeService.noticeUpdate(noticeEntity);
        if (noticeEntity1!=0){
            return JsonData.buildSuccess(noticeEntity1);
        }else {
            return JsonData.buildError("error");
        }
    }
    //通知详情
    @PostMapping("noticeDetail")
    public JsonData noticeDetail( Integer id){

        NoticeEntity noticeEntity = noticeService.noticeDetail(id);
        return JsonData.buildSuccess(noticeEntity);
    }
    //删除通知
    @DeleteMapping("delectNotice")
    public JsonData delectNotice(@RequestBody NoticeEntity noticeEntity){

        int i  = noticeService.noticeDelect(noticeEntity);
        return JsonData.buildSuccess(i);
    }

}

