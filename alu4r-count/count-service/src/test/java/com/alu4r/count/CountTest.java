package com.alu4r.count;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: alu4r
 * @date: 2020/11/26 15:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountTest {
    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void test(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
