package br.com.ifpb.sd.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author rodrigobento
 */
public interface Shared extends Remote {
    
    public void insert(String name) throws RemoteException;
    
}
