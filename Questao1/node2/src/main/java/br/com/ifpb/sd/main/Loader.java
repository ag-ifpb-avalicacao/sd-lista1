package br.com.ifpb.sd.main;

import br.com.ifpb.sd.infra.UDP;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 *
 * @author rodrigobento
 */
public class Loader {

    private static UDP udp = new UDP();

    public static void main(String[] args) {
        System.out.println("Aguardando node1");
        while (true) {
            DatagramPacket packRequest = udp.receive();
            ByteBuffer buf = ByteBuffer.wrap(packRequest.getData());
            int n1 = buf.getInt();
            int n2 = buf.getInt();
            System.out.println("Recebidos: " + n1 + " " + n2);

            InetAddress address = packRequest.getAddress();
            int port = packRequest.getPort();

            ByteBuffer buffer;
            if (n1 == n2) {
                buffer = ByteBuffer.allocate(4);
                buffer.putInt(0);
                udp.send(address, port, buffer);
                System.out.println("Enviado para o node 1");
            } else {
                buffer = ByteBuffer.allocate(4);
                buffer.putInt(1);
                udp.send(address, port, buffer);
                System.out.println("Enviado para o node 1");
                buffer = ByteBuffer.allocate(8);
                buffer.putInt(n1);
                buffer.putInt(n2);
                try {
                    udp.send(InetAddress.getByName("host-node3"), 1235, buffer);
                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Enviado para o node 3");
                break;
            }
        }
    }

}
