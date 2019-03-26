package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public  class Beans {
    public static ApplicationContext context =
            new ClassPathXmlApplicationContext("Spring.xml");
}
