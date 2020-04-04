package com.xiekai.demo.cos.controller;

import com.xiekai.demo.cos.Service.CosService;
import com.xiekai.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/cos")
public class CosController {

    private static final Logger logger = LoggerFactory.getLogger(CosController.class);

    @Resource
    private CosService cosService;

    @PostMapping("uplaodCos")
    public AppResponse upload(String key, String local) {
        try {
            AppResponse appResponse = cosService.upload(key,local);
            return appResponse;
        } catch (Exception e) {
            logger.error("图片上传失败失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
