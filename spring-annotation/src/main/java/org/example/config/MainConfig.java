package org.example.config;

import org.example.bean.Person;
import org.springframework.context.annotation.*;

/**
 * @description: 配置
 * @author: alu4r
 * @date: 2020/11/24 9:35
 */
@Configuration //告诉Spring这是一个配置类
@ComponentScans(
        value = {
                @ComponentScan(value="org.example",includeFilters = {
/*						@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),*/
                        @ComponentScan.Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
                },useDefaultFilters = false)
        }
)
//@ComponentScan(value = "org.example") //还可以排查注解
//@ComponentScan  value:指定要扫描的包
//useDefaultFilters == true ：包含所有
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {
    //给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id, bean默认名称为方法名
    @Bean("person")
    public Person person01(){
        return new Person("lisi", 20);
    }
}
