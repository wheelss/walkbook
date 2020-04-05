package com.xiekai.demo.user.controller;


import com.xiekai.demo.user.entity.UserInfo;
import com.xiekai.demo.user.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 新增用户
     *
     * @param userInfo
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("saveUser")
    public AppResponse saveUser(UserInfo userInfo) {
        try {
            AppResponse appResponse = userService.saveUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除用户
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userCode, String updateUser) {
        try {
            return userService.deleteUser(userCode, updateUser);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo) {
        try {
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询用户详情
     *
     * @param userCode
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-25
     */
    @RequestMapping(value = "getUserByUserCode")
    public AppResponse getUserByUserCode(String userCode) {
        try {
            return userService.getUserByUserCode(userCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 用户列表(分页)
     * @param userInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listUser")
    public AppResponse listUsers(UserInfo userInfo) {
        try {
            return userService.listUser(userInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
