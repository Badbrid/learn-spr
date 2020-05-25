package org.geekbang.thinking.in.spring.ioc.overview.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.Super;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1. 通过名称的方式来查找
 * @author zhangsht
 * @version 1.0
 * @date 2020/5/25 16:06
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookupInRealTime(beanFactory);
        lookupInLazyTime(beanFactory);
        // 按照类型查找
        lookupByType(beanFactory);
        // 按照类型查找结合对象
        lookupCollectByType(beanFactory);
        // 通过注解查找对象
        lookupAnnotationByType(beanFactory);
    }

    private static void lookupAnnotationByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标准的所有的USer集合对象"+userMap);
        }
    }

    private static void lookupCollectByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> user = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有的USer集合对象"+user);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("单个查找"+user);
    }

    private static void lookupInLazyTime(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory =(ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找"+user);
    }


    public static void lookupInRealTime(BeanFactory beanFactory){
        User user =  (User) beanFactory.getBean("user");
        System.out.println("实时查找"+user);
    }

}
