package Lesson7;


/*
* 1. Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов с аннотациями @Test.
* Для этого у него должен быть статический метод start(), которому в качестве параметра передается или объект типа Class, или имя класса.
* Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется, далее запущены методы с аннотациями @Test,
* а по завершению всех тестов – метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
* в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый, то порядок не имеет значения.
* Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».
Это домашнее задание никак не связано с темой тестирования через JUnit и использованием этой библиотеки, то есть проект пишется с нуля.*/


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HomeWork7 {

    public static void start(Class<?> incomingNameClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = incomingNameClass.getDeclaredMethods();    //вызываем из входящего класса задекларированные методы и помещаем их в массив
        int bsCount = 0;                            // переменная считающая BeforeSuit
        int asCount = 0;                             // переменная считающая AfterSuit
        List<Method> methodList = new ArrayList<>();   // массив для методов

        for (Method o : methods) {              //идем по методам из класса
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName(); // записываем в стринг переменную аннотации
            if (type.equals("BeforeSuite")) {       // сравниваем переменную с названием аннотации
                bsCount++;              // увеличиваем на 1
                if (bsCount > 1) throw new RuntimeException("You can use only 1 before annotation.");  // если больше 1 выкидываем эксепшн
            } else if (type.equals("AfterSuite")) {
                asCount++;
                if (asCount > 1) throw new RuntimeException("You can use only 1 after annotation.");
            } else if (type.equals("Test")) {               // если переменная равна тесту, то забираем ее из массива методов и кладем ее в массив Аррей,
                methodList.add(o);
            }
        }
        methodList.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));  // сортируем через компаратор

        for (Method o : methods) {                                                          // идем по массиву методов
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();   // получаем имя аннотации и записываем ее в переменную
            if (type.equals("BeforeSuite")) {                                               // снова сравниваем
                methodList.add(0, o);                                                    // если совпало, то помещаем в начало массива
            }
            if (type.equals("AfterSuite")) {                                               // сравниваем
                methodList.add(o);                                                         // если совпало, то в конец массива
            }
        }

        for (Method i : methodList) {                                                       //идем по массиву АррейЛист
            try {
                i.getDeclaredAnnotation(Test.class).priority();                             //берем аннотацию тест по приоритету
            } catch (NullPointerException e) {
                   }
            i.invoke(incomingNameClass.newInstance(), null);                         // и работаем с ней
        }
    }

    public static void main(String[] args) {
        try {
            start(ClassTest1.class);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            System.out.println("Что-то у тебя пошло не так, дружок. Смотри printStackTrace.");
            e.printStackTrace();
        }
    }
}
