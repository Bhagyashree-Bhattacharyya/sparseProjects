package serverDemo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MyHandler1 implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "I'm in custom handler serving with "+ Thread.currentThread().getName();
        exchange.sendResponseHeaders(200, response.length());
        OutputStream stream = exchange.getResponseBody();
        stream.write(response.getBytes(StandardCharsets.UTF_8));
        stream.flush();
        stream.close();
    }
}
