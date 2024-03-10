package com.example.meetingspringboot.service.impl;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.example.meetingspringboot.service.OssService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OssServiceImpl implements OssService {

    @Override
    public boolean upload(String filepath, InputStream inputstream) {
        boolean result = false;
        // 初始化配置参数
        String OSS_ENDPOINT = "https://oss-cn-beijing.aliyuncs.com";
        String OSS_ACCESSKEYID = "LTAI5tDpXUinRhHsFTEkXvzn";
        String OSS_ACCESSKEYSECRET = "nXjcGUnouBoPRsS7HYHUI5ZukNQ6Gb";
        String OSS_BUCKET = "antique-weichat";
        OSSClient ossClient = null;
        try {
            if (filepath != null && !"".equals(filepath.trim())) {
                // 创建ClientConfiguration实例，按照您的需要修改默认参数
                ClientConfiguration conf = new ClientConfiguration();
                // 开启支持CNAME选项
                conf.setSupportCname(true);
                ossClient = new OSSClient(OSS_ENDPOINT, OSS_ACCESSKEYID, OSS_ACCESSKEYSECRET, conf);

                // 上传
                ossClient.putObject(OSS_BUCKET, filepath, inputstream);
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传异常");
        } finally {
            // 关闭client
            ossClient.shutdown();
        }
        return result;
    }



}
