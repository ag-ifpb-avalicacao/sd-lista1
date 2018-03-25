package br.com.ifpb.sd.node3;

import br.com.ifpb.sd.shared.ObjectShared;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author rodrigobento
 */
public class ObjectImpl extends UnicastRemoteObject implements ObjectShared {

    private static final long serialVersionUID = 1L;
    
    public ObjectImpl() throws RemoteException{
        super();
    }

    // Deve possuir conhecimento dos outros 2 nodes
    @Override
    public int operation1(int n1, int n2) throws RemoteException {
        System.out.println("Requisição recebida, node3...");
        // Node 1
        try {     
            // Busca o objeto atraves de um registro (a partir de uma porta e um nome identificador)
            Registry reg = LocateRegistry.getRegistry(1090);
            ObjectShared comp = (ObjectShared) reg.lookup("rmi:node1");
            return comp.operation1(n1, n2);
        } catch (NotBoundException | AccessException ex) {
            System.out.println("Nao conseguiu requisitar a ação ao node1");
        }
        // Node 2
        try {
            Registry reg = LocateRegistry.getRegistry(1091);
            ObjectShared comp = (ObjectShared) reg.lookup("rmi:node2");
            return comp.operation1(n1, n2);
        } catch (NotBoundException | AccessException ex) {
            System.out.println("Nao conseguiu requisitar a ação ao node2");
        }
        throw new RemoteException();
    }

    @Override
    public int operation2(int n1, int n2) throws RemoteException {
        System.out.println("Requisição recebida, node3...");
        return (2 * n1) / n2;
    }
    
}
