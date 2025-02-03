package com._2p1team.cmadmin.app.model.http;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@AllArgsConstructor(access = AccessLevel.NONE)
public final class HttpCommunicator {

    private static final String URI_HEAD = "http://localhost:8080";
    private static HttpRequest request;
    private static HttpClient client = HttpClient.newHttpClient();
    private static HttpResponse<String> response;

    public static String sendGetRequest(final String url) {
        try {
            request = HttpRequest.newBuilder()
                .uri(new URI(URI_HEAD+url))
                .GET()
                .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (Exception exception) {
            exception.printStackTrace(); // TODO: Create UI error handling
        }

        return response.body();
    }


}