package com.matacoding.myhttp;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyApp2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
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
            Posts posts = om.readValue(download, Posts.class);

            System.out.println("========================");
            System.out.println("check: " + posts.getTitle());


            // 빈생성자가 필요
            // 세터로 데이터를 넣어줌


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}