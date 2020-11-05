package geekbrains.hw10;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            System.out.println("Клиент запущен и подключен.\nДля прекращения работы введите пустую строку. Введите сообщение:\n");

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            try (Scanner scanner = new Scanner(System.in)){
                while (true) {
                    String str = scanner.nextLine();
                    outputStream.writeUTF(str);
                    if (str.isEmpty()) break;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Клиент завершил работу");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
