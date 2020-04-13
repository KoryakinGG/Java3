package Lesson1;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> boxOfFruits = new ArrayList<>();

    public void addFruits(T fruit, int quantity) {
        for (int i = 0; i < quantity; i++) {
            boxOfFruits.add(fruit);
        }
    }

    public float getWeight () {
        // Почему нельзя использовать метод fori ?
        float sum = 0.0f;
        for (T o: boxOfFruits) {
            sum = sum + o.getWeight();
        }
        return sum;
    }

    public boolean compare (Box <?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public void pourTo (Box <T> anotherBox) {
        anotherBox.boxOfFruits.addAll(boxOfFruits);
        boxOfFruits.clear();
    }
}
