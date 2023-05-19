package com.example.demogradle.controller;


import com.example.demogradle.entity.RuralEconomyIndex;
import com.example.demogradle.service.RuralEconomyIndexService;
import com.example.demogradle.utils.Result;
import com.example.demogradle.utils.ResultEnum;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author yhf 学科情报
 * @date 2023/04/02 16:03
 **/
@RestController
@RequestMapping("/ruralEconomyIndex")
public class RuralEconomyIndexController {
    private final Logger logger = LoggerFactory.getLogger(RuralEconomyIndexController.class);

    @Autowired
    private RuralEconomyIndexService ruraleconomyindexService;

    @GetMapping("/getOne")
    @ApiOperation(value = "单个查询", httpMethod = "GET")
    public Result getOne(@RequestParam int id) {
        return Result.success(ruraleconomyindexService.getOne(id));
    }

    @GetMapping("/getall")
    @ApiOperation(value = "全部", notes = "菜单表")
    public Result getAllValue(){
        List<RuralEconomyIndex> result = new ArrayList<>();
        result = ruraleconomyindexService.getAllValue();
        return Result.success(result);
    }

    @GetMapping("/getlist")
    @ApiOperation(value = "获取指标的数据", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "indexSt", value = "一级指标", dataType = "String")
    })
    public Result userSummary(@RequestParam String indexSt){
        Set<String> set = new HashSet<>();
        set = ruraleconomyindexService.getFiledValue(indexSt);
        return Result.success(set);
    }

    @PostMapping("/mongdb/add")
    @ApiOperation(value = "插入MongoDB数据", httpMethod = "POST")
    public Result mongodbAddDatas(@RequestBody RuralEconomyIndex ruralEconomyIndex) {
        return Result.success(ruraleconomyindexService.addMongodb());
    }

    @PostMapping(value = "/post/indexname")
    @ResponseBody
    @ApiOperation(value = "post请求indexname列表", httpMethod = "POST")
    public Result postindexname(@RequestBody Map<String, Object> param) {
        Result R = new Result();
        if (param == null || param.size() <= 0) {
            logger.info("警告");
            return Result.error(ResultEnum.BAD_REQUEST,RuralEconomyIndexController.class);
        }
        try {
            String indexSt = param.getOrDefault("indexSt", "").toString();
            Map<String, String> paramsNotes = new HashMap<>();
            paramsNotes.put("indexSt", indexSt);
            Set<String> set = ruraleconomyindexService.getFiledValue(paramsNotes.get("indexSt"));
            return Result.success(set);
        } catch (Exception e) {
            R.setCode(500);
            R.setMsg(e.toString());
            return R;
        }
    }

    /**
     * @exception 插入数据
     * @param ruralEconomyIndex
     * @return
     */
    @PostMapping("/insert")
    @ApiOperation(value = "插入数据", httpMethod = "POST")
    public Result insert(@RequestBody RuralEconomyIndex ruralEconomyIndex){
        if ("".equals(ruralEconomyIndex.getIndexSt())) {
            return Result.error("参数错误");
        }
        String result = "插入失败";
//        if (ruraleconomyindexService.save(ruralEconomyIndex)){
//            result = "插入成功";
//        }
        return Result.success(result);
    }


}
