package com.jeffery.warehouse;

import java.sql.*;

/**
 * @time 2020/4/16 - 15:08
 * @Version 1.0
 * @Author Jeffery Yi
 */
public class KylinTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.kylin.jdbc.Driver");

        String sql="select PROVINCE_NAME,sum(FINAL_TOTAL_AMOUNT) sum_TOTAL_AMOUNT\n" +
                "from  DWD_FACT_ORDER_INFO  join    DWD_DIM_BASE_PROVINCE\n" +
                "on DWD_FACT_ORDER_INFO.PROVINCE_ID =DWD_DIM_BASE_PROVINCE.ID \n" +
                "group by DWD_DIM_BASE_PROVINCE.PROVINCE_NAME";

        Connection connection = DriverManager.getConnection("jdbc:kylin://hadoop103:7070/gmall", "ADMIN", "KYLIN");
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        System.out.println("PROVINCE_NAME" + "\t" + "sum_TOTAL_AMOUNT");
        while (resultSet.next()){
            System.out.println(resultSet.getString("PROVINCE_NAME") + "\t" + resultSet.getString("sum_TOTAL_AMOUNT"));
        }
    }
}
