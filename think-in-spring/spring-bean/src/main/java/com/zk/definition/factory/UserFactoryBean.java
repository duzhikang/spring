package com.zk.definition.factory;/**
 * Created by dzk on 2020/4/4.
 */

import com.zk.ioc.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName UserFactoryBean
 * @Description FactoryBean是一个工厂Bean，可以生成某一个类型Bean实例，它最大的一个作用是：
 * 可以让我们自定义Bean的创建过程。BeanFactory是Spring容器中的一个基本类也是很重要的一个类，
 * 在BeanFactory中可以创建和管理Spring容器中的Bean，它对于Bean的创建有一个统一的流程

 * @Author dzk
 * @Version v1
 * @Date 2020/4/4
 **/
public class UserFactoryBean implements FactoryBean {


    @Override
    public Object getObject() throws Exception {
        return User.createUsrer();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
