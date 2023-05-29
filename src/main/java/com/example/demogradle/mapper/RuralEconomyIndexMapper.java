package com.example.demogradle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demogradle.entity.RuralEconomyIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *
 *
 * @author yaohaifeng
 * @since 2023/5/29
 */
@Mapper
public interface RuralEconomyIndexMapper extends BaseMapper<RuralEconomyIndex>{

    /**
     * 获取 RuralEconomyIndex 详情
     *
     * @param id id
     * @return RuralEconomyIndex 详情
     */
    RuralEconomyIndex getOne(int id);

    /**
     * 获取 RuralEconomyIndex 集合
     *
     * @return RuralEconomyIndex 集合
     */
    List<RuralEconomyIndex> getAll();

    /**
     * 查询所有的分类的集合
     *
     * @param indexName 一级分类名称
     * @return
     */
    Set<String> getIndexNdValue(@Param(value = "indexName") String indexName);

}
