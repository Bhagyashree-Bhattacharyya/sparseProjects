package serverDemo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyHandler2 implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String htmlFile = "path/to/file/here";
        // Check if the file exists
//        if (!Files.exists(Paths.get(htmlFile))) {
//            String response = "File not found";
//            exchange.sendResponseHeaders(404, response.length());
//            OutputStream os = exchange.getResponseBody();
//            os.write(response.getBytes(StandardCharsets.UTF_8));
//            os.close();
//            return;
//        }
        byte[] response = Files.readAllBytes(Paths.get(htmlFile));
        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(200, response.length);
        OutputStream stream = exchange.getResponseBody();
        stream.write(response);
        stream.flush();
        stream.close();
    }
}
