package com.seasontemple.top;

import com.seasontemple.top.task.IoCTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Season Temple
 * @program: DataCrawler
 * @description: 测试类
 * @create: 2019/07/17 21:32:43
 */
@Component("app")
public class App {

    private String message;
    private LocalDateTime localDateTime;

    @Autowired
    private IoCTest ioCTest;

    public void sayHello() {
        System.out.println(message);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        System.out.println(localDateTime);
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
        App app = (App) appCon.getBean("app");
        app.setMessage("你好啊！");
        app.sayHello();
        app.setLocalDateTime(LocalDateTime.now());
        app.getLocalDateTime();
        app.ioCTest.call();

    }
}
