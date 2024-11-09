package com.javanetworking.basics;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
/**
 *
 * @author Erick
 */
public class Servidor2 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        HttpServer servidor  = HttpServer.create(new InetSocketAddress("localhost", 2100), 0);
        servidor.createContext("/Oi", (c) -> {
            String mensage = "Oi mundo";
            c.sendResponseHeaders(200, mensage.length());
            try(PrintWriter writer = new PrintWriter(c.getResponseBody(), Boolean.TRUE)){
                          writer.write(mensage);  
            }

        });
        servidor.start();
    }
}
