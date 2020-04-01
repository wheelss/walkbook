package com.xiekai.demo.rotation.dao;

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


}
