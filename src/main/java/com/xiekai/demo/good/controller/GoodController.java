package com.xiekai.demo.good.controller;

import com.xiekai.demo.good.entity.GoodInfo;
import com.xiekai.demo.good.service.GoodService;
import com.xiekai.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品管理 增删查改 一级二级分类选择 商家选择 图片上传
 *
 * @author xiekai
 * @time 2020-3-25
 */
@RestController
@RequestMapping("/good")
public class GoodController {

    private static final Logger logger = LoggerFactory.getLogger(GoodController.class);

    @Resource
    private GoodService goodService;

    /**
     * 新增商品
     *
     * @param goodInfo
     * @return
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("saveGood")
    public AppResponse saveGood(GoodInfo goodInfo) {
        try {
            AppResponse appResponse = goodService.saveGood(goodInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-26
     */
    @PostMapping("deleteGood")
    public AppResponse deleteGood(String goodId, String updateUser) {
        try {
            return goodService.deleteGood(goodId, updateUser);
        } catch (Exception e) {
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("updateGood")
    public AppResponse updateUser(GoodInfo goodInfo) {
        try {
            return goodService.updateGood(goodInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品详情
     *
     * @param isbnCode
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-25
     */
    @RequestMapping(value = "getGoodByIsbnCode")
    public AppResponse getUserByUserCode(String isbnCode) {
        try {
            return goodService.getGoodByIsbnCode(isbnCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 商品列表(分页)
     *
     * @param goodInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listGood")
    public AppResponse listUsers(GoodInfo goodInfo) {
        try {
            return goodService.listGood(goodInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品状态
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("updateGoodStatus")
    public AppResponse updateGoodStatus(String updateUser,String goodStatus,String goodId) {
        try {
            return goodService.updateGoodStatus(updateUser,goodStatus,goodId);
        } catch (Exception e) {
            logger.error("修改商品状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
