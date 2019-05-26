/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.codename1.capture.Capture;
import com.codename1.components.SpanLabel;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import Service.ServiceAstuces;
import Entity.Astuces;
import Entity.Membre;

/**
 *
 * @author Nckey Larson
 */
public class ajou {
    
 Form f;
    Container c;
    TextField titre;
    TextField Desc;

  
    Picker type;
    Picker imagetf;
    String[] characters = {"Avant Plantation","Plantation","Apres Plantation"};
  
    
    
    Button btnajout ;
    Button capture;
    Label photo;
    public ajou(Membre t) {
        f = new Form("Ajouter");
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{
             Welcome w = new Welcome(t);
             w.getF().show();

          });
        c=new  Container(BoxLayout.y());
        titre = new TextField("","Titre");
        Desc = new TextField("","Description");
        
        imagetf= new Picker();
        imagetf.setType(Display.PICKER_TYPE_STRINGS);

       
        
      
        
        type=new Picker();
        type.setType(Display.PICKER_TYPE_STRINGS);

        type.setStrings(characters);
        btnajout = new Button("ajouter l'astuce");
       
        capture = new Button("capturer une image");
        photo = new Label("");
        
      
        
        c.add(titre);
        c.add(Desc);
      
        c.add(imagetf);

        c.add(type);
        c.add(btnajout);
         c.add(capture);
        c.add(photo);
        f.add(c);
        btnajout.addActionListener((e) -> {
            if(titre.getText().length()==0&&Desc.getText().length()==0    )
            { Dialog.show("ERREUR", "Il faut remmplir les champs...", "OK", "Cancel");}
            else
            { ServiceAstuces ser = new ServiceAstuces();
 
            Astuces p = new Astuces();
            p.setTitre_Astuce(titre.getText());
            p.setType_Astuce(type.getText());
            p.setDesc_Astuce(Desc.getText());
            ser.ajoutTask(p);}
           
            

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
    
            
    }
    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getNomtf() {
        return titre;
    }

    public void setNomtf(TextField titre) {
        this.titre = titre;
    }

    

    public Picker getImagetf() {
        return imagetf;
    }

    public void setImagetf(Picker imagetf) {
        this.imagetf = imagetf;
    }


  public Container getC() {
        return c;
    }

    public void setC(Container c) {
        this.c = c;
    }

    public TextField getTitre() {
        return titre;
    }

    public void setTitre(TextField titre) {
        this.titre = titre;
    }

    public TextField getDesc() {
        return Desc;
    }

    public void setDesc(TextField Desc) {
        this.Desc = Desc;
    }

    public Picker getType() {
        return type;
    }

    public void setType(Picker type) {
        this.type = type;
    }

    public String[] getCharacters() {
        return characters;
    }

    public void setCharacters(String[] characters) {
        this.characters = characters;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }

    public Button getCapture() {
        return capture;
    }

    public void setCapture(Button capture) {
        this.capture = capture;
    }

    public Label getPhoto() {
        return photo;
    }

    public void setPhoto(Label photo) {
        this.photo = photo;
    }

}
