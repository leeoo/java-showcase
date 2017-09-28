package com.lex.showcase.multiple_datasource.datasource;

public class DataSourceHolder {

    public static final ThreadLocal<DataSourcePolicy> dataSource = new ThreadLocal<>();

    public static void put(DataSourcePolicy dataSourcePolicy) {
        dataSource.set(dataSourcePolicy);
    }

    public static DataSourcePolicy get() {
        return dataSource.get();
    }

    /**
     * 不建议使用！若一个Service方法里调用mybatis mapper做了两次SQL操作，那么只有第1次操作时方法上的注解
     * 生效，第2次时不生效了，因为在第1次操作后dataSource从ThreadLocal变量中删除了！！！
     * @return
     */
    @Deprecated
    public static DataSourcePolicy getAndRemove() {
        DataSourcePolicy dataSourcePolicy = dataSource.get();
        dataSource.remove();
        return dataSourcePolicy;
    }

    public static void remove() {
        dataSource.remove();
    }

}
