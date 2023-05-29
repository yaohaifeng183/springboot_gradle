package com.example.demogradle.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *字符串序列化和反序列化
 *
 * @author yaohaifeng
 * @since 2023/5/29 00:00
 */
public class JsonUtils {
    private final static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    public static ObjectMapper mapper = new ObjectMapper();

    static {
        // 转换为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // 如果json中有新增的字段并且是实体类类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 对象序列化为字符串
     *
     * @param object 被序列化的对象
     * @return 字符串
     */
    public static String writeValueAsString(Object object){
        if(object == null){
            return null;
        }
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * 对象序列化为字符串
     *
     * @param object
     * @return
     */
    public static String writeValueAsStringClearWrap(Object object){
        if(object == null){
            return null;
        }
        try {
            return mapper.writeValueAsString(object).replaceAll("\t|\r|\n","");
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * object转换为实体对象
     * @param obj
     * @param valueType
     * @param <T>
     * @return
     */
    public static <T> T convertValue(Object obj, Class<T> valueType) {
        try {
            return mapper.convertValue(obj, valueType);
        } catch (IllegalArgumentException e){
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * 字符串反序列化为对象
     * @param content
     * @param valueType
     * @param <T>
     * @return
     */
    public static <T> T readValue(String content, Class<T> valueType){
        try {
            return mapper.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public static <T> T convertValue(Object obj, TypeReference<T> valueTypeRef){
        try {
            return mapper.convertValue(obj, valueTypeRef);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public static <T> T readValue(String content, TypeReference<T> valueTypeRef){
        try {
            return mapper.readValue(content, valueTypeRef);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
