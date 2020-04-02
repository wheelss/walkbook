package com.xiekai.demo.rotation.controller;

import com.xiekai.demo.good.entity.GoodInfo;
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
            logger.error("轮播图删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改轮播图状态
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("updateRotationStatus")
    public AppResponse updateRotationStatus(String updateUser,String status,
                                        String rotationId,String expiryDate) {
        try {
            return rotationService.updateRotationStatus(updateUser,status,rotationId,expiryDate);
        } catch (Exception e) {
            logger.error("修改轮播图状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 轮播图列表(分页)
     * @param
     * @return AppResponse
     * @author xiekai
     * @Date 2020-04-02
     */
    @RequestMapping(value = "listRotation")
    public AppResponse listRotation(RotationInfo rotationInfo) {
        try {
            return rotationService.listRotation(rotationInfo);
        } catch (Exception e) {
            logger.error("查询轮播图列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 选择商品
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-2
     */
    @RequestMapping(value = "listRotationGood")
    public AppResponse listGood(GoodInfo goodInfo) {
        try {
            return rotationService.listRotationGood(goodInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
