/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author Asus
 */
public class Service {
      private int idService;
      private int idMembre;
      private int idJardinier;
      private String nomService;
      private int nbheures;
      private int nbjours;
      private float prix;

    public Service(int idService, int idMembre, int idJardinier, String nomService, int nbheures, int nbjours, float prix) {
        this.idService = idService;
        this.idMembre = idMembre;
        this.idJardinier = idJardinier;
        this.nomService = nomService;
        this.nbheures = nbheures;
        this.nbjours = nbjours;
        this.prix = prix;
    }

    public Service(){}

    @Override
    public String toString() {
        return "Service{" + "idService=" + idService + ", idMembre=" + idMembre + ", idJardinier=" + idJardinier + ", nomService=" + nomService + ", nbheures=" + nbheures + ", nbjours=" + nbjours + ", prix=" + prix + '}';
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdJardinier() {
        return idJardinier;
    }

    public void setIdJardinier(int idJardinier) {
        this.idJardinier = idJardinier;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public int getNbheures() {
        return nbheures;
    }

    public void setNbheures(int nbheures) {
        this.nbheures = nbheures;
    }

    public int getNbjours() {
        return nbjours;
    }

    public void setNbjours(int nbjours) {
        this.nbjours = nbjours;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
}
