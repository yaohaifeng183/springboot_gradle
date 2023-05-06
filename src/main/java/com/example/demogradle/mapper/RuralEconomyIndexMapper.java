package com.example.demogradle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demogradle.entity.RuralEconomyIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;
import java.util.Map;
import java.util.Set;


@Mapper
public interface RuralEconomyIndexMapper extends BaseMapper<RuralEconomyIndex>{

//    @Select("select * from ruraleconomyindex where id=#{id}")
//    RuralEconomyIndex getOne(int id);
    RuralEconomyIndex getOne(int id);

    List<RuralEconomyIndex> getAll();

    Set<String> getIndexNdValue(@Param(value = "indexName") String indexName);

}
