/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Entity.Voucher;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ala
 */
public class ServiceVoucher {
    
     public void ajouterVoucher(Voucher v) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
       String Url="http://localhost/Shopetal/web/app_dev.php/Front/MajouterVoucher?voucherCode="+v.getVoucherCode()+"&nbUse="+v.getNbUse()+"&maxUse="+v.getMaxUse()+"&rate="+v.getRate();
       con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Voucher> parseList(String json) {

        ArrayList<Voucher> listVoucher = new ArrayList<>();

          try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> com = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) com.get("root");
//            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Voucher v = new Voucher();

                 v.setVoucherCode(obj.get("vouchercode").toString());
                 float rate = Float.parseFloat(obj.get("rate").toString());
                 v.setRate((int) rate);
                 float nbuse = Float.parseFloat(obj.get("nbuse").toString());
                 v.setNbUse((int) nbuse);
                 float maxuse = Float.parseFloat(obj.get("maxuse").toString());
                 v.setMaxUse((int) maxuse);

                System.out.println(v);
                
                listVoucher.add(v);

         
            }

        } catch (IOException ex) {
        
            
        }
        System.out.println(listVoucher);
        return listVoucher;

    }
    
    
    ArrayList<Voucher> listVoucher = new ArrayList<>();
    
    public ArrayList<Voucher> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Shopetal/web/app_dev.php/Front/MafficherVoucher");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceVoucher ser = new ServiceVoucher();
                
                    listVoucher = ser.parseList(new String(con.getResponseData()));
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVoucher;
    }
    
}
