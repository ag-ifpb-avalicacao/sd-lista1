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

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry reg = LocateRegistry.createRegistry(1090);
        reg.bind("node1", new NotifyImpl());
        System.out.println("Aguardando alertas de modificação...");
    }

}
