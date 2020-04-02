package com.xiekai.demo.rotation.dao;

import com.xiekai.demo.good.entity.GoodInfo;
import com.xiekai.demo.rotation.entity.RotationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RotationDao {
    /**
     * 新增商品
     *
     * @param rotationInfo 轮播图信息
     * @return
     */
    int saveRotation(RotationInfo rotationInfo);

    /**
     * 删除轮播图信息
     *
     * @param listCode 选中的轮播图编号集合
     * @return
     */
    int deleteRotation(@Param("listCode") List<String> listCode, @Param("updateUser") String updateUser);

    /**
     * 修改轮播图状态
     * @return 修改结果
     */
    int updateRotationStatus(@Param("listCode") List<String> listCode, @Param("updateUser") String updateUser,
                         @Param("status") String status, @Param("expiryDate") String expiryDate);

    /**
     * 获取所有轮播图信息
     *
     * @param rotationInfo 轮播图信息
     * @return 所有轮播图信息
     */
    List<RotationInfo> listRotationByPage(RotationInfo rotationInfo);

    /**
     * 获取所有商品信息
     * @param goodInfo 商品信息
     * @return 所有商品信息
     */
    List<GoodInfo> listGoodByPage(GoodInfo goodInfo);
}
