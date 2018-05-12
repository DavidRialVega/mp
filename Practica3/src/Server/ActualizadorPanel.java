package Server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActualizadorPanel extends Thread{       
    
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
                ServerExec.eviarEstadoPanel();
                //ServerExec.enviarPuntuaciones();
            } catch (InterruptedException ex) {
                Logger.getLogger(ActualizadorPanel.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }
    }
}
