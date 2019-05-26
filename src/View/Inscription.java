/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import Entity.Membre;
import Service.ServiceTask;

/**
 *
 * @author bhk
 */
public class Inscription {

    Form f;
    TextField tnom;
    TextField tetat;
    TextField temail ;
    Button btnajout,btnaff;

    public Inscription() {
        f = new Form("Inscription",BoxLayout.y());
        
        tnom = new TextField("","username");
        tetat = new TextField("","pass");
        temail = new TextField("","email");
        btnajout = new Button("S'inscrire");

        
        f.add(tnom);
        f.add(tetat);
        f.add(temail);
        f.add(btnajout);
        f.getToolbar().addCommandToLeftBar("Accueil", null, (e)-> {
           Accueil a = new Accueil();
            a.getF().show();
        });
        
        btnajout.addActionListener((e) -> {
            ServiceTask ser = new ServiceTask();
            Membre t = new Membre( tnom.getText(), temail.getText(),tetat.getText());
            ser.ajoutTask(t);
            Dialog.show("Done","New Account Created","ok",null);
            Accueil a = new Accueil();
            Message m = new Message("Welcome to Shopetal");
           Display.getInstance().sendMessage(new String[] {"mohamedanouer.bouhouch@esprit.tn"}, "Welcome", m);
            a.getF().show();
            
          
        });
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
