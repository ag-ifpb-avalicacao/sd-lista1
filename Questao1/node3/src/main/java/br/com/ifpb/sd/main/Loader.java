package br.com.ifpb.sd.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;

/**
 *
 * @author rodrigobento
 */
public class Loader {
    
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(1235);
            byte[] request = new byte[100];
            DatagramPacket packRequest = new DatagramPacket(request, request.length);
            System.out.println("Aguardando node2");
            socket.receive(packRequest);
            ByteBuffer bufferRequest = ByteBuffer.wrap(packRequest.getData());
            int n1 = bufferRequest.getInt();
            int n2 = bufferRequest.getInt();
            System.out.println("Recebidos: " + n1 + " " + n2);
            double fx = (Math.pow(n1, n1)) * (Math.pow(n2, n2));
            System.out.println("Valor final arredondado: " + Math.round(fx));
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
