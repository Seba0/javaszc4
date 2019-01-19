package seba0.javaszc4.wzorce.adapter.http_client;

import com.google.gson.Gson;

import java.io.IOException;

public class HttpRestClient {

    private static final SDAHttpClient HTTP_CLIENT = new SDAHttpClientImpl();


    public static void main(String[] args) throws IOException {

        SDAHttpClientResponse response = HTTP_CLIENT.sendRequest("https://swapi.co/api/people/1/?format=json");

        Gson gson = new Gson();

        People people = gson.fromJson(response.getBody(), People.class);

        System.out.println("Deserialize: ");
        System.out.println(people);

    }

}
