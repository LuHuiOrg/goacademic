package com.lh.site.utils.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源路由
 * @author zengxiaohui
 * @date 2017年7月26日 下午5:02:06
 * @version 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHandle.getDataSource();
	}

}
