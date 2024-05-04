package fishbreadshopplusjdbc;

import java.sql.*;

public class DBUtil {
    private String url = "jdbc:mysql://127.0.0.1:3306/jdbcstudydb";
    private String dbId = "study";
    private String dbPassword = "StudyLocal12!@";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void dbConnect() {
        try {
            connection = DriverManager.getConnection(url, dbId, dbPassword);
            System.out.println("database와 연결 되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
