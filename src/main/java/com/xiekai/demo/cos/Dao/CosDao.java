package com.xiekai.demo.cos.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CosDao {
    /**
     *1
     * @param urls
     * @return
     */
    int upload(@Param("urls") String urls);
}
