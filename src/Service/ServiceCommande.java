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
import Entity.commande;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author farah
 */
public class ServiceCommande {

    public void ajouterCommande(commande com) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
       String Url="http://localhost/Shopetal/web/app_dev.php/Front/ajouterCommandemob?adresse="+com.getAdresse()+"&ville="+com.getVille(); 
       con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<commande> parseList(String json) {

        ArrayList<commande> listCommande = new ArrayList<>();

          try {
            JSONParser j = new JSONParser();

            Map<String, Object> com = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) com.get("root");
            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des commandes et récupération de leurs données
                commande c = new commande();

                float id = Float.parseFloat(obj.get("idCommande").toString());

                c.setId_commande((int) id);
                c.setTotal(obj.get("total").toString());
                c.setAdresse(obj.get("adresse").toString());
                c.setVille(obj.get("ville").toString());
                c.setLivreur(obj.get("livreur").toString());
                c.setEtat(obj.get("etat").toString());
                System.out.println(c);
                
                listCommande.add(c);

         
            }

        } catch (IOException ex) {
           
            
        }
        System.out.println(listCommande);
        return listCommande;

    }
    
    
    ArrayList<commande> listCommande = new ArrayList<>();
    
    public ArrayList<commande> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/afficherCommandemob");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCommande ser = new ServiceCommande();
                
                    listCommande = ser.parseList(new String(con.getResponseData()));
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCommande;
    }

}
