package com.xiekai.demo.rotation.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiekai.demo.good.entity.GoodInfo;
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
    /**
     * demo 修改轮播图状态
     * @return
     * @Author xiekai
     * @Date 2020-04-02
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateRotationStatus(String updateUser,String status,
                                        String rotationId,String expiryDate) {
        List<String> listCode = Arrays.asList(rotationId.split(","));
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改商品信息
        int count = rotationDao.updateRotationStatus(listCode,updateUser,status,expiryDate);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 查询轮播图列表（分页）
     *
     * @param
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse listRotation(RotationInfo rotationInfo)  {

        PageHelper.startPage(rotationInfo.getPageNum(), rotationInfo.getPageSize());
        List<RotationInfo> RotationInfoList = rotationDao.listRotationByPage(rotationInfo);
        PageInfo<RotationInfo> pageData = new PageInfo<RotationInfo>(RotationInfoList);
        return AppResponse.success("查询成功！", pageData);
    }


    /**
     * 选择商品
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-2
     */
    public AppResponse listRotationGood(GoodInfo goodInfo) {
        PageHelper.startPage(goodInfo.getPageNum(), goodInfo.getPageSize());
        List<GoodInfo> goodInfoList = rotationDao.listGoodByPage(goodInfo);
        PageInfo<GoodInfo> pageData = new PageInfo<GoodInfo>(goodInfoList);
        return AppResponse.success("查询成功！", pageData);
    }
}

