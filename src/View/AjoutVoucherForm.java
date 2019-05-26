/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Membre;
import Entity.Voucher;
import Entity.lignecommande;
import Service.ServicePanier;
import Service.ServiceVoucher;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author bhk
 */
public class AjoutVoucherForm {

    Form f;
    TextField voucherCode;
    TextField rate;
    TextField maxUse;
    TextField nbUse;
    Button btnajout;
    Container cont;

    public AjoutVoucherForm(Membre l) {
        f = new Form("Shopetal",new BoxLayout(BoxLayout.Y_AXIS));
       voucherCode=new TextField("", "Saisissez le code");
       nbUse=new TextField("", "Saisissez le nb d utilisation");
       maxUse=new TextField("", "Saisissez le nb max d utilisation");
       rate=new TextField("", "Saisissez le rate");
        btnajout = new Button("Ajouter");
        cont=new Container(BoxLayout.y());
        cont.add(voucherCode);
        cont.add(maxUse);
        cont.add(nbUse);
        cont.add(rate);
        cont.add(btnajout);
        
        f.add(cont);
        
        f.getToolbar().addCommandToLeftBar("Retour", null, (ev)->{AfficherVoucher h=new AfficherVoucher(l);
          h.getF().show();
          });
 

         btnajout.addActionListener((e)->{
            
                 String s2 = nbUse.getText();
                 String s3 = maxUse.getText();
                 String s4 = rate.getText();
               
                 int nbUse1=Integer.parseInt(s2);
                 int maxUse1=Integer.parseInt(s3);
                 int rate1=Integer.parseInt(s4);
                 
                  
                  ServiceVoucher serV = new ServiceVoucher();
            Voucher v = new Voucher(voucherCode.getText(),nbUse1,maxUse1,rate1);
            System.out.println(v);
              serV.ajouterVoucher(v);
            Dialog.show("Shopetal", "Ce voucher est ajouté avec succes ", "Ok", null);
            HomeForm hf = new HomeForm(l); 
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
