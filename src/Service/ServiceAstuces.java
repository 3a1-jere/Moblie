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
import Entity.Astuces;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  
 * @author nckey LArson
 */
public class ServiceAstuces {

    
     ArrayList<Astuces> listeastuces = new ArrayList<>();
    
       public ArrayList<Astuces> parseListTaskJson(String json) {

        ArrayList<Astuces> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Astuces e = new Astuces();

                float id = Float.parseFloat(obj.get("idAstuce").toString());
                e.setId_Astuce((int)id);
                e.setTitre_Astuce(obj.get("titreAstuce").toString());
                e.setType_Astuce(obj.get("typeAstuce").toString());
                e.setDesc_Astuce(obj.get("descAstuce").toString());
//                e.setImagefile(obj.get("imageFile").toString());
                e.setImage_Astuce(obj.get("imageAstuce").toString());
                
                
                
                
                
                System.out.println(e);
                
                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
    
    
    
    
    
      ArrayList<Astuces> listAstuces = new ArrayList<>();
      
      public ArrayList<Astuces> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/astuces/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAstuces ser = new ServiceAstuces();
                listAstuces = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAstuces;
    } 
      
      public ArrayList<Astuces> Cherch(String titre){       
        ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/astuces/find_api?titre="+titre);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAstuces ser = new ServiceAstuces();
                listAstuces = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAstuces;
    } 
    
    
       public void ajoutTask(Astuces ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/Shopetal/web/app_dev.php/Front/astuces/new?Titre_Astuce="+ta.getTitre_Astuce()+"&Desc_Astuce="+ta.getDesc_Astuce()+"&Type_Astuce="+ta.getType_Astuce()+"&Image_Astuce="+ta.getImagefile() ;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
       public void removeAstuce(int id){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/astuces/Delete/"+id); 
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
       
       
       
      /* public ArrayList<Astuces> getAstucesById(int id){
            ConnectionRequest con = new ConnectionRequest();
            
            con.setUrl("http://localhost/Shopetal/web/app_dev.php/api/astuces/find/"+id);  
            con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceAstuces ser = new ServiceAstuces();
                listeastuces = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);


       
        
        
        return listeastuces;
            }*/
       
}
