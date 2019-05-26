/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author AKTHEM
 */
public class catalogue {
    private int id;
    private String nom;
    private int prix;
    private String image;
    private int quantite;
        private String categorie;

    public catalogue() {
    }

    public catalogue(int id, String nom, int prix, String image, int quantite, String categorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    

    
    @Override
    public String toString() {
        return "Produit N°="+ id +"\nProduit est :  " + nom +"\n"+ "Prix  :  " + prix +"\n"+ "Quantité : " + quantite +"\n"+"Categorie : "+categorie+ "\n\n\n";
    }
    
    
}
