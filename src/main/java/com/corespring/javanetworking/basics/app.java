/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corespring.javanetworking.basics;

import java.io.IOException;

/**
 *
 * @author Erick
 */
public class app {
    public static void main(String[] args) throws Exception {
        Server servi = new Server();
        client cliente = new client(servi.getSock().accept());
        System.out.println(cliente.getSoquete().isConnected());
    }
 
}
