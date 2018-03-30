package br.com.ifpb.sd.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;

/**
 *
 * @author rodrigobento
 */
public interface Notify extends Remote {
    
    void updateFile(Calendar calendar) throws RemoteException;    
    
}
