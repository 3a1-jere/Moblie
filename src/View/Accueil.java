/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import Entity.Membre;
import Service.ServiceTask;

/**
 *
 * @author Asus
 */
public class Accueil {
    
    Form f;

    TextField tetat;
    TextField temail ;
    Button btnajout,btnaff;
    
    public Accueil() {
        
        f = new Form("Accueil ",BoxLayout.y());
    
        
        tetat = new TextField("","pass");
        temail = new TextField("","email");
        
        btnaff=new Button("Se connecter ");
        
        btnajout = new Button("S'inscrire");
        
        f.add(temail);
        f.add(tetat);
        
         
        f.add(btnaff);
        f.add(btnajout);
       
        
          btnaff.addActionListener((e) -> {
            ServiceTask ser = new ServiceTask();
            Membre t = new Membre(temail.getText(),tetat.getText());
            if(ser.verifyPass(t).getEmail().equals(t.getEmail())){
            HomeForm a = new HomeForm (t) ;
            a.getF().show();
            
            }
        

        });
          btnajout.addActionListener((e) -> {
            Inscription a = new Inscription () ;
            a.getF().show();
            
            
        

        });
             
    }

    

    public TextField getTetat() {
        return tetat;
    }

    public void setTetat(TextField tetat) {
        this.tetat = tetat;
    }

    public TextField getTemail() {
        return temail;
    }

    public void setTemail(TextField temail) {
        this.temail = temail;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }

    public Button getBtnaff() {
        return btnaff;
    }

    public void setBtnaff(Button btnaff) {
        this.btnaff = btnaff;
    }


    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

  
}
