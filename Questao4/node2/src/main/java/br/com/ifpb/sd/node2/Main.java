package br.com.ifpb.sd.node2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author rodrigobento
 */
public class Main {

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.bind("rmi:/no2", new SharedImpl());
            System.out.println("Em execução");
        } catch (RemoteException | AlreadyBoundException ex) {
            ex.printStackTrace();
        } 
    }

}
