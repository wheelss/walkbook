package com.xiekai.demo.goodSort.controller;


import com.xiekai.demo.goodSort.entity.GoodSortInfo;
import com.xiekai.demo.goodSort.service.GoodSortService;
import com.xiekai.demo.user.entity.UserInfo;
import com.xiekai.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户管理增删改查
 *
 * @author xiekai
 * @time 2020-3-25
 */
@RestController
@RequestMapping("/goodSort")
public class GoodSortController {

    private static final Logger logger = LoggerFactory.getLogger(GoodSortController.class);

    @Resource
    private GoodSortService goodSortService;

    /**
     * 新增用户
     *
     * @param goodSortInfo
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("saveGoodSort")
    public AppResponse saveGoodSort(GoodSortInfo goodSortInfo) {
        try {
            AppResponse appResponse = goodSortService.saveGoodSort(goodSortInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
