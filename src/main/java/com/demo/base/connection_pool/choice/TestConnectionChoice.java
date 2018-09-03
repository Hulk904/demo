package com.demo.base.connection_pool.choice;

import java.sql.*;

/**
 * Created by yangyuan on 8/2/18.
 */
public class TestConnectionChoice {

    public static void main(String[] args) throws SQLException {
        Connection coon = DriverManager.getConnection("jdbc:mysql://192.168.104.83:3358/cn_appoint?characterEncoding=utf-8",
                "cn_appoint",
                "cn_appoint");

        PreparedStatement statement = coon.prepareStatement("select * from appoint_product limit 0,3");
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString(3));
        }
    }
}
