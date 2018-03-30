package br.com.ifpb.sd.node1;

import br.com.ifpb.sd.shared.Notify;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

/**
 *
 * @author rodrigobento
 */
public class NotifyImpl extends UnicastRemoteObject implements Notify{

    public NotifyImpl() throws RemoteException{
        super();
    }
    
    @Override
    public void updateFile(Calendar calendar) throws RemoteException {
        System.out.println("Ultima atualização as: " + calendar.get(Calendar.HOUR)
                + ":" + calendar.get(Calendar.MINUTE) 
                + ":" + calendar.get(Calendar.SECOND));
    }
    
}
