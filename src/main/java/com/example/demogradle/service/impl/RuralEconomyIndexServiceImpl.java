package com.example.demogradle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demogradle.entity.RuralEconomyIndex;
import com.example.demogradle.mapper.RuralEconomyIndexMapper;
import com.example.demogradle.service.IRuralEconomyIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RuralEconomyIndexServiceImpl extends ServiceImpl<RuralEconomyIndexMapper, RuralEconomyIndex> implements IRuralEconomyIndexService {

    @Autowired
    private RuralEconomyIndexMapper ruraleconomyindexMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RuralEconomyIndex getOne(int id){
        redisTemplate.opsForValue().set("test","redis缓存mpl",24, TimeUnit.HOURS);
        RuralEconomyIndex one = ruraleconomyindexMapper.getOne(id);
        return one;
    }

    @Override
    public List<RuralEconomyIndex> getAllValue(){
        List<RuralEconomyIndex> list = new ArrayList<>();
        list = ruraleconomyindexMapper.getAll();
        return list;
    }

    @Override
    public Set<String> getFiledValue(String indexName) {
        Set<String> set = new HashSet<>();
        set = ruraleconomyindexMapper.getIndexNdValue(indexName);
        return set;
    }
}
