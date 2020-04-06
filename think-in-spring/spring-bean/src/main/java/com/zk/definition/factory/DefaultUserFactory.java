package com.zk.definition.factory;/**
 * Created by dzk on 2020/4/4.
 */

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @ClassName DefaultUserFactory
 * @Description
 * @Author dzk
 * @Version v1
 * @Date 2020/4/4
 **/
public class DefaultUserFactory implements UserFactory, InitializingBean {

    // 1. 基于 @PostConstruct 注解
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct : UserFactory 初始化中...1");
    }

    public void initUserFactory() {
        System.out.println("自定义初始化方法 initUserFactory() : UserFactory 初始化中...3");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet() : UserFactory 初始化中...2");
    }
}
