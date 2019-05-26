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
import Entity.produit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author bhk
 */
public class ServiceCatalogue {

 

    public ArrayList<produit> parseList(String json) {

        ArrayList<produit> listcatalogue = new ArrayList<>();

          try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> cat = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) cat.get("root");
//            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                produit c = new produit();

                float id = Float.parseFloat(obj.get("id").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                float qte = Float.parseFloat(obj.get("quantite").toString());

                c.setId((int) id);
                c.setNom(obj.get("nom").toString());
                c.setPrix( prix);
                c.setImage(obj.get("image").toString());
                c.setQuantite((int)qte);
                c.setCategorie(obj.get("categorie").toString());
                System.out.println(c);
                
                listcatalogue.add(c);

         
            }

        } catch (IOException ex) {
            
            
        }
        System.out.println(listcatalogue);
        return listcatalogue;

    }
    
    
    ArrayList<produit> listcata = new ArrayList<>();
    
    public ArrayList<produit> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/afficherCataloguemob");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCatalogue ser = new ServiceCatalogue();
                
                    listcata = ser.parseList(new String(con.getResponseData()));
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listcata;
    }
    
    

}
