package com.xiekai.demo.rotation.service;

import com.xiekai.demo.rotation.dao.RotationDao;
import com.xiekai.demo.rotation.entity.RotationInfo;
import com.xiekai.demo.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 轮播图
 * @author xiekai
 * @time 2020-3-27
 */
@Service
public class RotationService {

    @Resource
    private RotationDao rotationDao;

    /**
     * 新增轮播图
     * @param rotationInfo
     * @return
     * @author xiekai
     * @time 2020-3-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveRotation(RotationInfo rotationInfo) {
        //新增轮播图
        int count = rotationDao.saveRotation(rotationInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败,请重试");
        }
        return AppResponse.success("新增成功!");
    }

    /**
     * 删除轮播图
     * @param
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteRotation(String rotationId, String updateUser) {
        List<String> listCode = Arrays.asList(rotationId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除商品
        int count = rotationDao.deleteRotation(listCode, updateUser);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

}

