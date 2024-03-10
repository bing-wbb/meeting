package com.example.meetingspringboot.controller;

import com.example.meetingspringboot.service.AppointmentService;
import com.example.meetingspringboot.service.OssService;
import com.example.meetingspringboot.util.JsonData;
import com.example.meetingspringboot.util.QrCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@RestController
@RequestMapping("/qrcode")
public class QRCodeController {
    @Autowired
    private QrCodeUtil qrCodeUtil;
    @Autowired
    private OssService ossService;
    /**
     * 根据 content 生成二维码
     *
     * @param content
     * @param width
     * @param height
     * @return
     */
    @GetMapping("/getQRCodeBase64")
    public JsonData getQRCode(@RequestParam("content") String content,
                       @RequestParam(value = "logoUrl", required = false) String logoUrl,
                       @RequestParam(value = "width", required = false) Integer width,
                       @RequestParam(value = "height", required = false) Integer height) {
        return JsonData.buildSuccess(qrCodeUtil.getBase64QRCode(content, logoUrl));
    }

    /**
     * 根据 content 生成二维码
     */
    @GetMapping(value = "/getQRCode")
    public void getQRCode(HttpServletResponse response,
                          @RequestParam("content") String content,
                          @RequestParam(value = "logoUrl", required = false) String logoUrl) throws Exception {
        ServletOutputStream stream = null;
        try {
            stream = response.getOutputStream();
            qrCodeUtil.getQRCode(content, logoUrl, stream);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }

    /**
     * 图片流上传oos
     * @param fis
     * @return
     */
    public String uploadImageUrl(InputStream fis){
        String url = "";
        try {
            String fileExt = "png";;
            //生成新的文件名
            String newfilename = "file/";
            Date now = new Date();
            SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
            newfilename += date.format(now) + "/";
            SimpleDateFormat time = new SimpleDateFormat("HHmmssSSS");
            newfilename += time.format(now);
            newfilename += "_" + new Random().nextInt(1000) + "." + fileExt;

            ossService.upload(newfilename, fis);
            url = "配置的阿里云OSS图片地址OSS_PIC_URL" + newfilename;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
}