/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.codename1.components.ImageViewer;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.events.SelectionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.EventDispatcher;
import com.codename1.ui.util.Resources;
import Service.ServiceAstuces;
import Entity.Astuces;
import Entity.Membre;
import java.io.IOException;

/**
 *
 * @author Nckey Larson
 */
public class Welcome {
    private Resources theme;
     Form f;
    Button Afficher_btn,ajouter_btn,mail;
    private Style s;
  
    
   
   
   
    
    public Welcome(Membre t)
          {    
f = new Form("home");

Afficher_btn = new Button("La Liste des Astuces");
ajouter_btn = new Button("Ajouter Une Astuce");
mail = new Button("Avertir ");
Button btn_supprimer= new Button("Supprimer");
TextField confirme = new TextField();
Label l = new Label("Donner L'ID de l'astuce");
Label l2 = new Label("Donner Le titre de l'astuce");
TextField param = new TextField();

Button btn_chech= new Button("Chercher");
btn_chech.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
         AffichageAstuces a = new AffichageAstuces(param.getText(),t);
         
         if(a.getAstuces()!=null && !a.getAstuces().isEmpty())
         { a.getF().show();}
         else
                              Dialog.show("", "Aucune astuce avec ce titre trouvée",  "OK", "Cancel");

           
    }
});


/*******/

 //rating r = new rating();

 Container c = new Container(BoxLayout.y());
            c.add(Afficher_btn);
            c.add(ajouter_btn);    
            
 Container c1 = new Container(BoxLayout.y());  
                c1.add(l);
             c1.add(confirme);
            c1.add(btn_supprimer);
            c1.add(param);
            c1.add(btn_chech);
            //c.add(FlowLayout.encloseCenter(r.createStarRankSlider()));
            
        
            f.add(c);
            f.add(c1);
            
            
            
            
            
            
            
            

 Afficher_btn.addActionListener((e) -> {
            AffichageAstuces a = new AffichageAstuces(t);
            a.getF().show();
            

        });
 
  ajouter_btn.addActionListener((e) -> {
            ajou a = new ajou(t);
            a.getF().show();
            

        });
    mail.addActionListener((e) -> {
        
            

        });
  
  
  
    btn_supprimer.addActionListener((e) -> {
            System.out.println(confirme.getText());
            ServiceAstuces s = new ServiceAstuces();
            int i ;
            i=Integer.parseInt(confirme.getText());
            System.out.println(i);
            
            Astuces a = new Astuces();
            //System.out.println(s.getAstucesById(i));
            s.removeAstuce(i);
            
            Message m = new Message("une astuce a ete supprimée ");
            
        Display.getInstance().sendMessage(new String[]{"ahmed.abidi1@esprit.tn"}, "Avertissement",m);
           
            //String Finder = 
            

        });
        
        
          }
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
    
    
    
    
    
   




    
    
    
    
    
    
    
    
}
