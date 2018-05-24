package com.demo.base.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by yangyuan on 5/24/18.
 */
public class HalfCloseSocket {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 8189)){
            Scanner in = new Scanner(socket.getInputStream(), "utf-8");
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("i am yangyuan");
            writer.flush();
            socket.shutdownOutput();
            while (in.hasNextLine()){
                System.out.println(in.nextLine());
            }
        }catch (IOException exc){

        }
    }
}
