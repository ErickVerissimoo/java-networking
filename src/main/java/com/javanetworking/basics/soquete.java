/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javanetworking.basics;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Erick
 */
public class soquete {
    public static void main(String[] args) throws Exception{
  while(true){
        try (
                        ServerSocket server = new ServerSocket(3000, 0, InetAddress.getByName("127.0.0.1"));

                Socket sock = server.accept()){
            System.out.println(sock.isConnected());
        }
        
    }}
}
