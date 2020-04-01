package com.xiekai.demo.rotation.controller;

import com.xiekai.demo.rotation.entity.RotationInfo;
import com.xiekai.demo.rotation.service.RotationService;
import com.xiekai.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 轮播图管理 增删查改 启用禁用 选择商品
 *
 * @author xiekai
 * @time 2020-3-27
 */
@RestController
@RequestMapping("/rotation")
public class RotationController {

    private static final Logger logger = LoggerFactory.getLogger(RotationController.class);

    @Resource
    private RotationService rotationService;

    /**
     * 新增轮播图
     *
     * @return
     * @author xiekai
     * @time 2020-3-27
     */
    @PostMapping("saveRotation")
    public AppResponse saveRotation(RotationInfo rotationInfo) {
        try {
            AppResponse appResponse = rotationService.saveRotation(rotationInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除轮播图
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-31
     */
    @PostMapping("deleteRotation")
    public AppResponse deleteRotation(String rotationId, String updateUser) {
        try {
            return rotationService.deleteRotation(rotationId, updateUser);
        } catch (Exception e) {
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改轮播图
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
   /* @PostMapping("updateGood")
    public AppResponse updateUser(GoodInfo goodInfo) {
        try {
            return goodService.updateGood(goodInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }*/

}
