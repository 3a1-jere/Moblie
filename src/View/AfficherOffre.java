/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Membre;
import Entity.Offre;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import Service.ServiceOffre;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class AfficherOffre {

    Form f;
    SpanLabel lb;
  
    public AfficherOffre(Membre t) {
        
        f = new Form("Les offres",new BoxLayout(BoxLayout.Y_AXIS));
       
        ServiceOffre serviceof =new ServiceOffre();
        ArrayList<Offre> listTasks = serviceof.getList2();
         
             for (Offre l : listTasks) { 
           
               
               Label lbl = new Label("Catégorie:"+l.getCategorie());  
                 Label lbl2 = new Label("Cible : "+(l.getCible())); 
                 Label lbl3 = new Label("Taux de réduction:"+(l.getTaux())+"%");
                 Label lbl4 = new Label("Date début : "+(l.getDate_debut()));
                  Label lbl5 = new Label("Date fin : "+(l.getDate_fin()));
                 Label nejma =new Label("              ************************           "); 
                Label star =new Label("\n \n ");
                Label star2 =new Label("\n \n \n");
               
                
             Container c = new Container(BoxLayout.y());
             
             c.add(lbl);
             c.add(lbl2);
             c.add(lbl3);
             c.add(lbl4);
             c.add(lbl5);
             c.add(star);
             c.add(nejma);
             c.add(star2);
        
              f.add(c);
        
          f.getToolbar().addCommandToRightBar("Ajouter", null, (ev)->{AjoutOffreForm h=new AjoutOffreForm(t);
          h.getF().show();
          });
        
          f.getToolbar().addCommandToLeftBar("Accueil", null, (ev)->{HomeForm h=new HomeForm(t);
          h.getF().show();
          });
             }
          
  
          
            
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
