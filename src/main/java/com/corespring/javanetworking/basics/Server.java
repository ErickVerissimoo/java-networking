/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.corespring.javanetworking.basics;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Erick
 */
public class Server {
    private ServerSocket serv;
    public ServerSocket getSock(){
        return serv;
    }
    public Server(){
        try{
        serv = new ServerSocket(3000, 0, Inet4Address.getLocalHost());
        
        }catch(Exception ex){
            ex.printStackTrace();
            
        }}
        public  void conectar(SocketAddress endpoint) throws IOException{
          
            System.out.print(serv.accept().isConnected());
        }
        
        }

