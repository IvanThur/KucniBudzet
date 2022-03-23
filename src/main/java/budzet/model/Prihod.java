/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ivan
 */
@Entity
public class Prihod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sifra;
    @ManyToOne
    private Vrsta vrsta;
    @ManyToOne
    private Osoba primatelj;

    private Date datum;
    private BigDecimal iznos;
    

    public Vrsta getVrsta() {
        return vrsta;
    }

    public void setVrsta(Vrsta vrsta) {
        this.vrsta = vrsta;
    }

    public Osoba getPrimatelj() {
        return primatelj;
    }

    public void setPrimatelj(Osoba primatelj) {
        this.primatelj = primatelj;
    }

    public Date getDatumPlacanja() {
        return datum;
    }

    public void setDatumPlacanja(Date datumPlacanja) {
        this.datum = datumPlacanja;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

}
