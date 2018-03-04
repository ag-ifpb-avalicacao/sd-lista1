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
            this.socket = new DatagramSocket();
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }

    public void send(int n1, int n2) {
        try {
            ByteBuffer buf = ByteBuffer.allocate(8);
            buf.putInt(n1);
            buf.putInt(n2);
            DatagramPacket pack = new DatagramPacket(buf.array(), buf.array().length,
                    InetAddress.getByName("host-node2"), 1234);
            System.out.println("Numeros enviados: " + n1 + " " + n2);
            socket.send(pack);
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public byte[] receive() {
        try {
            byte[] resposta = new byte[10];
            DatagramPacket packResposta = new DatagramPacket(resposta, resposta.length);
            socket.receive(packResposta);
            return packResposta.getData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
