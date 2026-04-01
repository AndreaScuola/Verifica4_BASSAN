package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class testServlet {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            String nomeDB = "db_servletLibri";
            String user = "userVerifica";
            String password = "password1";

            String url = "http://localhost:8080/servletLibri/servletLibri?nomeDB=" + nomeDB + "&user=" + user + "&password=" + password;
            System.out.println("URL servlet chiamata: " + url);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Stampa status code e body della risposta
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
