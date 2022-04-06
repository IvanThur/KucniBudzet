/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.model;

import javax.persistence.Entity;

/**
 *
 * @author Ivan
 */
@Entity
public class Vrsta extends Entitet{

    
    private String naziv;
    private boolean prihod;

    public boolean isPrihod() {
        return prihod;
    }

    public void setPrihod(boolean prihod) {
        this.prihod = prihod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String vrsta) {
        this.naziv = vrsta;
    }
     @Override
    public String toString(){
        return naziv;
    }

}
