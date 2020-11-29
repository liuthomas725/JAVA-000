package org.cc.datasource;

public class DataSourceContextHolder {

    private static ThreadLocal<String> dataSourceContext = new ThreadLocal<>();

    public static void setDataSourceContext(String dataSource) {
        dataSourceContext.set(dataSource);
    }

    public static String get() {
        return dataSourceContext.get();
    }

    public static void clear() {
        dataSourceContext.remove();
    }
}
