package br.com.ifpb.sd.node3;

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
            Registry reg = LocateRegistry.createRegistry(1092);
            reg.bind("rmi:/no3", new ObjectImpl());
            System.out.println("Node3 em execução...");
        } catch (RemoteException | AlreadyBoundException ex) {
            System.out.println("Erro na criação do node 3");
        }
    }

}
