package com.lex.showcase.common;

/**
 * @author Lex Li
 */
public class PagingUtil {
    private PagingUtil() {
        throw new RuntimeException(new IllegalAccessException("Cannot initialize " + PagingUtil.class.getSimpleName()));
    }

    /**
     * 根据数据总量和每页数量计算总页数
     */
    public static int getTotalPage(int totalCount, int pageSize) {
        if (totalCount <= 0 || pageSize <= 0) {
            throw new RuntimeException("Illegal parameters, parameter must be greater than 0!");
        }
        int totalPage = 0;
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }
        return totalPage;
    }

    /**
     * 根据给定pageNo和pageSize计算offset
     */
    public static int calcPagingOffset(int pageNo, int pageSize) {
        if (pageNo < 1) {
            return 0;
        }
        return (pageNo - 1) * pageSize;
    }

    public static void main(String[] args) {
        int totalCount = 0;
        int pageSize = 100;

        int totalPage = getTotalPage(totalCount, pageSize);
        System.out.println("totalPage=" + totalPage);
    }
}
