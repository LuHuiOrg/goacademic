package com.lh.site.test.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 单元测试基类. 
 * 单元测试只需继承此类并可获得spring的应用上下文.
 * @author zengxiaohui
 * @date 2017年3月31日 上午10:43:51
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config-site.xml"})
public class BaseTest {

}
