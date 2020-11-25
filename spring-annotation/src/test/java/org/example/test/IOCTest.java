package org.example.test;

import org.example.bean.Person;
import org.example.config.MainConfig;
import org.example.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/11/24 10:25
 */
public class IOCTest {
    //获取ioc容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);



    /**
     * @Conditional 注解的使用
     */
    @Test
    public void test03(){
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值；Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }
    /**
     *MainConfig2 @Scope 和 @Lazy注解的使用
     */
    @Test
    public void test02(){
        //获取ioc容器
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        //获取容器中bean的名称
        String[] beanDefinitionNames = annotationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
        Object person = annotationContext.getBean("person02");
        Object person2 = annotationContext.getBean("person02");
        System.out.println("@Scope(\"prototype\")多实例配置" + person == person2);
    }

    /**
     * @Bean
     */
    @Test
    public void test01(){
        //获取ioc容器
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取容器中bean的名称
        String[] beanDefinitionNames = acac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }

    }
}
