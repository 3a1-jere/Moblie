/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Membre;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.animations.FlipTransition;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField tnom;
    TextField tid,tprix;
    Button btnajout,btnaff,btnaff2,produit,add,service,astuce,offre,coupon;

    public HomeForm(Membre t) {
        f = new Form("Shopetal",new BoxLayout(BoxLayout.Y_AXIS));
       SpanLabel star =new SpanLabel("\n \n");
        produit=new Button("Nos produits");
        SpanLabel star4 =new SpanLabel("\n \n  ");
        service=new Button("Nos services");
        SpanLabel star5 =new SpanLabel("\n \n  ");
        astuce=new Button("Nos astuces");
        SpanLabel star6 =new SpanLabel("\n \n ");
        offre=new Button("Nos offres");
        SpanLabel star7 =new SpanLabel("\n \n");
        coupon=new Button("Nos coupons");
        
        
        f.add(star);
        f.add(produit);
        f.add(star4);
        f.add(service);
        f.add(star5);
        f.add(astuce);
        f.add(star6);
        f.add(offre);
        f.add(star7);
        f.add(coupon);
        
         f.getToolbar().addCommandToOverflowMenu("Mon panier", null, (ev)->{AfficherPanier a=new AfficherPanier(t);
                   
          a.getF().show();
          });
           f.getToolbar().addCommandToOverflowMenu("Mes commandes", null, (ev)->{    AfficherCommande a=new AfficherCommande(t);
                   
          a.getF().show();
          });
        
         Toolbar.setGlobalToolbar(true);

Style bg = f.getContentPane().getUnselectedStyle();
bg.setBgTransparency(200);
bg.setBgColor(0xFAFAFA);
    

      


 
f.show();
        
  produit.addActionListener((e)->{
        AffichageProduit a=new AffichageProduit(t);
         String pick = "Flip"; 
            int duration=1000;
       
    int h = CommonTransitions.SLIDE_HORIZONTAL;
       int v = CommonTransitions.SLIDE_VERTICAL;
    switch(pick) {
        case "Slide":
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            
            break;
        case "SlideFade":
            f.setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            break;
        case "Cover":
            f.setTransitionOutAnimator(CommonTransitions.createCover(v,true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createCover(v,true, duration));
            break;
        case "Uncover":
            f.setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
        case "Fade":
           f.setTransitionOutAnimator(CommonTransitions.createFade( duration));
             a.getF().setTransitionOutAnimator(CommonTransitions.createFade( duration));
            break;
        case "Flip":
            f.setTransitionOutAnimator(new FlipTransition(-1, duration));
             a.getF().setTransitionOutAnimator(new FlipTransition(-1, duration));
            break;
    }
        a.getF().show();
        
    });
          
    
    service.addActionListener((e)->{
        Affichage a=new Affichage(t);
         String pick = "Flip"; 
            int duration=1000;
       
    int h = CommonTransitions.SLIDE_HORIZONTAL;
       int v = CommonTransitions.SLIDE_VERTICAL;
    switch(pick) {
        case "Slide":
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            
            break;
        case "SlideFade":
            f.setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            break;
        case "Cover":
            f.setTransitionOutAnimator(CommonTransitions.createCover(v,true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createCover(v,true, duration));
            break;
        case "Uncover":
            f.setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
        case "Fade":
           f.setTransitionOutAnimator(CommonTransitions.createFade( duration));
             a.getF().setTransitionOutAnimator(CommonTransitions.createFade( duration));
            break;
        case "Flip":
            f.setTransitionOutAnimator(new FlipTransition(-1, duration));
             a.getF().setTransitionOutAnimator(new FlipTransition(-1, duration));
            break;
    }
        a.getF().show();
        
    });
          
    
     astuce.addActionListener((e)->{
        AffichageAstuces a=new AffichageAstuces(t);
         String pick = "Flip"; 
            int duration=1000;
       
    int h = CommonTransitions.SLIDE_HORIZONTAL;
       int v = CommonTransitions.SLIDE_VERTICAL;
    switch(pick) {
        case "Slide":
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            
            break;
        case "SlideFade":
            f.setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            break;
        case "Cover":
            f.setTransitionOutAnimator(CommonTransitions.createCover(v,true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createCover(v,true, duration));
            break;
        case "Uncover":
            f.setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
        case "Fade":
           f.setTransitionOutAnimator(CommonTransitions.createFade( duration));
             a.getF().setTransitionOutAnimator(CommonTransitions.createFade( duration));
            break;
        case "Flip":
            f.setTransitionOutAnimator(new FlipTransition(-1, duration));
             a.getF().setTransitionOutAnimator(new FlipTransition(-1, duration));
            break;
    }
        a.getF().show();
        
    });
     
          offre.addActionListener((e)->{
        AfficherOffre a=new AfficherOffre(t);
         String pick = "Flip"; 
            int duration=1000;
       
    int h = CommonTransitions.SLIDE_HORIZONTAL;
       int v = CommonTransitions.SLIDE_VERTICAL;
    switch(pick) {
        case "Slide":
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            
            break;
        case "SlideFade":
            f.setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            break;
        case "Cover":
            f.setTransitionOutAnimator(CommonTransitions.createCover(v,true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createCover(v,true, duration));
            break;
        case "Uncover":
            f.setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
        case "Fade":
           f.setTransitionOutAnimator(CommonTransitions.createFade( duration));
             a.getF().setTransitionOutAnimator(CommonTransitions.createFade( duration));
            break;
        case "Flip":
            f.setTransitionOutAnimator(new FlipTransition(-1, duration));
             a.getF().setTransitionOutAnimator(new FlipTransition(-1, duration));
            break;
    }
        a.getF().show();
        
    });
          
               coupon.addActionListener((e)->{
        AfficherVoucher a=new AfficherVoucher(t);
         String pick = "Flip"; 
            int duration=1000;
       
    int h = CommonTransitions.SLIDE_HORIZONTAL;
       int v = CommonTransitions.SLIDE_VERTICAL;
    switch(pick) {
        case "Slide":
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlide(h, true, duration));
            
            break;
        case "SlideFade":
            f.setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createSlideFadeTitle(true, duration));
            break;
        case "Cover":
            f.setTransitionOutAnimator(CommonTransitions.createCover(v,true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createCover(v,true, duration));
            break;
        case "Uncover":
            f.setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
            a.getF().setTransitionOutAnimator(CommonTransitions.createUncover(h,true, duration));
        case "Fade":
           f.setTransitionOutAnimator(CommonTransitions.createFade( duration));
             a.getF().setTransitionOutAnimator(CommonTransitions.createFade( duration));
            break;
        case "Flip":
            f.setTransitionOutAnimator(new FlipTransition(-1, duration));
             a.getF().setTransitionOutAnimator(new FlipTransition(-1, duration));
            break;
    }
        a.getF().show();
        
    });
          }
    
    
    
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

   

}
