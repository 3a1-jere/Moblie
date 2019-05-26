/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entity.Membre;
import Entity.Service;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class ServiceService {
    Membre a = new Membre (); 
  

    

    public Service parseListTaskJson(String json) {

        Service listTasks = new Service();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            System.out.println(tasks.get("idService"));            
        float id = Float.parseFloat(tasks.get("idService").toString());
float idMembre = Float.parseFloat(tasks.get("idMembre").toString());
//float idJardinier = Float.parseFloat(tasks.get("idJardinier").toString());
float nbheures = Float.parseFloat(tasks.get("nbheures").toString());
float nbjours = Float.parseFloat(tasks.get("nbjours").toString());
float prix = Float.parseFloat(tasks.get("prix").toString());
                listTasks.setIdService((int) id);
                listTasks.setIdMembre((int) idMembre);
                if (tasks.get("idJardinier")== null)
                    
                listTasks.setIdJardinier(666);
                
                listTasks.setNbjours((int)nbjours);
                listTasks.setNbheures((int)nbheures);
                listTasks.setNomService(tasks.get("nomService").toString());
                listTasks.setPrix((float)prix);
                    

        } catch (IOException ex) {
        }
        
        System.out.println(listTasks);
        return listTasks;

    }
    
    
   Service listTasks = new Service();
    
    public Service getList2(Membre t){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/Service?idMembre=" + t.getId());  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceService ser = new ServiceService();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
        
        
        return listTasks;
    }
    
}
