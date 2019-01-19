package seba0.javaszc4.wzorce.adapter.http_client;

public class SDAHttpClientResponse {

    private final int status;
    private final String body;

    public SDAHttpClientResponse(int status, String body) {
        this.status = status;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }
}
