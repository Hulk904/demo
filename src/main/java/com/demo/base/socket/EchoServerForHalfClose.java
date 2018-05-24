package com.demo.base.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 这样单线程，如果有多个终端连接，则只会有一个成功。没有资源的tcp状态为established 但是没有进程资源来为他服务
 * Created by yangyuan on 5/24/18.
 *
 */
public class EchoServerForHalfClose {
    public static void main(String[] args) {
        try(ServerSocket s = new ServerSocket(8189)){
            try(Socket socket  = s.accept()){
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                try(Scanner scanner = new Scanner(inputStream, "utf-8")){
                    PrintWriter  pr = new PrintWriter(new OutputStreamWriter(outputStream, "utf-8"),true);
                    pr.println("hello, enter BYE to exit.");
                    while(true){
                        String line = "";
                        if(scanner.hasNextLine()) {
                            line = scanner.nextLine();
                            pr.println("echo : " + line);
                        }else {
                            pr.println("auto send...");
                        }

                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            }
        }catch (IOException | InterruptedException exc){
            System.out.println(exc);
        }
    }
    //socket.shutdownOutput();
    //客户端调用这个api将成为半关闭：不再发送数据，但是可以接受来自服务端的响应。
}
