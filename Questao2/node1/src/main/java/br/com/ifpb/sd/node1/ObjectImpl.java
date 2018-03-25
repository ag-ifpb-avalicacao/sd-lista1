package br.com.ifpb.sd.node1;

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

    @Override
    public int operation1(int n1, int n2) throws RemoteException {
        System.out.println("Requisição recebida, node1...");
        return 2 * n2 * n1;
    }

    @Override
    public int operation2(int n1, int n2) throws RemoteException {
        System.out.println("Requisição recebida, node1...");
        try {
            Registry reg = LocateRegistry.getRegistry(1092);
            ObjectShared shared = (ObjectShared) reg.lookup("rmi:node3");
            return shared.operation2(n1, n2);
        } catch (NotBoundException | AccessException ex) {
            ex.printStackTrace();
        } 
        // Lança a exceção
        throw new RemoteException();
    }
    
}
