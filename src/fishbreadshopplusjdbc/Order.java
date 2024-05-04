package fishbreadshopplusjdbc;

import java.sql.PreparedStatement;

public class Order {
    private int menuChoice;
    private int fishBreadCount;
    private int price;

    public Order(int menuChoice, int fishBreadCount) {
        this.menuChoice = menuChoice;
        this.fishBreadCount = fishBreadCount * 10;
        this.price = fishBreadCount * 2000;
    }

    public int getMenuChoice() {
        return menuChoice;
    }

    public int getFishBreadCount() {
        return fishBreadCount;
    }

    public int getPrice() {
        return price;
    }

    public void setMenuChoice(int menuChoice) {
        this.menuChoice = menuChoice;
    }

    public void setFishBreadCount(int fishBreadCount) {
        this.fishBreadCount = fishBreadCount * 10;
    }

    public void setPrice(int fishBreadCount) {
        this.price = fishBreadCount * 200;
    }

    public void saveDatabase(DBUtil jdbcstudydb, int menuChoice, int fishBreadCount, int price, int customerid) {
        try {
            String sqlQuery = "INSERT INTO jdbcstudydb.order (menuchoice, fishbreadcount, price, customerid) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = jdbcstudydb.getConnection().prepareStatement(sqlQuery);
            preparedStatement.setInt(1, menuChoice);
            preparedStatement.setInt(2, fishBreadCount);
            preparedStatement.setInt(3, price);
            preparedStatement.setInt(4, customerid);
            preparedStatement.executeUpdate(); // insert, update는 이 메서드를 꼭 실행
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
