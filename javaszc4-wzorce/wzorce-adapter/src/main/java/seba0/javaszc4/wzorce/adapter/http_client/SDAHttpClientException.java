package seba0.javaszc4.wzorce.adapter.http_client;

import java.io.IOException;

public class SDAHttpClientException extends IOException {

    public SDAHttpClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public SDAHttpClientException(Throwable cause) {
        super(cause);
    }

    public SDAHttpClientException(String message) {
        super(message);
    }
}
