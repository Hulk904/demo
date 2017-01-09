package com.demo.base.thread.easy;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yangyuan on 17-1-7.
 */
public class SimpleHttpServer {
    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<HttpRequestHandler>();
    static String basePath = "/home/yangyuan/IdeaProjects/demo/src/main/java/com/demo/base/thread/easy";
    static ServerSocket serverSocket;
    static int port = 8080;
    public static void setPort(int port){
        if(port > 0) {
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath){
        if(basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()){
            SimpleHttpServer.basePath = basePath;
        }
    }

    public static void start() throws  Exception{
        serverSocket = new ServerSocket(port);
        Socket socket =null;
         while((socket = serverSocket.accept()) != null){
             threadPool.execute(new HttpRequestHandler(socket));
         }
        serverSocket.close();
    }
    static class HttpRequestHandler implements Runnable{
        private Socket socket;
        public HttpRequestHandler(Socket socket){
            this.socket = socket;
        }

        public void run(){
            String line = null;
            BufferedReader br = null;
            BufferedReader reader  = null;
            PrintWriter out = null;
            InputStream in = null;
            try{
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                String filePath = basePath + header.split(" ")[1];
                if(filePath.endsWith("jpg") || filePath.endsWith("ico")){
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    byte[] array = new byte[in.available()];
                    in.read(array);
                    out = new PrintWriter(socket.getOutputStream(),true);//测试时 没设置autoflush 图片刷不出来.. 或者用PrintStream
                    //PrintStream  out1 = new PrintStream(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: " + array.length);
                    out.println("");
                    socket.getOutputStream().write(array,0,array.length);
                    //out.write(array);
                    out.flush();
                }else{
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset=utf-8");
                    out.println("");
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();
            }catch (Exception exc){
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
                System.out.println(exc);
            }finally {
                close(br,in,reader,out,socket);
            }
        }

    }
    private static  void close (Closeable... closeables){
        if(closeables != null){
            for(Closeable closeable:closeables){
                try {
                    if(closeable != null) {
                        closeable.close();
                    }
                }catch (Exception exc){
                    System.out.println(exc);
                }
            }
        }
    }

}
