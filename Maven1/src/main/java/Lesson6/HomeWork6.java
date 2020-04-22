package Lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
* Добавить на серверную сторону чата логирование, с выводом информации о действиях на сервере (запущен, произошла ошибка, клиент подключился, клиент прислал сообщение/команду).
* Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
* идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
* Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
* Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
* Добавить на серверную сторону сетевого чата логирование событий.*/
public class HomeWork6 {
    private static final int NUM_FOUR = 4;
    private static final int NUM_ONE = 1;

    public static void main(String[] args) {

        int[] testing1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] testing2 = {15, 2, 2, 3, 96, 7, 9, 0, 150, 5668, -51};
        int[] testing3 = {1, 2, 4, 4, 2, 3, 4, 1, 4};
        int[] testing4 = {4, 1, 2, 2, 3, 1, 7, 9, -1};
//        int[] testing5 = {};

//        System.out.println(Arrays.toString(toArrayAfterFour(testing1)));
//        System.out.println(Arrays.toString(toArrayAfterFour(testing2)));
//        System.out.println(Arrays.toString(toArrayAfterFour(testing3)));
//        System.out.println(Arrays.toString(toArrayAfterFour(testing4)));
//        System.out.println(Arrays.toString(toArrayAfterFour(testing5)));

//        System.out.println(oneOrFour(testing1));
//        System.out.println(oneOrFour(testing2));
//        System.out.println(oneOrFour(testing3));
//        System.out.println(oneOrFour(testing4));


    }


    public static int[] toArrayAfterFour(int[] incomingArray){
        if (incomingArray.length == 0) throw new NullPointerException();
        for (int i = incomingArray.length - 1; i >= 0; i--) {
            if (incomingArray[i] == NUM_FOUR) return Arrays.copyOfRange(incomingArray, i + 1, incomingArray.length);
        }
        throw new RuntimeException();
    }

    public static boolean oneOrFour (int [] incomingArray) {
        if (incomingArray.length == 0) throw new NullPointerException();
        for (int i = 0; i < incomingArray.length; i++) {
            if (incomingArray[i] == NUM_ONE || incomingArray[i] == NUM_FOUR) return true;
        }
    return false;}
}
