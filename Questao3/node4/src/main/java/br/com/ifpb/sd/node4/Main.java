package br.com.ifpb.sd.node4;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import java.io.IOException;
import java.net.SocketException;
import java.nio.ByteBuffer;
import org.json.JSONObject;
import request.reply.Marshaller;
import request.reply.Message;
import request.reply.Server;

/**
 *
 * @author rodrigobento
 */
public class Main {

    // 2002
    public static void main(String[] args) throws SocketException,
            IOException, Base64DecodingException, ClassNotFoundException {
        Server server = new Server(2014);
        System.out.println("Servidor do node4 ativado");
        while (true) {
            byte[] request = server.getRequest();
            System.out.println("Requisição recebida");
            byte[] response = process(request);
            server.sendReply(response);
            System.out.println("Resposta enviada");
        }
    }

    private static byte[] process(byte[] request) throws Base64DecodingException {
        JSONObject object = new JSONObject(new String(request));
        Message msg = Marshaller.unMarshal(object);
        ByteBuffer buf = ByteBuffer.wrap(msg.getArguments());
        int n1 = buf.getInt();
        int n2 = buf.getInt();
        ByteBuffer resp = ByteBuffer.allocate(4);
        if (msg.getOperationId() == 1) {
            int result = n1 + n2;
            resp.putInt(result);
            msg.setArguments(resp.array());
            return Marshaller.marshal(msg).toString().getBytes();
        } else {
            int result = n1 - n2;
            resp.putInt(result);
            msg.setArguments(resp.array());
            return Marshaller.marshal(msg).toString().getBytes();
        }
    }

}
