package com.xiekai.demo.goodSort.dao;

import com.xiekai.demo.goodSort.entity.GoodSortInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品分类
 *
 * @author
 * @time 2020-3-25
 */
@Mapper
public interface GoodSortDao {
    /**
     * 统计商品分类数量
     *
     * @param goodSortInfo 商品分类信息
     * @return
     */
    int countGoodSortAcct(GoodSortInfo goodSortInfo);

    /**
     * 新增商品分类
     *
     * @param goodSortInfo 商品分类信息
     * @return
     */
    int saveGoodSort(GoodSortInfo goodSortInfo);
}
