package br.com.ifpb.sd.node1;

import br.com.ifpb.sd.shared.Shared;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author rodrigobento
 */
public class Main {

    public static void main(String[] args) {
        try {
            Shared sh = (Shared) LocateRegistry.
                    getRegistry("no2", 1099).
                    lookup("rmi:/no2");
            sh.insert("Rodrigo");
            System.out.println("Inserido...");
        } catch (RemoteException | NotBoundException ex) {
            ex.printStackTrace();
        } 
    }
    
}
