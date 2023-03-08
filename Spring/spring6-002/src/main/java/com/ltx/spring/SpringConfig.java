package com.ltx.spring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 全注解开发：
 *      不使用xml文件，用一个类代替xml文件中的组件扫描
 *
 * 实现：1、只需要这个类实现：Configuration注解
 *      2、实现ComponentScan注解指定要扫描的包就行了（包名可以有多个）
 *
 * 注意：如果使用全注解开发，那么在获取bean的时候new的就不是ClassPathXmlApplicationContext.
 *      而是AnnotationConfigApplicationContext,
 */
@Configuration
@ComponentScan("com.ltx.spring")
public class SpringConfig {
}
