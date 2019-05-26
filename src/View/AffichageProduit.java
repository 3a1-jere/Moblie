/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Membre;
import Entity.lignecommande;
import Entity.produit;
import Service.ServicePanier;
import Service.ServiceProduit;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class AffichageProduit {
                   

    Form f;
    SpanLabel lb;
    Container c;
  Container d;
  TextField tid,tnom,tprix,timage;
    public AffichageProduit(Membre t) {
         f = new Form("Nos produits");
        lb = new SpanLabel("");
        
        
        
         ServiceProduit serviceTask=new ServiceProduit();
         ArrayList<produit> listTasks = serviceTask.getList2();
         
             for (produit l : listTasks) { 
                 
                 
                 Label lbl4 = new Label(l.getImage());
                 
                  Label lb0 =new Label(String.valueOf(l.getId()));
                 
                 Label lbl = new Label(l.getNom());  
                 
                 Label lbl2 = new Label(l.getPrix().toString()); 
                 Label lbl3 = new Label(l.getCategorie());
                 int deviceWidth = Display.getInstance().getDisplayWidth();
             Image placeholder = Image.createImage(deviceWidth / 1, deviceWidth / 1, 0xd80000); //square image set to 10% of screen width
             EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
             URLImage url = URLImage.createToStorage(encImage, l.getImage(),"http://localhost/Shopetal/web/"+l.getImage());
             ImageViewer i = new ImageViewer(url);
             
             Image placeholders = Image.createImage(deviceWidth / 5, deviceWidth / 5, 0xd80000); //square image set to 10% of screen width
             EncodedImage encImage1 = EncodedImage.createFromImage(placeholders, true);
             URLImage url1 = URLImage.createToStorage(encImage1, "addtocart.png","http://localhost/Shopetal/web/images/addtocart.png");
             ImageViewer im = new ImageViewer(url1);
             
             c = new Container(BoxLayout.y());
             d=new Container(BoxLayout.x());
              Button add=new Button("Ajouter à mon panier");
               Label star =new Label("\n \n ");
             c.add(i); 
             d.add(lbl);
             
             c.add(d);
             c.add(lbl2);
             c.add(lbl3);
             c.add(add);
             c.add(star);
             
             f.add(c);
             
             // farah
             
              tid=new TextField();
 tnom=new TextField();
 tprix=new TextField();
 timage=new TextField();
            
              add.addActionListener((e)->{
                  tid.setText(lb0.getText());
                  tnom.setText(lbl.getText());
                  tprix.setText(lbl2.getText());
                  timage.setText(lbl4.getText());
                   String tid1 = tid.getText();
                 String tprix1 = tprix.getText();
                  int tid2 = Integer.parseInt(tid1);
                  float tprix2 = Float.parseFloat(tprix1);
                  ServicePanier ser = new ServicePanier();
            lignecommande lcom = new lignecommande(tid2,timage.getText(), tnom.getText(), tprix2, 0, tprix2);
            System.out.println(lcom);
              ser.ajouterPanier(lcom);
            Dialog.show("Shopetal", "Ce produit est ajouté avec succes dans votre panier", "Ok", null);
              });
  
              
         }
             
             
             //
             
             
             
        
        
       
        

        f.add(lb);
        
       // lb.setText(serviceTask.getList2().toString());
        
         
         
          f.getToolbar().addCommandToOverflowMenu("Ajouter produit", null, (ev)->{ajouterProduit h=new ajouterProduit(t);
                   
          h.getF().show();
          });
           f.getToolbar().addCommandToLeftBar("Accueil", null, (ev)->{HomeForm z=new HomeForm(t);
                   
          z.getF().show();
          });
          f.getToolbar().addCommandToOverflowMenu("capture d'écran", null, (e1)->{
       
        Image screenshot = Image.createImage(f.getWidth(), f.getHeight());
        f.revalidate();
        f.setVisible(true);
        f.paintComponent(screenshot.getGraphics(), true);

        String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
        try(OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
            ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
        } catch(IOException err) {
            Log.e(err);
        }
          });
    }
    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Container getC() {
        return c;
    }

    public void setC(Container c) {
        this.c = c;
    }
    

}
