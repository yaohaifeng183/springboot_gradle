package com.example.demogradle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demogradle.entity.RuralEconomyIndex;

import java.util.List;
import java.util.Set;

public interface RuralEconomyIndexService extends IService<RuralEconomyIndex> {

    RuralEconomyIndex getOne(int id);

    List<RuralEconomyIndex> getAllValue();

    Set<String> getFiledValue(String indexName);

    Boolean addMongodb();

    List<String> getEs();

}
