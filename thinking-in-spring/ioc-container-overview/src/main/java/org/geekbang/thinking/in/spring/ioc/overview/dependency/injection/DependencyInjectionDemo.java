package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.Super;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.geekbang.thinking.in.spring.ioc.overview.repository.UserRepository;
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
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        // 依赖来源一：自定义 Bean
        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);
//        System.out.println(userRepository.getUsers());
//        System.out.println(userRepository.getBeanFactory() == beanFactory);
        // 依赖来源二：依赖注入（內建依赖）
//        System.out.println(userRepository.getBeanFactory());

        ObjectFactory userFactory = userRepository.getObjectFactory();

        System.out.println(userFactory.getObject() == beanFactory );

    }


}
