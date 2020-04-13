package Lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class HomeWork3MainTasks {
    public static void main(String[] args) throws IOException {
    // Задача № 1
// String filePath = "C:/Users/korya/Desktop/NC8-ET9-AMT.txt";
// isReadFile(filePath);

    // Задача № 2
// String filePath1 = "C:/Users/korya/Desktop/NC8-ET9-AMT.txt";
// String filePath2 = "C:/Users/korya/Desktop/1.txt";
// String filePath3 = "C:/Users/korya/Desktop/2.txt";
// String filePath4 = "C:/Users/korya/Desktop/3.txt";
// String filePath5 = "C:/Users/korya/Desktop/4.txt";
// isMergeFiles(filePath1, filePath2, filePath3, filePath4, filePath5);

    // Задача № 3
// isReadPages("C:/Users/korya/Desktop/NC8-ET9-AMT.txt");


}

    public static void isReadFile (String file) {

        int i;
        try (FileInputStream fis = new FileInputStream(file);) {
            while ((i = fis.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void isMergeFiles (String file1, String file2, String file3, String file4, String file5) throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();
        al.add(new FileInputStream(file1));
        al.add(new FileInputStream(file2));
        al.add(new FileInputStream(file3));
        al.add(new FileInputStream(file4));
        al.add(new FileInputStream(file5));

        SequenceInputStream e = new SequenceInputStream(Collections.enumeration(al));
        int x;
        while ((x = e.read()) != -1) {
            System.out.print((char) x);
        }
        e.close();
    }

    private static void isReadPages (String file) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        byte[] bytes = new byte[1800];
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            long fileLength = raf.length();
            long pagesLength = 1800;
            long pages = fileLength / pagesLength;
            System.out.println("Длинна файла " + fileLength + " | Страница " + pagesLength + " | Количество страниц " + pages);
            while (true) {
                System.out.println("\nВыберите страницу от 0 до " + pages + " | Для выхода введите -1");
                long i = Long.parseLong((reader.readLine()));
                if ( i >= 0 && i <= pages) {
                    raf.seek(i * pages);
                    raf.read(bytes, 0, bytes.length);
                    for (byte b : bytes) {
                        System.out.print((char) b);
                    }
                } else if (i == -1) {
                    System.out.println("До свидания!");
                    break;
                } else {
                    System.out.println("Неверная страница");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
