package br.com.ifpb.sd.node1;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import java.nio.ByteBuffer;
import org.json.JSONObject;
import request.reply.Client;
import request.reply.Marshaller;
import request.reply.Message;
import request.reply.RemoteRef;

/**
 *
 * @author rodrigobento
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            Client client = new Client();
            // Construindo a mensagem
            ByteBuffer buffer = ByteBuffer.allocate(8);
            buffer.putInt(4);
            buffer.putInt(2);
            Message msg = new Message(0, 2, 2, buffer.array());
            // Verificando qual operação deve ser realizada, enviando assim para um node correspondente
            byte[] response;
            if (msg.getOperationId() == 1) {
                response = client.doOperation(new RemoteRef("localhost", 2012), 
                        msg, 2000);
            } else {
                response = client.doOperation(new RemoteRef("localhost", 2013), 
                        msg, 2000);
            }
            Message resp = Marshaller.unMarshal(new JSONObject(new String(response)));
            ByteBuffer bytResp = ByteBuffer.wrap(resp.getArguments());
            System.out.println("Sua resposta: " + bytResp.getInt());
        } catch (Base64DecodingException ex) {
            ex.printStackTrace();
        }
    }

}
