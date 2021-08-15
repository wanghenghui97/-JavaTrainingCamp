package nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer02 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8802);
            while(true){
                Socket accept = serverSocket.accept();
                new Thread(()->{
                    service(accept);
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void service(Socket socket) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body="hello,nio2";
            printWriter.println("Content-Length:"+body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
