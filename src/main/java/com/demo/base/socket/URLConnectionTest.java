package com.demo.base.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by yangyuan on 5/24/18.
 */
public class URLConnectionTest {
    public static void main(String[] args)throws MalformedURLException, IOException{
        URL url = new URL("http://www.baidu.com/");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        PrintWriter out = new PrintWriter(connection.getOutputStream());
        out.print("wd=name");
        out.close();
        Scanner scanner = new Scanner(connection.getInputStream());
        if(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
}
