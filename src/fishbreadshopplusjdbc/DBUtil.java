package fishbreadshopplusjdbc;

import java.sql.*;

public class DBUtil {
    String url = "jdbc:mysql://127.0.0.1:3306/jdbcstudydb";
    String dbId = "study";
    String dbPassword = "StudyLocal12!@";
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public void dbConnect() {
        try {
            connection = DriverManager.getConnection(url, dbId, dbPassword);
            System.out.println("database와 연결 되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getFishBreadBag() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select fishbreadtype, fishbreadcount from jdbcstudydb.customer;");

            int count = 0;

            while (resultSet.next()) {
                count++;
                if (count > 1) {
                    System.out.print(", ");
                }
                System.out.print(resultSet.getString("fishbreadtype") + " " + resultSet.getString("fishbreadcount") + "개");
            }


            System.out.println("를 가지고 있군.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
