package br.com.ifpb.sd.node1;

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
            Registry reg = LocateRegistry.createRegistry(1090);
            reg.bind("rmi:node1", new ObjectImpl());
            System.out.println("Node1 em execuçao...");
        } catch (RemoteException | AlreadyBoundException ex) {
            System.out.println("Erro na criação do node 1");
        }
    }

}
