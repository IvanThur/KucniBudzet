/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.controller;

import budzet.model.Vrsta;
import budzet.util.MojException;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class ObradaVrsta extends Obrada<Vrsta>{

    @Override
    public List<Vrsta> read() {
        return session.createQuery("from Vrsta").list();
    }

    @Override
    protected void kontrolaCreate() throws MojException {
        KontrolaIme();
    }

    @Override
    protected void kontrolaUpdate() throws MojException {
        KontrolaIme();
    }

    @Override
    protected void kontrolaDelete() throws MojException {
        
    }

    private void KontrolaIme() throws MojException {
       if(!entitet.getNaziv().matches("\\p{L}+")){
            throw new MojException("Ime smije sadržavati samo slova");
       }
    }
    
}
