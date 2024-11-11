package com.javanetworking.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import java.util.function.Supplier;

public class Servidor {

    public static void main(String[] args) {
        final int porta = 8020;

        try (ServerSocket serverSocket = new ServerSocket(porta, 0, InetAddress.getByName("0.0.0.0"))) {
            System.out.println("\n\tServidor iniciado na porta " + porta);

            while (true) {
                try (Socket clienteSocket = serverSocket.accept()) {
                    Router rout = Router.getInstance();
                    String html = "<html><body><h1>Olá, mundo!</h1></body></html>";
                    int contentLength = html.getBytes(StandardCharsets.UTF_8).length;
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream(), StandardCharsets.UTF_8));
                    String caminho = buffer.readLine().split(" ")[1];
                    

                    System.out.println("\n\tCaminho: " + caminho);
                    String response = String.format(
                            "HTTP/1.1 200 OK\r\n"
                            + "Content-Type: text/html; charset=UTF-8\r\n"
                            + "Content-Length: %d\r\n"
                            + "Connection: close\r\n\r\n"
                            + "%s",
                            contentLength, html
                    );
                    
                    rout.addRoute( "/", () -> response);
                    rout.addRoute( "/ola", () -> response);
                    rout.executeRoute(caminho, clienteSocket.getOutputStream());
                  

                } catch (IOException e) {
                    System.err.println("\n\tErro ao aceitar conexão: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("\n\tErro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
