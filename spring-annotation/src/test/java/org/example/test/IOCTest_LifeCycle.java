package org.example.test;

import org.example.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {
    //1������ioc����
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

	@Test
	public void test01(){
		System.out.println("�����������...");
		//applicationContext.getBean("car");
		//�ر�����
		applicationContext.close();
	}

}
