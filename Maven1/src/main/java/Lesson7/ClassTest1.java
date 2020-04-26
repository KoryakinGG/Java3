package Lesson7;

public class ClassTest1 {

    @BeforeSuite
    void methodBefore(){System.out.println("Выводим метод Before"); }
    @AfterSuite
    void methodAfter(){System.out.println("Выводим метод After"); }
//    @AfterSuite
//    void methodAfter1(){System.out.println("Выводим метод After"); }

    @Test (priority = 10)
    void method1 () {System.out.println("Выводим метод № 1 с приоритетом 10"); }
    @Test (priority = 2)
    void method2 () {
        System.out.println("Выводим метод № 2 с приоритетом 2");
    }
    @Test (priority = 8)
    void method3 () {
        System.out.println("Выводим метод № 3 с приоритетом 8");
    }
    @Test (priority = 5)
    void method4 () {
        System.out.println("Выводим метод № 4 с приоритетом 5");
    }
    @Test (priority = 3)
    void method5 () {
        System.out.println("Выводим метод № 5 с приоритетом 3");
    }
    @Test (priority = 9)
    void method6 () {
        System.out.println("Выводим метод № 6 с приоритетом 9");
    }
    @Test (priority = 6)
    void method7 () {
        System.out.println("Выводим метод № 7 с приоритетом 6");
    }
    @Test (priority = 2)
    void method8 () {
        System.out.println("Выводим метод № 8 с приоритетом 2");
    }


}
