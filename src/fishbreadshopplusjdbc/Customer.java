package fishbreadshopplusjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Customer {
    private int amount;
    private FishBreadBag fishBreadBag;

    public int getAmount() {
        return amount;
    }

    public void getFishBreadBag() {
        if (fishBreadBag.fishBread.size() == 1) {
            System.out.print("보자 보자.. " +
                    fishBreadBag.fishBread.get(0).getFishBreadType() + "붕어빵이 " +
                    fishBreadBag.fishBread.get(0).getFishBreadCount() + "개 있네. \n");
        } else if (fishBreadBag.fishBread.size() == 2) {
            System.out.print("보자 보자.. " +
                    fishBreadBag.fishBread.get(0).getFishBreadType() + "붕어빵이 " +
                    fishBreadBag.fishBread.get(0).getFishBreadCount() + "개, " +
                    fishBreadBag.fishBread.get(1).getFishBreadType() + "붕어빵이 " +
                    fishBreadBag.fishBread.get(1).getFishBreadCount() + "개 있네. \n");
        } else if (fishBreadBag.fishBread.size() == 3) {
            System.out.print("보자 보자.. " +
                            fishBreadBag.fishBread.get(0).getFishBreadType() + "붕어빵이 " +
                            fishBreadBag.fishBread.get(0).getFishBreadCount() + "개, " +
                            fishBreadBag.fishBread.get(1).getFishBreadType() + "붕어빵이 " +
                            fishBreadBag.fishBread.get(1).getFishBreadCount() + "개, " +
                            fishBreadBag.fishBread.get(2).getFishBreadType() + "붕어빵이 " +
                            fishBreadBag.fishBread.get(2).getFishBreadCount() + "개 있네. \n");
        }
    }

    public void setAmount(int amount, Scanner sc) {
        while (amount < 2000) {
            System.out.println("아! 맞다. 2천원 부터였지.");
            amount = sc.nextInt();
        }

        this.amount = amount;
    }

    public void orderCheck(Order order, Scanner sc) {
        // 1 ~ 4번 메뉴가 아니면 다시 선택 할 수 있게 무한 루프
        while (!(0 < order.getMenuChoice() && order.getMenuChoice() < 5)
                || order.getPrice() > this.amount) {

            System.out.println("한도 초과 입니다. 다시 주문 해주세요.");

            if (!(0 < order.getMenuChoice() && order.getMenuChoice() < 5)) {
                System.out.println("없는 메뉴 입니다. 다시 입력해주세요.");
                order.setMenuChoice(sc.nextInt());
            }

            // 1 ~ 4번 메뉴를 선택 했을 때
            if (0 < order.getMenuChoice() && order.getMenuChoice() < 5) {
                order.setFishBreadCount(0); // 다시 선택 할 때 값 초기화
                order.setPrice(0);

                // 다시 붕어빵 개수 입력
                while (order.getFishBreadCount() == 0) {
                    order.setFishBreadCount(sc.nextInt());
                    order.setPrice(order.getFishBreadCount());

                    if (order.getFishBreadCount() == 0) {
                        System.out.println("0개는 판매하지 않습니다. 다시 주문 해주세요.");
                    }

                    if (order.getPrice() > this.amount) {
                        System.out.println("한도 초과 입니다. 다시 주문 해주세요.");
                        order.setFishBreadCount(0);
                        order.setPrice(0);
                    }
                }
            }
        }
    }

    public Order order(Order order, Scanner sc) {
        orderCheck(order, sc);
        System.out.print(order.getMenuChoice() + "번 메뉴를 선택했습니다." + "\n" +
                        order.getFishBreadCount() + "개를 주문했습니다." + "\n");
        return order;
    }

    public void receiveFishBread(DBUtil jdbcstudydb, FishBreadBag fishBreadBag) {
        saveDatabase(jdbcstudydb, getAmount(), fishBreadBag);
        this.fishBreadBag = fishBreadBag;
    }

    public int payInCash(int amount) {
        return amount;
    }

    public void receiveChange(int amount) {
        this.amount = amount;
    }

    public void saveDatabase(DBUtil jdbcstudydb, int amount, FishBreadBag fishBreadBag) {
        try {
            Connection connection = jdbcstudydb.getConnection();
            // 자동 커밋을 비활성화하여 트랜잭션을 시작합니다.
            connection.setAutoCommit(false);

            // 모든 붕어빵 주문을 하나의 customernumber에 묶기 위해 동일한 customernumber 사용
            int numberTicket = getNewNumberTicket(jdbcstudydb);

            String sqlQuery = "INSERT INTO jdbcstudydb.customer (amount, fishbreadtype, fishbreadcount, numberticket) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            for (FishBread fishBread : fishBreadBag.getFishBread()) {
                preparedStatement.setInt(1, amount);
                preparedStatement.setString(2, fishBread.getFishBreadType().toString());
                preparedStatement.setInt(3, fishBread.getFishBreadCount());
                preparedStatement.setInt(4, numberTicket);
                preparedStatement.addBatch();
            }

            // 배치 실행
            preparedStatement.executeBatch();

            // 커밋
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getNewNumberTicket(DBUtil jdbcstudydb) {
        int numberticket = 0;
        try {
            String sqlQuery = "SELECT MAX(numberticket) FROM jdbcstudydb.customer";
            PreparedStatement preparedStatement = jdbcstudydb.getConnection().prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                numberticket = resultSet.getInt(1) + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberticket;
    }
}
