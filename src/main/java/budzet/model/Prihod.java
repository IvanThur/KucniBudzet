/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ivan
 */
@Entity
public class Prihod extends Entitet {

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
