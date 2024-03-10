package com.example.meetingspringboot.util;

import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSSClient;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

public class OSSClientUtil {
    private static String endpoint = "";
    private static String accessKeyId = "";
    private static String accessKeySecret = "";
    private static String bucketName = "";
    private static String urlPrefix = "";

    @Autowired
    private static OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    /**
     * 上传图片
     *
     * @param url
     */
    public String uploadImg2Oss(MultipartFile url) throws Exception {
// 文件新路径
        String fileName = url.getOriginalFilename();
        String filePath = getFilePath(fileName);

// 上传到阿里云
        try {
// 目录结构：images/2018/12/29/xxxx.jpg
            ossClient.putObject(bucketName, filePath, new
                    ByteArrayInputStream(url.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
//关流 ossClient.shutdown();
        return urlPrefix + filePath;
    }

    private String getFilePath(String sourceFileName) {
        DateTime dateTime = new DateTime();
        return "images/" + dateTime.toString("yyyy")
                + "/" + dateTime.toString("MM") + "/"
                + dateTime.toString("dd") + "/" + System.currentTimeMillis() +
                RandomUtils.nextInt(100, 9999) + "." +
                StringUtils.substringAfterLast(sourceFileName, ".");
    }
}
