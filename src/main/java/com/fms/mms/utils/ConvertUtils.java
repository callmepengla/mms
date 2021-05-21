package com.fms.mms.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 转换工具类
 * @author admin
 */
public class ConvertUtils {
    private static Logger logger = LoggerFactory.getLogger(ConvertUtils.class);

    private final static ObjectMapper objectMapper;

    static {
        objectMapper = initObjectMapper(new ObjectMapper());
    }

    /**
     * 初始化 ObjectMapper
     *
     * @param objectMapper
     * @return
     */
    public static ObjectMapper initObjectMapper(ObjectMapper objectMapper) {
        if (Objects.isNull(objectMapper)) {
            objectMapper = new ObjectMapper();
        }
        return doInitObjectMapper(objectMapper);
    }

    /**
     * 初始化 ObjectMapper 时间方法
     *
     * @param objectMapper
     * @return
     */
    @SuppressWarnings("deprecation")
    private static ObjectMapper doInitObjectMapper(ObjectMapper objectMapper) {
        // 开启全局漂亮的JSON字符串打印
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        // 禁用时间格式串行，使其输出正常的时间字符串格式
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // 不显示为null的字段
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 忽略不能转移的字符
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        // 过滤对象的null属性.
        // objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 忽略transient
        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        return registerModule(objectMapper);
    }

    /**
     * 注册模块
     *
     * @param objectMapper
     * @return
     */
    private static ObjectMapper registerModule(ObjectMapper objectMapper) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(LocalDateTime.class,
                new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        simpleModule.addDeserializer(LocalDateTime.class,
                new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        simpleModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        simpleModule.addDeserializer(LocalDate.class,
                new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        simpleModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        simpleModule.addDeserializer(LocalTime.class,
                new LocalTimeDeserializer((DateTimeFormatter.ofPattern("HH:mm:ss"))));
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }

    /**
     * pojo<E> 转 pojo<T>
     *
     * @param <T>
     * @param source
     * @param target
     * @return
     */
    public static <T> T sourceToTarget(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }
        T targetObject = null;
        try {
            targetObject = target.newInstance();
            BeanUtils.copyProperties(source, targetObject);
        } catch (Exception e) {
            logger.error("convert sourceToTarget error ", e);
        }

        return targetObject;
    }

    /**
     * list<?> 转 list<T>
     *
     * @param <T>
     * @param sourceList
     * @param target
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> List<T> sourceToTarget(Collection<?> sourceList, Class<T> target) {
        if (sourceList == null) {
            return null;
        }

        List targetList = new ArrayList<>(sourceList.size());
        try {
            for (Object source : sourceList) {
                T targetObject = target.newInstance();
                BeanUtils.copyProperties(source, targetObject);
                targetList.add(targetObject);
            }
        } catch (Exception e) {
            logger.error("convert sourceListToTarget error ", e);
        }

        return targetList;
    }

    /**
     * 将任意vo转化成map
     *
     * @param t vo对象
     * @return
     */
    public static <T> Map<String, Object> convert2Map(T t) {
        if (t == null) {
            return null;
        }
        Map<String, Object> result = new HashMap<String, Object>(16);
        Method[] methods = t.getClass().getMethods();
        try {
            for (Method method : methods) {
                Class<?>[] paramClass = method.getParameterTypes();
                // 如果方法带参数，则跳过
                if (paramClass.length > 0) {
                    continue;
                }
                String methodName = method.getName();
                if (methodName.startsWith("get")) {
                    Object value = method.invoke(t);
                    methodName = methodName.substring(3);
                    String tmp = methodName.substring(0, 1);
                    methodName = tmp.toLowerCase() + methodName.substring(1);
                    result.put(methodName, value);
                } else if (methodName.startsWith("is")) {
                    Object value = method.invoke(t);
                    methodName = methodName.substring(2);
                    String tmp = methodName.substring(0, 1);
                    methodName = tmp.toLowerCase() + methodName.substring(1);
                    result.put(methodName, value);
                }
            }
            return result;
        } catch (Exception e) {
            logger.error("convert convert2Map error ", e);
        }
        return null;
    }

    /**
     * 反射Mapper 数据对象
     *
     * @param map
     * @param t
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> T mapperObj(Map map, Class<T> t) {
        if (map.size() == 0 || t == null) {
            return null;
        }
        return objectMapper.convertValue(map, t);
    }
}
