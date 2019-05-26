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
import Entity.lignecommande;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author bhk
 */
public class ServicePanier {
  public void ajouterPanier(lignecommande lcom) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
       String Url="http://localhost/Shopetal/web/app_dev.php/Front/addtocartmob?idProduit="+lcom.getId_produit()+"&image="+lcom.getImage()+"&nomProduit="+lcom.getNom_produit()+"&prixProduit="+lcom.getPrix_produit()+"&prixPanier="+lcom.getPrix_panier(); 
      

       con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<lignecommande> parseListTaskJson(String json) {

        ArrayList<lignecommande> listPanier = new ArrayList<>();

          try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> com = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) com.get("root");
//            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                lignecommande c = new lignecommande();

                float idLignecommande = Float.parseFloat(obj.get("idLignecommande").toString());
                float prixProduit = Float.parseFloat(obj.get("prixProduit").toString());
                float Quantite = Float.parseFloat(obj.get("Quantite").toString());
                float total = Float.parseFloat(obj.get("total").toString());

                c.setId_lignecommande((int) idLignecommande);
                c.setImage(obj.get("image").toString());
                 c.setNom_produit(obj.get("nomProduit").toString());
                c.setPrix_produit((float) prixProduit);
                c.setQuantite_lignecommande((int) Quantite);
                c.setPrix_panier((float) total);
               
             
                System.out.println(c);
                
                listPanier.add(c);

         
            }

        } catch (IOException ex) {
        }
        System.out.println(listPanier);
        return listPanier;

    }
    
    
    ArrayList<lignecommande> listPanier = new ArrayList<>();
    
    public ArrayList<lignecommande> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/afficherPaniermob");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServicePanier ser = new ServicePanier();
                
                    listPanier = ser.parseListTaskJson(new String(con.getResponseData()));
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listPanier;
    }

}
