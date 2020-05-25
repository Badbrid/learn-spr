package org.geekbang.thinking.in.spring.ioc.overview.repository;

import lombok.Data;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.applet.AppletContext;
import java.util.Collection;

/**
 * 用户信息仓库
 *
 * @author zhangsht
 * @version 1.0
 * @date 2020/5/25 17:40
 */
@Data
public class UserRepository {
    private Collection<User> users;// 自定义 Bean

    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> objectFactory;
}
