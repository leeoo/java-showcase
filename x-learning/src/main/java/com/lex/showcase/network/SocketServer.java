package com.lex.showcase.network;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket服务器端（相对Socket客户端要先启动）
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        // 监听指定的端口
        int port = 12345;
        ServerSocket server = new ServerSocket(port);

        // Server将一直等待连接的到来
        System.out.println("Server running...");
        Socket socket = server.accept();

        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream readIn = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = readIn.read(bytes)) != -1) {
            // 指定编码方式，发送方和接收方一定要统一，建议使用UTF-8！
            // 注意此处一定要从偏移位置0到读取到的长度len取数据构造消息字符串，否则可能由于读取到的内容不够读取块缓冲区数组的长度而乱码！
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("Get message from client: " + sb.toString());

        readIn.close();
        socket.close();
        server.close();
        System.out.println("Server closed.");

    }
}
