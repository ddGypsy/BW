package com.hjl.Service.Impl;

import com.hjl.Bean.DataTest;
import com.hjl.Service.DataService;
import com.hjl.Mapper.DataTestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Resource
    private DataTestMapper dataTestMapper;

    @Override
    public List<DataTest> selectAll(long index, long limit) {
        return dataTestMapper.selectAll(index,limit);
    }

    @Override
    public List<DataTest> queryAll() {
        return dataTestMapper.queryAll();
    }

    @Override
    public List<DataTest> selectAllN(long index,long limit) {
        return dataTestMapper.selectAllN(index,limit);
    }

    @Override
    public List<DataTest> selectRemainder(long limit) {
        return dataTestMapper.selectRemainder(limit);
    }

    @Override
    public Long getCount() {
        return dataTestMapper.getCount();
    }
}
