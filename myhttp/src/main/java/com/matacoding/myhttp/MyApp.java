package com.matacoding.myhttp;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyApp {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // app이 만들어진거  프로토콜이 있는 http 뭐라궁?

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String download = "";

            while (true) {
                String line = br.readLine();

                if (line == null) break;

                download = download + line;
            }

            // System.out.println(download);


            ObjectMapper om = new ObjectMapper();
            Todo todo = om.readValue(download, Todo.class);

            System.out.println(todo.getTitle());
            // 빈생성자가 필요
            // 세터로 데이터를 넣어줌


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}