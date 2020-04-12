package Lesson2;

import java.sql.SQLException;

public class Main extends DataBase{

        public static void main(String[] args)  {

            try {
            connect();
                DataBase dataBase = new DataBase();
                isCreateTable();
                isInsertTable("Gennadiy", 10);
                isInsertTable("Vasiliy", 20);
                isInsertTable("Pavel", 30);
                isInsertTable("Artem", 40);
                isInsertTable("Andrey", 50);

                isUpdateTable(4,666);

                isDeleteTable(1);

                isSelectTable();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        disconnect();
    }
}
