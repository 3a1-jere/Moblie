/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Entity.Membre;
import Entity.commande;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import Service.ServiceCommande;
import com.codename1.ui.Container;

import com.codename1.ui.Label;

import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;


/**
 *
 * @author bhk
 */
public class AfficherCommande {

    Form f;
    SpanLabel lb;
   
    public AfficherCommande(Membre t) {
        
        f = new Form("Mes commandes",new BoxLayout(BoxLayout.Y_AXIS));

        ServiceCommande servicecom=new ServiceCommande();
        ArrayList<commande> listTasks = servicecom.getList2();
         
             for (commande l : listTasks) { 
               Label lb0 =new Label("Commande N°="+String.valueOf(l.getId_commande()));
                 Label lbl = new Label("Total : "+l.getTotal()+"TND");  
                 Label lbl2 = new Label("Adresse : "+l.getAdresse()); 
                 Label lbl3 = new Label("Ville : "+l.getVille());
                SpanLabel lbl4 = new SpanLabel("Livreur : "+l.getLivreur());
                SpanLabel lbl5 = new SpanLabel("Etat de la commande : "+l.getEtat());
                Label nejma =new Label("              ************************           "); 
                Label star =new Label("\n \n \n");
                Label star2 =new Label("\n \n \n");
             
             
             Container c = new Container(BoxLayout.y());
             c.add(lb0);
             c.add(lbl);
             c.add(lbl2);
             c.add(lbl3);
             c.add(lbl4);
             c.add(lbl5);
             c.add(star);
             c.add(nejma);
             c.add(star2);
        
              f.add(c);
             }
        
          f.getToolbar().addCommandToLeftBar("Accueil", null, (ev)->{HomeForm h=new HomeForm(t);
          h.getF().show();
          });
     
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
