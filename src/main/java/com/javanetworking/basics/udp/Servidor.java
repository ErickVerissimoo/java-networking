package com.javanetworking.basics.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {

    public static void main(String[] args) {
        final int porta = 5050;

        try (DatagramSocket sock = new DatagramSocket(porta)) {
            System.out.println("Servidor UDP escutando na porta " + porta + "...");
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
                
                sock.receive(pacote);
                
                String resposta = new String(pacote.getData(), 0, pacote.getLength());
                System.out.println("A mensagem recebida é: " + resposta);
                
                byte[] saida = "hello world".getBytes();
                
                DatagramPacket response = new DatagramPacket(saida, saida.length, pacote.getAddress(), pacote.getPort());
                sock.send(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}