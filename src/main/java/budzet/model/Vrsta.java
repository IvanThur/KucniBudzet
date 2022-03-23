/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ivan
 */
@Entity
public class Vrsta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sifra;
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

}
