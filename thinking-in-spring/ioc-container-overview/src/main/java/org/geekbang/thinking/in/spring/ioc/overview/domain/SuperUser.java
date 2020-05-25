package org.geekbang.thinking.in.spring.ioc.overview.domain;

import lombok.Data;
import org.geekbang.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/5/25 17:11
 */
@Data
@Super
public class SuperUser extends User {

    private String address;

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
