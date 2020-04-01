package com.xiekai.demo.good.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiekai.demo.good.dao.GoodDao;
import com.xiekai.demo.good.entity.GoodInfo;
import com.xiekai.demo.util.AppResponse;
import com.xiekai.demo.util.RedisOperator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 商品
 *
 * @author xiekai
 * @time 2020-3-26
 */
@Service
public class GoodService {

    @Resource
    private GoodDao goodDao;
    @Resource
    private RedisOperator redisOperator;


    /**
     * 新增用户
     *
     * @param goodInfo
     * @return
     * @author xiekai
     * @time 2020-3-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveGood(GoodInfo goodInfo) {
        //检验商品是否存在
        int countUserAcct = goodDao.countGoodAcct(goodInfo);
        if (0 != countUserAcct) {
            return AppResponse.bizError("商品已存在，请重新输入！");
        }
        goodInfo.setIsDelete(0);
        // 新增商品
        int count = goodDao.saveGood(goodInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 删除商品
     *
     * @param isbnCode
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGood(String isbnCode, String updateUser) {
        List<String> listCode = Arrays.asList(isbnCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除商品
        int count = goodDao.deleteGood(listCode, updateUser);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 修改商品
     *
     * @param goodInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGood(GoodInfo goodInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAcct = goodDao.countGoodAcct(goodInfo);
        if (0 == countUserAcct) {
            return AppResponse.bizError("商品不存在");
        }
        // 修改商品信息
        int count = goodDao.updateGood(goodInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询商品详情
     *
     * @param isbnCode
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse getGoodByIsbnCode(String isbnCode) {
        GoodInfo goodInfo = goodDao.getGoodByIsbnCode(isbnCode);
        return AppResponse.success("查询成功！", goodInfo);
    }

    /**
     * demo 查询商品列表（分页）
     *
     * @param goodInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse listGood(GoodInfo goodInfo) {

        PageHelper.startPage(goodInfo.getPageNum(), goodInfo.getPageSize());
        List<GoodInfo> goodInfoList = goodDao.listGoodByPage(goodInfo);
        PageInfo<GoodInfo> pageData = new PageInfo<GoodInfo>(goodInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * demo 修改商品状态
     *
     * @param goodInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodStatus(GoodInfo goodInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAcct = goodDao.countGoodAcct(goodInfo);
        if (0 == countUserAcct) {
            return AppResponse.bizError("商品不存在");
        }
        // 修改商品信息
        int count = goodDao.updateGoodStatus(goodInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
}
