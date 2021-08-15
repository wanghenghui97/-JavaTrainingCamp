package nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer01 {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8802);
        while(true){
            Socket accept = socket.accept();
            service(accept);
        }

    }

    public static void service(Socket socket){
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.println("HTTP/1.1 200 OK");
        printWriter.println("Content-Type:text/html;charset=utf-8");
        String body="hello,nio1";
        printWriter.println("Content-Length:"+body.getBytes().length);
        printWriter.println();
        printWriter.write(body);
        printWriter.close();



    }
}
