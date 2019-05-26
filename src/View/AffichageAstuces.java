/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridBagLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import Service.ServiceAstuces;
import Entity.Astuces;
import Entity.Membre;
import com.mycompany.myapp.MyApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nckey Larson
 */
public class AffichageAstuces {
    
     Form f;
      Button envoyer_bt;
    SpanLabel lb;
    ServiceAstuces serviceAstuces=new ServiceAstuces();
    ArrayList<Astuces> astuces = new ArrayList<>(); 
     public AffichageAstuces(Membre t) {
        
      
         serviceAstuces=new ServiceAstuces();
        astuces = serviceAstuces.getList2();
         if(astuces!=null && !astuces.isEmpty())
         {initi(t);}
         
    }

    public ArrayList<Astuces> getAstuces() {
        return astuces;
    }

    public void setAstuces(ArrayList<Astuces> astuces) {
        this.astuces = astuces;
    }
     
     
      public AffichageAstuces(String titre, Membre t) {
        f.getToolbar().addCommandToLeftBar("Retour", null, (ev)->{Welcome h=new Welcome(t);
          h.getF().show();
          });
      
         serviceAstuces=new ServiceAstuces();
        astuces = serviceAstuces.Cherch(titre);
         if(astuces!=null && !astuces.isEmpty())
         {initi(t);}
         
         
         
    }
     
    
     private void initi(Membre t)
    
    {
        int mm = Display.getInstance().convertToPixels(3);
  EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(1,1), false);

         f = new Form("List Astuces", new BorderLayout());
        
         
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{
             Welcome w = new Welcome(t);
             w.getF().show();

          });
  
        
        
        ArrayList<Map<String, Object>> data = new ArrayList<>();
     
for(int i =0;i<astuces.size();i++)
{  
        
 String filePath = "file:///C:/wamp64/www/Shopetal/web/images/astuces/"+astuces.get(i).getImage_Astuce();
        if (filePath != null) {
            try {

                String pathToBeStored;
                pathToBeStored = FileSystemStorage.getInstance().getAppHomePath() + System.currentTimeMillis();
                Image img;
                img = Image.createImage(filePath);
                 int displayHeight = Display.getInstance().getDisplayHeight();
    Image scaledPhotoImage = img.scaled(-1, displayHeight / 4);
                data.add(createListEntry("Titre:\n\n "+astuces.get(i).getTitre_Astuce(),scaledPhotoImage,"Description:\n\n "+astuces.get(i).getDesc_Astuce()));
                 
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    
    
}
DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
MultiList ml = new MultiList(model);

ml.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
                 Astuces a = new Astuces();
                   System.out.println(ml.getSelectedItem().toString());
                    String mot ="Description";
                    String str  = ml.getSelectedItem().toString();
                    int pos = str.indexOf(mot);
                 Dialog.show("", str.substring(pos),  "OK", "Cancel");
              
                 
                 
             }
             
             
             
         });
envoyer_bt = new Button("Partager L'astuce");

f.add(BorderLayout.CENTER, ml);
       

 
 
 
 

}
     
      private Map<String, Object> createListEntry(String nom,Image icon, String description) {
    Map<String, Object> entry = new HashMap<>();
    
    entry.put("Line1", nom);
    entry.put("Line2", icon);
    entry.put("Line3", description);
    
    return entry;
    }
      
      
      
      
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }


    
    
    
    
    
}
    








/*** RATING**/