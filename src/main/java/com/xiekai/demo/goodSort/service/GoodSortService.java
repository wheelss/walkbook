package com.xiekai.demo.goodSort.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiekai.demo.goodSort.dao.GoodSortDao;
import com.xiekai.demo.goodSort.entity.GoodSortInfo;
import com.xiekai.demo.util.AppResponse;
import com.xiekai.demo.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户
 *
 * @author xiekai
 * @time 2020-3-25
 */
@Service
public class GoodSortService {
    @Resource
    private GoodSortDao goodSortDao;

    /**
     * 新增用户
     *
     * @param goodSortInfo
     * @return
     * @author xiekai
     * @time 2020-3-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveGoodSort(GoodSortInfo goodSortInfo) {
        int countGoodSortAcct = goodSortDao.countGoodSortAcct(goodSortInfo);
        if (0 != countGoodSortAcct) {
            return AppResponse.bizError("商品分类已存在，请重新输入！");
        }

        // 新增商品分类
        int count = goodSortDao.saveGoodSort(goodSortInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
}
