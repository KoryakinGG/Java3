package Lesson6;

import java.util.Arrays;
import java.util.Collection;
import Lesson6.HomeWork6;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test1 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                {new int[]{15, 2, 2, 3, 96, 7, 9, 0, 150, 5668, -51}, new int[]{}},
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 4}, new int[]{}},
                {new int[]{4, 1, 2, 2, 3, 1, 7, 9, -1}, new int[]{1, 2, 2, 3, 1, 7, 9, -1}}
        });
    }
    private int[] in;
    private int[] out;

    public Test1(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    private HomeWork6 arrayTask;

    @BeforeClass
    public static void out(){
        System.out.println("Тест на правильность результата метода 1-ой задачи");
    }

    @Before
    public void init() {
        arrayTask = new HomeWork6();
    }

    @Test
    public void testArrayAfterFour() {
        Assert.assertArrayEquals(out, arrayTask.toArrayAfterFour(in));
    }
}
