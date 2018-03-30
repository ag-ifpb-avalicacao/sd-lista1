package br.com.ifpb.sd.node3;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import java.io.IOException;
import java.net.SocketException;
import org.json.JSONObject;
import request.reply.Client;
import request.reply.Marshaller;
import request.reply.Message;
import request.reply.RemoteRef;
import request.reply.Server;

/**
 *
 * @author rodrigobento
 */
public class Main {

    // 2001
    public static void main(String[] args) throws SocketException,
            Base64DecodingException, IOException, ClassNotFoundException {
        Server server = new Server(2013);
        System.out.println("Servidor do node3 ativado");
        while (true) {
            byte[] request = server.getRequest();
            System.out.println("Requisição recebida");
            byte[] process = process(request);
            server.sendReply(process);
            System.out.println("Resposta enviada");
        }
    }

    private static byte[] process(byte[] request) throws Base64DecodingException {
        JSONObject object = new JSONObject(new String(request));
        Message m = Marshaller.unMarshal(object);
        byte[] response;
        Client client = new Client();
        if (m.getOperationId() == 1) {
            response = client.doOperation(new RemoteRef("localhost", 2012), m, 2002);
        } else {
            response = client.doOperation(new RemoteRef("localhost", 2014), m, 2002);
        }
        return response;
    }

}
