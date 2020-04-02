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
    int saveGood(GoodInfo goodInfo);
//
    /**
     * 删除商品信息
     *
     * @param listCode 选中的商品编号集合
     * @return
     */
    int deleteGood(@Param("listCode") List<String> listCode, @Param("updateUser") String updateUser);

    /**
     * 修改商品信息
     *
     * @param goodInfo 商品信息
     * @return 修改结果
     */
    int updateGood(GoodInfo goodInfo);

    /**
     * 查询商品信息
     *
     * @param goodId 商品id
     * @return 修改结果
     */
    GoodInfo getGoodByGoodId(@Param("goodId") String goodId);

    /**
     * 获取所有商品信息
     *
     * @param goodInfo 商品信息
     * @return 所有商品信息
     */
    List<GoodInfo> listGoodByPage(GoodInfo goodInfo);

    /**
     * 修改商品状态
     * @return 修改结果
     */
    int updateGoodStatus(@Param("listCode") List<String> listCode, @Param("updateUser") String updateUser,
                         @Param("goodStatus") String goodStatus );
}
