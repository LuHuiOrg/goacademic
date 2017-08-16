package com.lh.back.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源路由
 * @author zengxiaohui
 * @date 2017年8月16日 下午1:59:48
 * @version 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHandle.getDataSource();
	}

}
