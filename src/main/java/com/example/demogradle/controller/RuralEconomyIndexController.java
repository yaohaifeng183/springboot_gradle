package com.example.demogradle.controller;


import com.example.demogradle.entity.RuralEconomyIndex;
import com.example.demogradle.service.IRuralEconomyIndexService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ruralEconomyIndex")
public class RuralEconomyIndexController {

    @Autowired
    private IRuralEconomyIndexService ruraleconomyindexService;

    @GetMapping("/getOne")
    @ApiOperation(value = "单个查询", httpMethod = "GET")
    public RuralEconomyIndex getOne(@RequestParam int id) {
        return ruraleconomyindexService.getOne(id);
    }

    @GetMapping("/getall")
    @ApiOperation(value = "全部", notes = "菜单表")
    public List<RuralEconomyIndex> getAllValue(){
        List<RuralEconomyIndex> result = ruraleconomyindexService.getAllValue();
//        result = ruraleconomyindexService.getAllValue();
        return result;
    }

    @GetMapping("/getlist")
    @ApiOperation(value = "获取指标的数据", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "indexSt", value = "一级指标", dataType = "String")
    })
    public Set<String> userSummary(@RequestParam String indexSt){
        return ruraleconomyindexService.getFiledValue(indexSt);
    }


}
