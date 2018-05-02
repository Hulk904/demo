package com.demo.base.connection_pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangyuan on 4/26/18.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ConnectionPool pool = new ConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.104.83:3358/id_hotel?characterEncoding=utf-8&amp;allowMultiQueries=true", "id_hotel", "id_hotel", 4);
        for (int t = 0; t < 20; t++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Connection connection = pool.getConnection();
                        PreparedStatement statement = connection.prepareStatement("select * from hotel_base_info where id = 2274215");
                        ResultSet set = statement.executeQuery();
                        ResultSetMetaData rm = set.getMetaData();
//                        for (int i = 1;
//                                i <= rm.getColumnCount(); i++)
//                        {
//                            System.out.print(rm.getColumnName(i));
//                            System.out.println("\t\t");
//                        }
//                        System.out.println();
//                        while (set.next())
//                        {
//                            for (int i = 1; i <= rm.getColumnCount(); i++) {
//                                System.out.print(set.getString(i));
//                                System.out.println("\t\t");
//                            }
//                        }
                        //TimeUnit.SECONDS.sleep(1);
                        connection.close();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }
                }
            }.start();
        }
    }
}
