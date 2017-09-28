package com.lex.showcase.mybatis.misc;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 用于将两个单表查询结果集按指定key（可能有多个）的整合合并处理，
 * 以达到SQL join关联查询的效果而提高大表数据查询效率。
 * 这种做法一般用于互联网行业等需要关联查询多张大表的数据查询。
 *
 * 参考 http://blog.csdn.net/FansUnion/article/details/41747951
 *
 */
public class MergeUtil {

    private static Logger log = LoggerFactory.getLogger(MergeUtil.class);

    private MergeUtil() {
        throw new RuntimeException("不能实例化当前工具类！");
    }

    // ********************* 合并两个集合中的所有Map *********************
    /**
     * 合并关联数据集合到主表集合中，把2个集合中的数据合并到一个集合中，通过某个主键关联（不用数据库 left join）
     */

    /**
     * 合并2个集合，先查找关联map，再合并2个单独的map，2个map中的关联key是同1个
     *
     * @param mainList
     * @param relationList
     * @param relationKey
     */
    public static void merge(List<Map<String, Object>> mainList,
                             List<Map<String, Object>> relationList, String relationKey,
                             String prefix) {
        // TODO
        if (CollectionUtils.isEmpty(mainList)) {
            return;
        }
    }

    /**
     * 合并2个集合，先查找关联map，再合并2个单独的map，合并map的key加上前缀，2个map中的关联key是2个
     *
     * @param mainList
     * @param mainKey
     * @param relationList
     * @param relationKey
     * @param prefix
     */
    public static void merge(List<Map<String, Object>> mainList, String mainKey,
                             List<Map<String, Object>> relationList, String relationKey,
                             String prefix) {
        // TODO
    }

    /**
     * 合并2个集合，先查找关联map，再合并2个单独的map，2个map中的关联key是同1个
     *
     * @param mainList
     * @param relationList
     * @param relationKey
     */
    public static void merge(List<Map<String, Object>> mainList, List<Map<String, Object>> relationList,
                             String relationKey) {
        // TODO
    }

    /**
     * 合并2个集合，2个集合中的map通过key关联
     *
     * @param mainList
     * @param mainKey
     * @param relationList
     * @param relationKey
     */
    public static void merge(List<Map<String, Object>> mainList, String mainKey,
                             List<Map<String, Object>> relationList, String relationKey) {
        // TODO
    }

    // ////////////合并2个Map，前缀prefix可要可不要，不要的情况下，key重名时，会覆盖/////////////////////

    // 合并2个map，relation中的会放到main总，key都加上prefix
    public static void merge(Map<String, Object> mainMap,
                             Map<String, Object> relation, String prefix) {
        // TODO
    }

    // 合并2个map，如果存在重复，relationMap会覆盖main中的
    public static void merge(Map<String, Object> mainMap, Map<String, Object> relationMap) {
        // TODO
    }

// ///////////////////////寻找一个Map在一个集合中的关联Map/////////////////////

    /**
     * 从一个集合中找到目标对象，如果没有找到，返回null
     *
     * @param relationKey 2个map共同的key
     */
    public static Map<String, Object> relationMap(Map<String, Object> mainMap,
                                                  List<Map<String, Object>> list, String relationKey) {
        // TODO
        return null;
    }

    // 找到1个map在集合list中需要关联的对象,分别指定各自的key
    public static Map<String, Object> relationMap(Map<String, Object> mainMap, String mainKey,
                                                  List<Map<String, Object>> list, String relationKey) {
        // TODO
        return null;
    }
}
