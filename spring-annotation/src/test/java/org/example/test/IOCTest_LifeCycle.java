package org.example.test;

import org.example.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {
    //1、创建ioc容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

	@Test
	public void test01(){
		System.out.println("容器创建完成...");
		//applicationContext.getBean("car");
		//关闭容器
		applicationContext.close();
	}

}
