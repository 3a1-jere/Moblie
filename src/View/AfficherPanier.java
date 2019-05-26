/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Membre;
import Entity.commande;
import Entity.lignecommande;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import Service.ServiceCommande;
import Service.ServicePanier;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.animations.FlipTransition;
import com.codename1.ui.plaf.Style;
import java.util.ArrayList;




/**
 *
 * @author bhk
 */
public class AfficherPanier {

    Form f,f2;
    SpanLabel lb;
    Button commander,valider;
     TextField tadresse;
    TextField tville;
  
    public AfficherPanier(Membre t) {
        
        f = new Form("Mon panier",new BoxLayout(BoxLayout.Y_AXIS));
        lb = new SpanLabel("");
        f.add(lb);
        ServicePanier service=new ServicePanier();
           ArrayList<lignecommande> listTasks = service.getList2();
         
             for (lignecommande l : listTasks) { 
           int deviceWidth = Display.getInstance().getDisplayWidth();
                 Image placeholder = Image.createImage(deviceWidth / 1, deviceWidth / 1, 0xd80000); 
             EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
             URLImage url = URLImage.createToStorage(encImage, l.getImage(),"http://localhost/Shopetal/web/"+l.getImage());
             ImageViewer i = new ImageViewer(url);
               Label lbl = new Label(l.getNom_produit());  
                 Label lbl2 = new Label("Prix : "+String.valueOf(l.getPrix_produit())+"TND"); 
                 Label lbl3 = new Label("Quantite :"+String.valueOf(l.getQuantite_lignecommande()));
                 Label lbl4 = new Label("Total panier : "+String.valueOf(l.getPrix_panier())+"TND");
                 Label nejma =new Label("              ************************           "); 
                Label star =new Label("\n \n \n");
                Label star2 =new Label("\n \n \n");
               
                
             Container c = new Container(BoxLayout.y());
             c.add(i);
             c.add(lbl);
             c.add(lbl2);
             c.add(lbl3);
             c.add(lbl4);
             c.add(star);
             c.add(nejma);
             c.add(star2);
        
              f.add(c);
             }
        commander = new Button("Commander");
          f.add(commander);
      
          f.getToolbar().addCommandToLeftBar("Accueil", null, (ev)->{HomeForm h=new HomeForm(t);
          h.getF().show();
          
          });
         
          
          f2=new Form("Commander",new BoxLayout(BoxLayout.Y_AXIS));
           tadresse = new TextField("","Saisissez votre adresse");
        tville = new TextField("","Saisissez votre ville");
        valider = new Button("Valider");
          f2.add(tadresse);
          f2.add(tville);
          f2.add(valider);
          
          
          valider.addActionListener((e)->{
          ServiceCommande ser = new ServiceCommande();
            commande com = new commande(0, "", "farah", tadresse.getText(), tville.getText(), "", "");
              System.out.println(com);
              ser.ajouterCommande(com);
            Dialog.show("Shopetal", "Votre commande est en cours de traitement", "Ok", null);
            AfficherCommande co= new AfficherCommande(t);
            co.getF().show();
          });
          
          
          Toolbar.setGlobalToolbar(true);

Style bg = f.getContentPane().getUnselectedStyle();
bg.setBgTransparency(200);
bg.setBgColor(0xFAFAFA);

bg = f2.getContentPane().getUnselectedStyle();
bg.setBgTransparency(255);
bg.setBgColor(0xFAFAFA);
f2.setBackCommand(
        f2.getToolbar().addCommandToLeftBar("Mon panier", null, (e) -> f.showBack()));

commander.addActionListener((e) -> {
   
            String pick = "Flip"; 
            int duration=1000;
       
    int h = CommonTransitions.SLIDE_HORIZONTAL;
       int v = CommonTransitions.SLIDE_VERTICAL;
    switch(pick) {
        case "Slide":
            f.setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            f2.setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            
            break;
        case "SlideFade":
            f.setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            f2.setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            break;
        case "Cover":
            f.setTransitionOutAnimator(CommonTransitions.createCover(h,true, duration));
            f2.setTransitionOutAnimator(CommonTransitions.createCover(h,true, duration));
            break;
        case "Uncover":
            f.setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
            f2.setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
        case "Fade":
           f.setTransitionOutAnimator(CommonTransitions.createFade( duration));
            f2.setTransitionOutAnimator(CommonTransitions.createFade( duration));
            break;
        case "Flip":
            f.setTransitionOutAnimator(new FlipTransition(-1, duration));
            f2.setTransitionOutAnimator(new FlipTransition(-1, duration));
            break;
    }
    f2.show();
});
f.show();
          
          
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}



//Button showTransition = new Button("Show");
//Picker pick = new Picker();
//pick.setStrings("Slide", "SlideFade", "Cover", "Uncover", "Fade", "Flip");
//pick.setSelectedString("Slide");
//TextField duration = new TextField("10000", "Duration", 6, TextArea.NUMERIC);
//CheckBox horizontal = CheckBox.createToggle("Horizontal");
//pick.addActionListener((e) -> {
//    String s = pick.getSelectedString().toLowerCase();
//    horizontal.setEnabled(s.equals("slide") || s.indexOf("cover") > -1);
//});
//horizontal.setSelected(true);
//
//    f.add(pick).
//    add(duration).
//    add(horizontal);