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
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import Entity.Membre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceTask {
    Membre a = new Membre (); 
    public Membre verifyPass(Membre t){
       
             ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/verify?email=" + t.getEmail()+"&password="+t.getPassword() );  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceTask ser = new ServiceTask();
                a = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         return a;
        
        
    }

    public void ajoutTask(Membre ta) {
        
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/Shopetal/web/app_dev.php/Front/new?username=" + ta.getUsername()+ "&password=" + ta.getPassword() +"&email="+ ta.getEmail();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
        
                        
         
                       
    }

    public Membre parseListTaskJson(String json) {

        Membre listTasks = new Membre();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            System.out.println(tasks.get("id"));            
        float id = Float.parseFloat(tasks.get("id").toString());

                listTasks.setId((int) id);
                listTasks.setEmail(tasks.get("email").toString());
                listTasks.setUsername(tasks.get("username").toString());
                listTasks.setPassword(tasks.get("password").toString());
                    

        } catch (IOException ex) {
        }
        
        System.out.println(listTasks);
        return listTasks;

    }
    
    
   Membre listTasks = new Membre();
    
    public Membre getList2(Membre t){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/profil?email=" + t.getEmail() );  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceTask ser = new ServiceTask();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
        
        
        return listTasks;
    }

}
