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

public class Servidor {
    public static void main(String[] args) {
        final int porta = 8020;

        try (ServerSocket serverSocket = new ServerSocket(porta, 0, InetAddress.getByName("0.0.0.0"))) {
            System.out.println("Servidor iniciado na porta " + porta);
            
            while (true) {
                try (Socket clienteSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(new OutputStreamWriter(clienteSocket.getOutputStream(), StandardCharsets.UTF_8), true)) {
                   
                    String html = "<html><body><h1>Olá, mundo!</h1></body></html>";
                    int contentLength = html.getBytes(StandardCharsets.UTF_8).length;
                    BufferedReader buffer = new BufferedReader(new InputStreamReader( clienteSocket.getInputStream(), StandardCharsets.UTF_8));
                    String linha;
                    linha = buffer.readLine();
                     
                     String metodo = linha.split(" ")[0];
                   
                  System.out.println("Metodo recebido: " + metodo);
                    out.print("HTTP/1.1 200 OK\r\n");
                    out.print("Content-Type: text/html; charset=UTF-8\r\n");
                    out.print("Content-Length: " + contentLength + "\r\n");
                    out.print("Connection: close\r\n");
                    out.print("\r\n");
                    out.print(html);
                    out.flush();

                } catch (IOException e) {
                    System.err.println("Erro ao aceitar conexão: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
