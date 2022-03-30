package com.hjl.Service;

import com.hjl.Bean.DataTest;

import java.util.List;

public interface DataService {

    List<DataTest> selectAll(long index, long limit);
    List<DataTest> queryAll();
    List<DataTest> selectAllN(long index,long limit);
    List<DataTest> selectRemainder(long limit);
    Long getCount();
}
