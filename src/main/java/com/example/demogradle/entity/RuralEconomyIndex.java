package com.example.demogradle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yinfeng
 * @description 菜单表
 * @TableName menus
 * @since 2022年3月12日 下午9:40:48
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("指标表")
@TableName("RuralEconomyIndex")
public class RuralEconomyIndex {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id", example = "")
    private Integer id;

    @TableField("indexSt")
    @ApiModelProperty(value = "一级指标", example = "")
    private String indexSt;

    @TableField("indexNd")
    @ApiModelProperty(value = "二级指标", example = "")
    private String indexNd;

    @TableField("indexRd")
    @ApiModelProperty(value = "三级指标", example = "")
    private String indexRd;

    @TableField("indexTh")
    @ApiModelProperty(value = "四级指标", example = "")
    private String indexTh;

    @TableField("indexName")
    @ApiModelProperty(value = "指标名称", example = "")
    private String indexName;

    @TableField("year")
    @ApiModelProperty(value = "年", example = "")
    private String year;

    @TableField("quarter")
    @ApiModelProperty(value = "季度", example = "")
    private String quarter;

    @TableField("month")
    @ApiModelProperty(value = "月", example = "")
    private String month;

    @TableField("dataValue")
    @ApiModelProperty(value = "数值", example = "")
    private String dataValue;

    @TableField("dataUnit")
    @ApiModelProperty(value = "单位", example = "")
    private String dataUnit;

    @TableField("frequent")
    @ApiModelProperty(value = "频度", example = "")
    private String frequent;
}
