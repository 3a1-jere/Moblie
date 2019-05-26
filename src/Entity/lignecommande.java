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
public class lignecommande {
   
    private int id_lignecommande;
    private int id_produit;
     private String nom_produit;
     private float prix_produit;
     private String image;     
    private int Quantite_lignecommande;
    private float prix_panier;

    public lignecommande() {
    }

    public lignecommande(int id_produit,String image, String nom_produit, float prix_produit, int Quantite_lignecommande, float prix_panier) {
        this.id_produit = id_produit;
        this.image=image;
        this.nom_produit = nom_produit;
        this.prix_produit = prix_produit;
      
        this.Quantite_lignecommande = Quantite_lignecommande;
        this.prix_panier=prix_panier;
    }

    public int getId_lignecommande() {
        return id_lignecommande;
    }

    public void setId_lignecommande(int id_lignecommande) {
        this.id_lignecommande = id_lignecommande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public float getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(float prix_produit) {
        this.prix_produit = prix_produit;
    }


    public int getQuantite_lignecommande() {
        return Quantite_lignecommande;
    }

    public void setQuantite_lignecommande(int Quantite_lignecommande) {
        this.Quantite_lignecommande = Quantite_lignecommande;
    }

    public float getPrix_panier() {
        return prix_panier;
    }

    public void setPrix_panier(float prix_panier) {
        this.prix_panier = prix_panier;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    

     public String toString() {
        return "\nProduit N° " + id_lignecommande + "\n Nom=" + nom_produit + "\n Prix=" + prix_produit +"TND"+ "\nQuantite=" + Quantite_lignecommande + "\nTotal="+ prix_panier +"TND"+ "\n\n";
    }

}
