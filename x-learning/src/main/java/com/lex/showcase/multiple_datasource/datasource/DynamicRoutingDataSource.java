package com.lex.showcase.multiple_datasource.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourcePolicy dataSourcePolicy = DataSourceHolder.getAndRemove();

        if (dataSourcePolicy == null) {
            dataSourcePolicy = DataSourcePolicy.MASTER;
        }

        return dataSourcePolicy.getName();
    }

}
