package com.zk.ioc.lookup;

import com.zk.ioc.domain.User;
import com.zk.ioc.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * <p>ClassName: DependencyInjectionDemo</p>
 * <p>Description: </p>
 * <p>Company: 爱用科技有限公司</p>
 *
 * @author zhikang.du
 * @version v1.0
 * @date: 2020/1/19
 * @since JDK 1.8
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        // IOC容器的最基本形式，并提供了IOC容器应遵守的的最基本的接口，也就是Spring IOC所遵守的最底层和最基本的编程规
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        UserRepository repository = (UserRepository) beanFactory.getBean("userRepository");
        // System.out.println(repository.getUsers());
        // org.springframework.beans.factory.support.DefaultListableBeanFactory@3b81a1bc
        // 依赖注入
        System.out.println(repository.getBeanFactory());
        // System.out.println(repository.getBeanFactory() == beanFactory);
        // 依赖查找
        // System.out.println(beanFactory.getBean(BeanFactory.class));
        // 而ObjectFactory就是一个普通的工厂对象接口，对于spring在doGetBean处的使用时，在于创建对象的过程由框架通过ObjectFactory定义，而
        //    创建的时机交给拓展接口Scope，除此之外ObjectFactory就是一个普通的接口。
        ObjectFactory userFactory = repository.getObjectFactory();

        System.out.println(userFactory.getObject() == beanFactory);
        // 依赖注入 和 依赖查找并不是同一个来源

        // 容器内建 bean
        Environment bean = beanFactory.getBean(Environment.class);
        System.out.println("容器内建 bean" +  bean);
    }

    private static void whoIsIoCContainer(UserRepository userRepository, ApplicationContext applicationContext) {


        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory

        // ConfigurableApplicationContext#getBeanFactory()


        // 这个表达式为什么不会成立
        System.out.println(userRepository.getBeanFactory() == applicationContext);

        // ApplicationContext is BeanFactory

    }
}
