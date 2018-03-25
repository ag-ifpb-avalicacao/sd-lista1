package br.com.ifpb.sd.client;

import br.com.ifpb.sd.shared.ObjectShared;
import java.rmi.NotBoundException;
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
            Registry reg = LocateRegistry.getRegistry(1090);
            ObjectShared shared = (ObjectShared) reg.lookup("rmi:node1");
            int operation1 = shared.operation1(10, 20);
            int operation2 = shared.operation2(10, 20);
            System.out.println("Resultado da operação 1: " + operation1);
            System.out.println("Resultado da operação 2: " + operation2);
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("Erro na busca do registro");
        } 
    }
    
}
