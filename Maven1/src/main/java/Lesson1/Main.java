package Lesson1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Задача № 1
        String[] stringArray = {"Яблоко", "Апельсин", "Грейпфрут", "Банан", "Киви", "Кокос"};
        System.out.println("Массив: " + Arrays.toString(stringArray));
        swapData(stringArray, 0, 5);

        //Задача № 2
        ArrayList<String> newIntegerArrayList = convertAllArraysToArrayList(stringArray);
        for (String x : newIntegerArrayList) {
            System.out.print(x + " ");
        }

        // Задача № 3
        Box<Orange> boxOfOrange_1 = new Box();
        Box<Orange> boxOfOrange_2 = new Box();

        Box<Apple> boxOfApple_1 = new Box<>();
        Box<Apple> boxOfApple_2 = new Box<>();

        boxOfOrange_1.addFruits(new Orange(), 45);
        boxOfOrange_2.addFruits(new Orange(), 45);

        boxOfApple_1.addFruits(new Apple(), 40);
        boxOfApple_2.addFruits(new Apple(), 54);

        System.out.println("Вес коробки: " + boxOfOrange_1.getWeight());
        System.out.println("Сравнение коробок: " + boxOfOrange_1.compare(boxOfApple_1));

        boxOfApple_1.pourTo(boxOfApple_2);

        System.out.println("Вес 1 коробки после пересыпания: " + boxOfApple_1.getWeight());
        System.out.println("Вес 2 коробки после пересыпания: " + boxOfApple_2.getWeight());
    }

    private static void swapData(Object[] array, int i, int k) {
        try {
            Object s = array[i];
            array[i] = array[k];
            array[k] = s;
            System.out.println("Поменяли элементы " + i + " и " + k + " местами, получилось: " + Arrays.toString(array));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Введенное значение превышает длинну массива.");
        }
    }

    private static <T> ArrayList<T> convertAllArraysToArrayList(T[] objects) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            arrayList.add(i, objects[i]);
        }
        return arrayList;
    }
}