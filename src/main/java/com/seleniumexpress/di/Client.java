package com.seleniumexpress.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

        // Old way (setter injection)
        Student student1 = new Student();
        MathCheat cheat = new MathCheat();
        student1.setMathCheat(cheat);
        student1.cheating();

        // New way (dependency injection using inner bean)
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("beans.xml file loaded");
        Student student2 = context.getBean("student", Student.class);
        student2.cheating();

        AnotherStudent anotherStudent = context.getBean("anotherStudent", AnotherStudent.class);
        anotherStudent.startCheating();
    }

}
