package com.example.demogradle.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demogradle.entity.RuralEconomyIndex;
import com.example.demogradle.mapper.RuralEconomyIndexMapper;
import com.example.demogradle.utils.RedisService;
import com.example.demogradle.service.IRuralEconomyIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class RuralEconomyIndexServiceImpl extends ServiceImpl<RuralEconomyIndexMapper, RuralEconomyIndex> implements IRuralEconomyIndexService {

    @Autowired
    private RuralEconomyIndexMapper ruraleconomyindexMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisService redisService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public RuralEconomyIndex getOne(int id){
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
        String redisResult = redisTemplate.opsForValue().get(indexName);
        if (StringUtils.isBlank(redisResult)){
            set = ruraleconomyindexMapper.getIndexNdValue(indexName);
            redisService.add(indexName,set,24, TimeUnit.HOURS);
        } else {
//            调用RedisService工具类来查询redis
//            List<String> list = redisService.getList(indexName, String.class);
            List<String> list = JSONArray.parseArray(redisResult, String.class);
            set = new HashSet<>(list);
        }
        return set;
    }

    @Override
    public Boolean addMongodb() {
        RuralEconomyIndex ruralEconomyIndex = new RuralEconomyIndex();
        ruralEconomyIndex.setId(1);
        ruralEconomyIndex.setIndexSt("农业农村发展");
        ruralEconomyIndex.setIndexNd("农村居民人均可支配收入变化");
        ruralEconomyIndex.setIndexName("农村居民人均可支配收入累计值");
        ruralEconomyIndex.setYear("2021");
        ruralEconomyIndex.setQuarter("1");
        ruralEconomyIndex.setDataValue("5398.0");
        ruralEconomyIndex.setDataUnit("元");
        ruralEconomyIndex.setFrequent("季度");
        List<RuralEconomyIndex> users = Arrays.asList(ruralEconomyIndex);
        mongoTemplate.insert(users, RuralEconomyIndex.class);

        return null;
    }
}
