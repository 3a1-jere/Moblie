/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Entity.Offre;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Ala
 */
public class ServiceOffre {
    
     public void ajouterOffre(Offre o) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
       //"http://localhost/Shopetal/web/app_dev.php/Back/MajouterOffre?id="+o.getId()+"&categorie="+o.getCategorie()+"&cible="+o.getCible()+"&taux="+o.getTaux(); // création de l'URL
       String Url="http://localhost/Shopetal/web/app_dev.php/Front/MajouterOffre?id="+o.getId()+"&categorie="+o.getCategorie()+"&cible="+o.getCible()+"&taux="+o.getTaux()+"&dateDebut="+o.getDate_debut()+"&dateFin="+o.getDate_fin(); 
       con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Offre> parseList(String json) {

        ArrayList<Offre> listOffre = new ArrayList<>();

          try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> com = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) com.get("root");
//            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Offre o = new Offre();

                o.setId(obj.get("id").toString());
                 float taux = Float.parseFloat(obj.get("taux").toString());
                o.setTaux((int) taux);
                o.setCategorie(obj.get("categorie").toString());
                o.setCible(obj.get("cible").toString());
               
                LinkedHashMap<String,Object> date = (LinkedHashMap<String,Object>) obj.get("dateDebut");
    
                double t = (double) date.get("timestamp");
                long x = (long) (t* 1000L);
                Date a = new Date(x);
                
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    
                o.setDate_debut(formatter.format(a));

               
               date = (LinkedHashMap<String,Object>) obj.get("dateFin");
                t = (double) date.get("timestamp");
                x = (long) (t* 1000L);
                a = new Date(x);
                
    
                o.setDate_fin(formatter.format(a));

                System.out.println("Affichage depuis l'affichage *********************************");
                 System.out.println("*********************************");
                  System.out.println("*********************************");
                System.out.println(o);
                
                listOffre.add(o);

         
            }

        } catch (IOException ex) {
             System.out.println("mochkla");
            
        }
        System.out.println(listOffre);
        return listOffre;

    }
    
    
    ArrayList<Offre> listOffre = new ArrayList<>();
    
    public ArrayList<Offre> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/MafficherOffre");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceOffre ser = new ServiceOffre();
                
                    listOffre = ser.parseList(new String(con.getResponseData()));
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listOffre;
    }
    
}
