package com.zk.ioc.container;

import com.zk.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.security.acl.LastOwnerException;
import java.util.Map;

/**
 * <p>ClassName: IOCContatiner</p>
 * <p>Description: </p>
 * <p>Company: 爱用科技有限公司</p>
 *
 * @author zhikang.du
 * @version v1.0
 * @date: 2020/1/19
 * @since JDK 1.8
 */
public class IOCContatiner {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // XML 配置文件 classPath 路径
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanDefinitonsCount = reader.loadBeanDefinitions(location);
        System.out.println("bean 数量 + " + beanDefinitonsCount);
        lookupCollectionByType(beanFactory);
    }


    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }
    }
}
