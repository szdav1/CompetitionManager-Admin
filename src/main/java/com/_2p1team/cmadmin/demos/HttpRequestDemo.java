package com._2p1team.cmadmin.demos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestDemo {

    public static void getAll() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/api/competitor/"))
                .GET()
                .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getById(final long id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(String.format("http://localhost:8080/api/competitor/%d", id)))
                .GET()
                .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}