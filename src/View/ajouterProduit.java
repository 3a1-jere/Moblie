/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Membre;
import Entity.produit;
import Service.ServiceProduit;
import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author bhk
 */
public class ajouterProduit {

    Form f;
    Container c;
    TextField nomtf;
    TextField quantitetf;
    
    TextField prixtf;
    Picker categorie;
    Picker type;
    Picker imagetf;
    String[] characters = {"Plantes","Fleurs"};
    String[] characters1 = {"Alstroemeria","Amaryllis","Anthurium","Aster","Oiseau de paradis","Bupleurum","arbustes","arbres","plantes grimpantes et les lianes"};
    String[] characters2 = {"images/a1.jpg","images/a2.jpg","images/a3.jpg","images/a4.jpg","images/a5.jpg"};
    
    
    Button btnajout,btnaff ;
    Button capture;
    Label photo;
    public ajouterProduit(Membre t) {
        f = new Form("Shopetal");
        c=new  Container(BoxLayout.y());
        nomtf = new TextField("","nom");
        quantitetf = new TextField("","quantite");
        prixtf = new TextField("", "prix");
        imagetf= new Picker();
        imagetf.setType(Display.PICKER_TYPE_STRINGS);

        imagetf.setStrings(characters2);
        
        categorie = new Picker();
        categorie.setType(Display.PICKER_TYPE_STRINGS);

        categorie.setStrings(characters);
        
        type=new Picker();
        type.setType(Display.PICKER_TYPE_STRINGS);

        type.setStrings(characters1);
        btnajout = new Button("ajouter le produit");
        btnaff=new Button("Consulter les produits");
        capture = new Button("upload image");
        photo = new Label("");
        
        Button aaa=new Button("position?");
         int deviceWidth = Display.getInstance().getDisplayWidth();
             Image placeholder = Image.createImage(deviceWidth / 8, deviceWidth / 8, 0xd80000); //square image set to 10% of screen width
             EncodedImage encImage = EncodedImage.createFromImage(placeholder, true);
             URLImage url = URLImage.createToStorage(encImage, "position.png","http://localhost/Shopetal/web/images/position.png");
             ImageViewer im = new ImageViewer(url);
             c.add(im);
        c.add(aaa);
        aaa.addActionListener((e)->{
            Location position = LocationManager.getLocationManager().getCurrentLocationSync();
       
        Dialog dlg = new Dialog("votre Position maintenant : ");

dlg.add(new SpanLabel(position.toString(), position.toString()));

dlg.setDisposeWhenPointerOutOfBounds(true);
dlg.showDialog();
            
            
            
            
        
        
        });
        
       
        
        
        
        
        c.add(nomtf);
        c.add(quantitetf);
        c.add(imagetf);
        c.add(prixtf);
        c.add(categorie);
        c.add(type);
        c.add(btnajout);
        c.add(btnaff);
        c.add(capture);
        c.add(photo);
        f.add(c);
        btnajout.addActionListener((e) -> {
            ServiceProduit ser = new ServiceProduit();
 //nom prix prix_initial quantite image categorie type
            produit p = new produit(nomtf.getText(), Float.parseFloat(prixtf.getText()),Integer.parseInt(quantitetf.getText()), imagetf.getText(),type.getText(),Float.parseFloat(prixtf.getText()), categorie.getText());
            ser.ajoutProduit(p);
             Dialog dlg1 = new Dialog("produit ajouté ! ");
dlg1.setDisposeWhenPointerOutOfBounds(true);
dlg1.showDialog();

        });
        btnaff.addActionListener((e)->{
        AffichageProduit a=new AffichageProduit(t);
        a.getF().show();
        });
        
        capture.addActionListener((e)-> {
        String i = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
        imagetf.setText(i);
        if (i != null)
        { try{
        Image img = Image.createImage(i);
        photo.setIcon(img);
        f.getComponentForm().revalidate();
        } catch (Exception err){
        err.printStackTrace();
        }
        }
        });
     Button sb=new Button("capture d'écran");
        sb.addActionListener(e1->{
       
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
        //f.add(sb);
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

    public TextField getNomtf() {
        return nomtf;
    }

    public void setNomtf(TextField nomtf) {
        this.nomtf = nomtf;
    }

    public TextField getQuantitetf() {
        return quantitetf;
    }

    public void setQuantitetf(TextField quantitetf) {
        this.quantitetf = quantitetf;
    }

    public TextField getPrixtf() {
        return prixtf;
    }

    public void setPrixtf(TextField prixtf) {
        this.prixtf = prixtf;
    }

    public Picker getImagetf() {
        return imagetf;
    }

    public void setImagetf(Picker imagetf) {
        this.imagetf = imagetf;
    }



   
}
