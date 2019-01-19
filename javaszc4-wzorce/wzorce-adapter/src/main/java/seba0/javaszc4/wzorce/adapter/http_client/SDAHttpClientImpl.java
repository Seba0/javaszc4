package seba0.javaszc4.wzorce.adapter.http_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SDAHttpClientImpl implements SDAHttpClient {
    @Override
    public SDAHttpClientResponse sendRequest(String url) throws SDAHttpClientException {
        try {
            URL _url = new URL(url);
            HttpURLConnection con = (HttpURLConnection) _url.openConnection();
            con.setRequestMethod("GET");
            con.addRequestProperty("User-Agent", "Mozilla/5.0");

            int status = con.getResponseCode();
            System.out.println(status);

            String response = readResponse(con);

            return new SDAHttpClientResponse(status, response);
        } catch (Exception e) {
            throw new SDAHttpClientException("Send request to URL: " + url, e);
        }
    }

    private static String readResponse(HttpURLConnection con) throws IOException {
        StringBuffer content = new StringBuffer();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader((InputStream) con.getContent()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        }
        System.out.println(content);
        return content.toString();
    }
}
