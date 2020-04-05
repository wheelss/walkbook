package com.xiekai.demo.good.dao;

import com.xiekai.demo.good.entity.GoodInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品
 *
 * @author xiekai
 * @time 2020-3-26
 */
@Mapper
public interface GoodDao {
    /**
     * 统计商品数量
     *
     * @param goodInfo 商品信息
     * @return
     */
    int countGoodAcct(GoodInfo goodInfo);

    /**
     * 新增商品
     *
     * @param goodInfo 商品信息
     * @return
     */
    int addGoods(GoodInfo goodInfo);
//
    /**
     * 删除商品信息
     *
     * @param listCode 选中的商品编号集合
     * @return
     */
    int deleteGoods(@Param("listCode") List<String> listCode, @Param("updateUser") String updateUser);

    /**
     * 修改商品信息
     *
     * @param goodInfo 商品信息
     * @return 修改结果
     */
    int updateGoods(GoodInfo goodInfo);

    /**
     * 查询商品信息
     *
     * @param goodsId 商品id
     * @return 修改结果
     */
    GoodInfo getGoods(@Param("goodsId") String goodsId);

    /**
     * 获取所有商品信息
     *
     * @param goodInfo 商品信息
     * @return 所有商品信息
     */
    List<GoodInfo> listGoodsPage(GoodInfo goodInfo);

    /**
     * 修改商品状态
     * @return 修改结果
     */
    int updateGoodsShelfState(@Param(value = "listUpdate") List<GoodInfo> listUpdate);
}
