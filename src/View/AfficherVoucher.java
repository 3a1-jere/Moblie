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
import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import Service.ServiceVoucher;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class AfficherVoucher {

    Form f;
    SpanLabel lb;
  
    public AfficherVoucher(Membre m) {
        
        f = new Form("Vouchers",new BoxLayout(BoxLayout.Y_AXIS));

        ServiceVoucher serviceV =new ServiceVoucher();
           ArrayList<Voucher> listTasks = serviceV.getList2();
         
             for (Voucher l : listTasks) { 
           
               
               Label lbl = new Label(l.getVoucherCode());  
                 Label lbl2 = new Label("Nombre d'utilisation : "+(l.getNbUse())); 
                 Label lbl3 = new Label("Nombre maximal d'utilisation :"+(l.getMaxUse()));
                 Label lbl4 = new Label("Rate : "+(l.getRate()));
                 Label nejma =new Label("              ************************           "); 
                Label star =new Label("\n \n \n");
                Label star2 =new Label("\n \n \n");
               
                
             Container c = new Container(BoxLayout.y());
             
             c.add(lbl);
             c.add(lbl2);
             c.add(lbl3);
             c.add(lbl4);
             c.add(star);
             c.add(nejma);
             c.add(star2);
        
              f.add(c);
             }
        
        
          f.getToolbar().addCommandToLeftBar("Accueil", null, (ev)->{HomeForm h=new HomeForm(m);
          h.getF().show();
          });
          f.getToolbar().addCommandToRightBar("Ajouter", null, (ev)->{AjoutVoucherForm h=new AjoutVoucherForm(m);
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
