package com.seasontemple.top.task;

import org.springframework.stereotype.Component;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: 控制反转测试类
 * @create: 2019/07/17 21:31:04
 */
@Component("iocTest")
public class IoCTest {

    public void call() {
        System.out.println("依赖注入成功！你成功调用了IoCTest类中的方法call()。");
    }
}
