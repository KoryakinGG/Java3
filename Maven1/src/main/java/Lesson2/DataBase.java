package Lesson2;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static Connection connection;
    private static Statement stmt;
    private static List<String> arrayOfStudents = new ArrayList<>();

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void isCreateTable() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Students (\n" +      // cоздание таблицы Студенты
                " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +           // создание поля id с автоприсвоением и основным ключом
                "  name TEXT NOT NULL,\n" +                                     // добавление текствого столбца
                "  score INTEGER NOT NULL\n" +                                  // добавление цифрового столбца
                ");\n");
        System.out.println("Создали таблицу");
    }

    public static void isUpdateTable(int id, int score) throws SQLException {
        stmt.executeUpdate("\n" +
                "UPDATE Students SET score = " + score + " WHERE id = " + id + ";");   // Изменение данных в таблице
        System.out.println("В таблице Students изменено id # " + id + " , изменены очки = " + score + ";");
    }

    public static void isDeleteTable(int id) throws SQLException {
        stmt.executeUpdate("DELETE FROM Students WHERE id = " + id + ";");      //удаление данных из таблицы
        System.out.println("Из таблицы удалена строка с номером id = " + id);
    }

    public static void isInsertTable(String name, int score) throws SQLException {  // вставление данных в таблице
        stmt.executeUpdate("INSERT INTO Students (name, score) VALUES ('" +name+"', "+score+")");

        System.out.println("Данные добавлены: name = " + name + ", score = " + score);
    }

    public static void isSelectTable() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT id, name, score FROM Students");
        while (rs.next()) {                     // Пока есть строки
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int score = rs.getInt(3);
            System.out.println(id + " " + name + " " + score);
        }
    }
}
