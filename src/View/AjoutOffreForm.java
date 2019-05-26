/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Membre;
import Entity.Offre;
import Service.ServiceOffre;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import java.util.Date;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author bhk
 */
public class AjoutOffreForm {

    Form f;
      TextField id = new TextField(null,"id");
    TextField categorie = new TextField(null,"categorie");
    TextField cible = new TextField(null,"cible");
    TextField taux = new TextField(null,"taux");
    Picker dateDebutPicker = new Picker();
    Picker dateFinPicker = new Picker();
    Button btnajout;
    Container cont;

    public AjoutOffreForm(Membre m) {
        f = new Form("Shopetal",new BoxLayout(BoxLayout.Y_AXIS));
       
        btnajout = new Button("ajouter");
       cont=new Container(BoxLayout.y());
        cont.add(id);
        cont.add(categorie);
        cont.add(cible);
        cont.add(taux);
        cont.add(dateDebutPicker);
        cont.add(dateFinPicker);   
        cont.add(btnajout);
          f.add(cont);
       
 f.getToolbar().addCommandToLeftBar("Retour", null, (ev)->{AfficherOffre h=new AfficherOffre(m);
          h.getF().show();
          });

         btnajout.addActionListener((e)->{
             
             
               ServiceOffre of = new ServiceOffre();
                 //ancien code
//                 Date dateD = dateDebutPicker.getDate();
//                  Date dateF = dateFinPicker.getDate();
               
               
                String dateD = dateDebutPicker.getDate().toString();
                String dateF = dateFinPicker.getDate().toString();
              
                 int intTaux=Integer.parseInt(taux.getText());
                
            Offre v = new Offre(id.getText(),categorie.getText(),cible.getText(),intTaux,dateD,dateF);
              System.out.println("Affichqage depuis AJout Offre Form");
              System.out.println(v);
              System.out.println("Affichqage depuis AJout Offre Form*********************************************");;
              of.ajouterOffre(v);
              AfficherOffre hf = new AfficherOffre(m); 
        hf.getF().show();
        });
     

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

   

}
