/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javanetworking.basics;
import io.fusionauth.http.server.HTTPListenerConfiguration;
import io.fusionauth.http.server.HTTPServer;
/**
 *
 * @author Erick
 */
public class newserver {
    public static void main(String[] args) throws Exception{
   HTTPServer serv = new HTTPServer().withListener(new HTTPListenerConfiguration(5000)).withHandler((req, resp) ->{
       resp.getOutputStream().write("Hello world".getBytes());
   }).start();
   
  
  }
    }

