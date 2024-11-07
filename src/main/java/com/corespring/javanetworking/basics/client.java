/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corespring.javanetworking.basics;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Erick
 */
public class client {
    private Socket soquete;
    
    public client(Socket sock) throws IOException{
        soquete = sock;
        System.out.print(soquete.isConnected());
        
    }
    public Socket getSoquete(){
        return soquete;
    }
}
