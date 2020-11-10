package geekbrains.hw10;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Сервер запущен");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");

            try (DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {
                while (true) {
                    String str = inputStream.readUTF();
                    if (str.isEmpty()) break;
                    System.out.println("Клиент: " + str);
                }
            }

            System.out.println("Сервер выключен");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}