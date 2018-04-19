package com.lex.showcase.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Socket客户端（相对Socket服务器端要后启动）
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 要连接的服务器IP地址和端口
        String host = "127.0.0.1";
        int port = 12345;

        // 与服务器建立连接
        Socket client = new Socket(host, port);

        // 建立连接后获得输出流
        OutputStream writeOut = client.getOutputStream();
        String message = "Hello, my friend!";
        writeOut.write(message.getBytes("UTF-8"));

        writeOut.close();
        client.close();
    }
}
