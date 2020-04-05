package com.xiekai.demo.rotation.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiekai.demo.good.entity.GoodInfo;
import com.xiekai.demo.rotation.dao.RotationDao;
import com.xiekai.demo.rotation.entity.RotationInfo;
import com.xiekai.demo.util.AppResponse;
import com.xiekai.demo.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public AppResponse addSlideshowHome(RotationInfo rotationInfo) {
        //新增轮播图
        rotationInfo.setSlideshowId(StringUtil.getCommonCode(2));
        int count = rotationDao.addSlideshowHome(rotationInfo);
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
    public AppResponse deleteSlideshowHome(String slideshowId, String updateUser) {
        List<String> listCode = Arrays.asList(slideshowId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除商品
        int count = rotationDao.deleteSlideshowHome(listCode, updateUser);
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
    public AppResponse updateSlideshowHomeState(RotationInfo rotationInfo) {
        List<String> listSlideshowId = Arrays.asList(rotationInfo.getSlideshowId().split(","));
        List<String> listVersion = Arrays.asList(rotationInfo.getVersion().split(","));
        List<RotationInfo> listUpdate = new ArrayList<>();
        int slideshowStateId = rotationInfo.getSlideshowStateId();
        String updateUser =rotationInfo.getUpdateUser();
        for (int i = 0 ; i < listSlideshowId.size() ; i++){
            RotationInfo rotationInfo1 =new RotationInfo();
            rotationInfo1.setSlideshowId(listSlideshowId.get(i));
            rotationInfo1.setVersion(listVersion.get(i));
            rotationInfo1.setSlideshowStateId(slideshowStateId);
            rotationInfo1.setUpdateUser(updateUser);
            listUpdate.add(rotationInfo1);
        }
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改轮播图状态信息
        int count = rotationDao.updateSlideshowHomeState(listUpdate);
        if (0 == count) {
            appResponse = AppResponse.bizError("修改轮播图状态失败，请重试！");
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
    public AppResponse listSlideshowHome(RotationInfo rotationInfo)  {

        PageHelper.startPage(rotationInfo.getPageNum(), rotationInfo.getPageSize());
        List<RotationInfo> RotationInfoList = rotationDao.listSlideshowHome(rotationInfo);
        PageInfo<RotationInfo> pageData = new PageInfo<RotationInfo>(RotationInfoList);
        return AppResponse.success("查询成功！", pageData);
    }


    /**
     * 选择商品
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-2
     */
    public AppResponse listGoods(GoodInfo goodInfo) {
        PageHelper.startPage(goodInfo.getPageNum(), goodInfo.getPageSize());
        List<GoodInfo> goodInfoList = rotationDao.listGoods(goodInfo);
        PageInfo<GoodInfo> pageData = new PageInfo<GoodInfo>(goodInfoList);
        return AppResponse.success("查询成功！", pageData);
    }
}

