package com.example.meetingspringboot.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public interface OssService {
    boolean upload(String filepath, InputStream inputstream);
}
