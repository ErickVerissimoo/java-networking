/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javanetworking.basics;
import io.fusionauth.http.server.HTTPHandler;
import io.fusionauth.http.server.HTTPListenerConfiguration;
import io.fusionauth.http.server.HTTPServer;
import io.fusionauth.http.server.HTTPServerConfiguration;
import java.net.InetAddress;
/**
 *
 * @author Erick
 */
public class newserver {
    public static void main(String[] args) throws Exception{
   HTTPServer serv = new HTTPServer().withListener(new HTTPListenerConfiguration(InetAddress.getByName("127.0.0.1"), 3000)).withHandler((req, resp) -> {
       resp.setContentType("text/html; charset=utf-8");
       resp.getOutputStream().write("Olá mundo".getBytes());
       
   }).start();
   
  
  }
    }

