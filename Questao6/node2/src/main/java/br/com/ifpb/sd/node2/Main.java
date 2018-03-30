package br.com.ifpb.sd.node2;

import br.com.ifpb.sd.shared.Notify;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigobento
 */
public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(1090);
        Notify not = (Notify) reg.lookup("node1");
        try {
            verifyUpdate(not);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void verifyUpdate(Notify not) throws IOException, InterruptedException {
        Path dir = Paths.get("../");
        String arq = "db.txt";
        while (true) {
            WatchService watch = FileSystems.getDefault().newWatchService();
            dir.register(watch, StandardWatchEventKinds.ENTRY_MODIFY);

            WatchKey take = watch.take();

            List<WatchEvent<?>> events = take.pollEvents();
            for (WatchEvent<?> event : events) {
                WatchEvent.Kind<?> kind = event.kind();
                if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    Path watchEventPath = (Path) event.context();
                    // Se a modificação for no arquivo desejado, enviar notificação
                    if (watchEventPath.toString().equals(arq)) {
                        not.updateFile(Calendar.getInstance());
                        System.out.println("Notificação enviada para o node1");
                    }
                }
            }
        }
    }

}
