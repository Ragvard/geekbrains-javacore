package geekbrains.hw10;

import okhttp3.*;

import java.io.IOException;

public class okHTTP {

    public static void main(String[] args) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://ya.ru")
                    .build();

            Response response = client.newCall(request).execute();

            System.out.println("Возвращенный код: " + response.code());
            System.out.println("Использованный протокол: " + response.protocol());
            System.out.println("Возвращенное тело: " + response.body().string()); // Возвращает, вроде бы, html страницу
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
