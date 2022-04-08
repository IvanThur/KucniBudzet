/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.controller;

import budzet.model.Osoba;
import budzet.util.MojException;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class ObradaOsoba extends Obrada<Osoba> {

    @Override
    public List read() {
        return session.createQuery("from Osoba").list();
    }

    @Override
    protected void kontrolaCreate() throws MojException {
        kontrolaIme();
    }

    @Override
    protected void kontrolaUpdate() throws MojException {
        kontrolaIme();
    }

    @Override
    protected void kontrolaDelete() throws MojException {

    }

    private void kontrolaIme() throws MojException {
        if (!entitet.getIme().matches("\\p{L}+") || !entitet.getPrezime().matches("\\p{L}+")) {
            throw new MojException("Ime smije sadržavati samo slova");
        }

    }

}
