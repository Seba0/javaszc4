package seba0.javaszc4.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Listing for connection on " + port + " .....");
            while (!serverSocket.isClosed()) {
                try (Socket socket = serverSocket.accept()) {
                    InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                    BufferedReader reader = new BufferedReader(isr);
                    String line = reader.readLine();
                    while (!line.isEmpty()) {
                        System.out.println(line);
                        line = reader.readLine();
                    }
                    Date date = new Date();
                    String response = "HTTP/1.1 200 OK\r\nContext-Type: text/html\r\n\r\n" + "<html><body><center>" + date + "</center><a href=\"test\">Test button</a></body></html>";
                    socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
                }
            }
        }
    }
}
