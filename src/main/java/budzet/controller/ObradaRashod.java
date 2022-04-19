/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.controller;

import budzet.model.Prihod;
import budzet.model.Rashod;
import budzet.util.MojException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class ObradaRashod extends Obrada<Rashod> {

    @Override
    public List<Rashod> read() {
        return session.createQuery("from Rashod").list();
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
        if(entitet.getIznos()==null){
            throw new MojException("Cijena mora biti unesen i veća od 0");
        }
    }

}
