package org.example.config;

import org.example.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 配置
 * @author: alu4r
 * @date: 2020/11/24 9:35
 */
@Configuration //告诉Spring这是一个配置类
public class MainConfig {
    //给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
    @Bean("person")
    public Person person01(){
        return new Person("lisi", 20);
    }
}
