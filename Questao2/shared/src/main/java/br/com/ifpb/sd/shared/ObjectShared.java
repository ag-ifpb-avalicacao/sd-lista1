package br.com.ifpb.sd.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author rodrigobento
 */
public interface ObjectShared extends Remote {
    
    public int operation1(int n1, int n2) throws RemoteException;
    public int operation2(int n1, int n2) throws RemoteException;    
    
}
