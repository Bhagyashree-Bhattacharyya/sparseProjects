package serverDemo;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class webserver {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("127.0.0.1", 8080), 0);
        httpServer.setExecutor(Executors.newFixedThreadPool(4));
        httpServer.createContext("/demo", new MyHandler1());
        httpServer.createContext("/home", new MyHandler2());
        httpServer.start();
        System.out.println("Server is listening on port 8080...");
//        System.out.println("Current working directory: " + new java.io.File(".").getCanonicalPath());
    }
}
