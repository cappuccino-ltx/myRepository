package com.ltx.spring.bean;

import org.springframework.beans.factory.FactoryBean;

public class UserFactory implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    /**
     * 这个方法是接口默认实现的，
     * @return 默认返回true，代表这个工厂使用单例模式，
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
