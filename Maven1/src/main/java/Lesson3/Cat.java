package Lesson3;

import java.awt.print.Pageable;
import java.io.Serializable;

public class Cat implements Serializable  {

    String name;
    int age;

    public Cat (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info () {
        System.out.println("Cat name is " + name + " and age " + age);
    }
}
