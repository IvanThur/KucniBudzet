/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.controller;

import budzet.model.Prihod;
import budzet.util.MojException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class ObradaPrihod extends Obrada<Prihod> {

    @Override
    public List<Prihod> read() {
        return session.createQuery("from Prihod").list();
    }

    @Override
    protected void kontrolaCreate() throws MojException {
        KontrolaIznos();
        
    }

    @Override
    protected void kontrolaUpdate() throws MojException {
        KontrolaIznos();
    }

    @Override
    protected void kontrolaDelete() throws MojException {

    }

    private void KontrolaIznos() throws MojException{
        if(entitet.getIznos()==null||entitet.getIznos().compareTo(BigDecimal.ZERO)<0){
            throw new MojException("Iznos mora biti unesen i veći od 0");
        }
    }

}
