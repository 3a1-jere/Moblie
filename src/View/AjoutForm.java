/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import Service.ServiceAstuces;
import Entity.Astuces;

/**
 *
 * @author bhk
 */
public class AjoutForm {

    Form f;
    TextField titre,desc;
    ComboBox<String> combo= new ComboBox<> ("Avant Plantation","Plantation","Apres Plantation");
    
    Button btnajout;
    

    public AjoutForm() {
        f = new Form("Ajouter");
        titre = new TextField();
        desc = new TextField();
        btnajout = new Button("ajouter l'astuce");
        
        
        
        f.add(titre);
        f.add(combo);
        f.add(btnajout);
        
       
        btnajout.addActionListener((e) -> {
            if(titre.getText().length()==0&&desc.getText().length()==0    )
            {
                System.out.println("remplir les champs");
            }
            else 
            { ServiceAstuces ser = new ServiceAstuces();
            Astuces t = new Astuces();
            t.setTitre_Astuce(titre.getText());
            t.setDesc_Astuce(desc.getText());
            t.setType_Astuce(titre.getText());

            
            ser.ajoutTask(t);}
           
            

        });
       
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

   

}
