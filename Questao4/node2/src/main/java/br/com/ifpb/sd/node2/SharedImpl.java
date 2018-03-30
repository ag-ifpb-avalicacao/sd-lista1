package br.com.ifpb.sd.node2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import br.com.ifpb.sd.shared.Shared;

/**
 *
 * @author rodrigobento
 */
public class SharedImpl extends UnicastRemoteObject implements Shared {

    private static final long serialVersionUID = 1L;
    private Dao dao1;
    private Dao dao2;

    public SharedImpl() throws RemoteException{
        super();
        this.dao1 = new DaoPG1();
        this.dao2 = new DaoPG2();
    }
    
    @Override
    public void insert(String name) throws RemoteException {
        dao1.insert(name);
        dao2.insert(name);
    }

}
