/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author farah
 */
public class commande {
   
    private int id_commande;
    private String total;
     private String id_user;
     private String adresse;
     private String ville;     
    private String livreur;
    private String etat;

    public commande() {
    }

    public commande(int id_commande,String total, String id_user, String adresse, String ville, String livreur, String etat) {
        this.id_commande = id_commande;
        this.total = total;
        this.id_user = id_user;
        this.adresse = adresse;
        this.ville = ville;
        this.livreur = livreur;
        this.etat = etat;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLivreur() {
        return livreur;
    }

    public void setLivreur(String livreur) {
        this.livreur = livreur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
     public String toString() {
        return "\nCommande N°= "+ id_commande + "\nTotal=" + total +" TND"+ "\nAdresse=" + adresse + "\nVille=" + ville + "\nLivreur"+ livreur + "\nEtat de la commande=" + etat + "\n\n\n";
    }

}
