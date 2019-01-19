package seba0.javaszc4.wzorce.adapter.http_client;

public interface SDAHttpClient {

    SDAHttpClientResponse sendRequest(String url) throws SDAHttpClientException;
}
