/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;




/**
 *
 * @author Ala
 */
public class Voucher {
    private String voucherCode;
    private int nbUse;
    private int maxUse;
    private int rate;

    public Voucher(String voucherCode, int nbUse, int maxUse, int rate) {
        this.voucherCode = voucherCode;
        this.nbUse = nbUse;
        this.maxUse = maxUse;
        this.rate = rate;
    }

    public Voucher() {
    }

     
    
    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public int getNbUse() {
        return nbUse;
    }

    public void setNbUse(int nbUse) {
        this.nbUse = nbUse;
    }

    public int getMaxUse() {
        return maxUse;
    }

    public void setMaxUse(int maxUse) {
        this.maxUse = maxUse;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
        public String toString() {
        return "\nCode = "+ voucherCode + "\nRate=" + rate + "\n Max Use=" + maxUse + "\n\n\n";
    }
    
    
    
}
