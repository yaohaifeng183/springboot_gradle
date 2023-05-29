package com.example.demogradle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demogradle.entity.RuralEconomyIndex;

import java.util.List;
import java.util.Set;

/**
 *学习mysql调用
 *
 * @author yaohaifeng
 * @since 2023/2/59
 */
public interface RuralEconomyIndexService extends IService<RuralEconomyIndex> {

    /**
     * 根据id获取 RuralEconomyIndex 详情
     *
     * @param id id
     * @return 一条 RuralEconomyIndex 数据
     */
    RuralEconomyIndex getOne(int id);

    /**
     * 获取全部数据
     *
     * @return 全部 RuralEconomyIndex 数据
     */
    List<RuralEconomyIndex> getAllValue();

    /**
     * 获取
     *
     * @param indexName 分类名称
     * @return 字符串列表
     */
    Set<String> getFiledValue(String indexName);

    /**
     * MongoDB插入数据
     *
     * @return
     */
    boolean addMongodb();

    List<String> getEs();

}
