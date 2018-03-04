package br.com.ifpb.sd.main;

import br.com.ifpb.sd.infra.UDP;
import java.nio.ByteBuffer;
import java.util.Random;

/**
 *
 * @author rodrigobento
 */
public class Loader {

    private static UDP udp = new UDP();

    public static void main(String[] args) {
        // Enviando valores
        Random random = new Random();
        while (true) {
            // Gera os dois valores e envia por meio de Socket
            int n1 = random.nextInt(100);
            int n2 = random.nextInt(100);
            udp.send(n1, n2);

            // Recebendo resposta e adicionando a um int 
            ByteBuffer bff = ByteBuffer.wrap(udp.receive());
            int status = bff.getInt();
            // Verifica se o status é diferente de 0, caso seja igual é gerado novos valores
            System.out.println("Resposta: " + status);
            if (status != 0) {
                System.out.println("Numeros diferentes enviados");
                break;
            }
        }
    }

}
