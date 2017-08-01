package com.lh.site.utils.datasource;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.ReflectionUtils;

/**
 * 读/写动态数据库选择处理器，根据注解自动维护数据源
 * @author zengxiaohui
 * @date 2017年7月26日 下午5:02:35
 * @version 1.0
 */
public class DynamicDataSourceProcessor implements BeanPostProcessor {

	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceProcessor.class);

	/** xml事务配置只读方法，如query* */
	private Set<String> readMethodSet = new HashSet<String>();

	@SuppressWarnings("unchecked")
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		if (!(bean instanceof NameMatchTransactionAttributeSource)) {
			return bean;
		}

		try {
			NameMatchTransactionAttributeSource transactionAttributeSource = (NameMatchTransactionAttributeSource) bean;
			Field nameMapField = ReflectionUtils.findField(NameMatchTransactionAttributeSource.class, "nameMap");
			nameMapField.setAccessible(true);

			Map<String, TransactionAttribute> nameMap = (Map<String, TransactionAttribute>) nameMapField
					.get(transactionAttributeSource);

			for (Entry<String, TransactionAttribute> entry : nameMap.entrySet()) {
				if (entry.getValue().isReadOnly()) { // 只读
					readMethodSet.add(entry.getKey());
				}
			}
		} catch (Exception e) {
			logger.error("process transaction error", e);
			throw new RuntimeException(e);
		}

		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
    
	/**
	 * 
	 * 读写分离数据源处理
	 *
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	public Object around(ProceedingJoinPoint point) throws Throwable {
		try {
			if (readOnly(point.getSignature().getName())) { // 只读
				DataSourceHandle.setReadDataSource();
			}

			Class<?> clazz = point.getTarget().getClass();
			Method method = clazz.getMethod(point.getSignature().getName(),
					((MethodSignature) point.getSignature()).getMethod().getParameterTypes());

			Transactional transactional = null;
			if (method != null && method.isAnnotationPresent(Transactional.class)) {
				transactional = method.getAnnotation(Transactional.class);

				if (transactional.readOnly()) { // 只读
					DataSourceHandle.setReadDataSource();
				} else { // 读写
					DataSourceHandle.setWriteDataSource();
				}
			}
		} catch (Exception e) {
			logger.error("动态切换数据源异常", e);
		}

		try {
			return point.proceed();
		} finally {
			DataSourceHandle.clearDataSource();
		}
	}

	/**
	 * 
	 * 根据方法判断是否只读事务
	 *
	 * @param methodName
	 *            方法名称
	 * @return true：只读，false：读写
	 */
	private Boolean readOnly(String methodName) {
		for (String mappedName : readMethodSet) {
			if (PatternMatchUtils.simpleMatch(mappedName, methodName)) {
				return true;
			}
		}
		return false;
	}
}
