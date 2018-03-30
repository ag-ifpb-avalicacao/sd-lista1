package br.com.ifpb.sd.node3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author rodrigobento
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        File arquivo = new File("../db.txt");
        FileOutputStream outp = new FileOutputStream(arquivo);
        outp.write("Teste".getBytes());
        outp.close();
    }
    
}
