package com.hjl.Mapper;

import com.hjl.Bean.DataTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DataTestMapper {
    List<DataTest> selectAll(@Param("index") long index, @Param("limit") long limit);
    List<DataTest> queryAll();
    List<DataTest> selectAllN(@Param("index") long index,@Param("limit") long limit);
    List<DataTest> selectRemainder(@Param("limit")long limit);
    Long getCount();
}