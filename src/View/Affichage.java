/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import Entity.Membre;
import Entity.Service;
import Service.ServiceService;
import Service.ServiceTask;


/**
 *
 * @author bhk
 */
public class Affichage {

    Form f;
    SpanLabel lb;
  
    public Affichage(Membre t) {
        
        f = new Form("Service",BoxLayout.y());
        lb = new SpanLabel("");
        f.add(lb);
        ServiceService Task = new ServiceService();
       // lb.setText(serviceTask.getList2().toString());
        
          Label service = new Label(Task.getList2(t).toString());
          Label idService = new Label("idService = "+ Integer.toString(Task.getList2(t).getIdService()));
          Label nomService = new Label("nomService = "+ Task.getList2(t).getNomService());
          Label idJardinier = new Label ("idJardinier = "+Integer.toString(Task.getList2(t).getIdJardinier()));
          Label idMembre = new Label ("idMembre = "+Integer.toString(Task.getList2(t).getIdMembre()));
          Label nbheures = new Label ("nbheures = "+Integer.toString(Task.getList2(t).getNbheures()));
          Label nbjours = new Label ("nbjours = "+Integer.toString(Task.getList2(t).getNbjours()));
          Label prix = new Label ("prix = " + Float.toString(Task.getList2(t).getPrix()));
          
          f.add(idService);
          f.add(nomService);
          f.add(idJardinier);
          f.add(idMembre);
          f.add(nbheures);
          f.add(nbjours);
          f.add(prix);
          
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
