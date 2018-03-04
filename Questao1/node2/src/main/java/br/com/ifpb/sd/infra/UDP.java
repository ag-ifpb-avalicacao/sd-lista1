package br.com.ifpb.sd.infra;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 *
 * @author rodrigobento
 */
public class UDP {

    private DatagramSocket socket;

    public UDP() {
        try {
            this.socket = new DatagramSocket(1234);
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }

    public void send(InetAddress address, int port, ByteBuffer valor) {
        try {
            DatagramPacket packResponse = new DatagramPacket(valor.array(),
                    valor.array().length, address, port); 
            socket.send(packResponse);
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public DatagramPacket receive() {
        try {
            byte[] resposta = new byte[8];
            DatagramPacket packResposta = new DatagramPacket(resposta, resposta.length);
            socket.receive(packResposta);
            return packResposta;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
