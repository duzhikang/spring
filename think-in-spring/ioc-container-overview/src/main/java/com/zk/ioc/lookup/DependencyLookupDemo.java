package com.zk.ioc.lookup;/**
 * Created by dzk on 2020/1/14.
 */

import com.zk.ioc.domain.User;
import com.zk.ioc.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName DependencyLookupDemo
 * @Description
 * @Author dzk
 * @Version v1
 * @Date 2020/1/14
 **/
public class DependencyLookupDemo {

    public static void main(String[] args) {

        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        // IOC容器的最基本形式，并提供了IOC容器应遵守的的最基本的接口，也就是Spring IOC所遵守的最底层和最基本的编程规
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }
}
