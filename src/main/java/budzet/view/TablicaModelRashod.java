/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.view;

import budzet.model.Rashod;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivan
 */
public class TablicaModelRashod extends AbstractTableModel {

    private List<Rashod> rashod;

    private final String[] tableHeaders = {"Naziv", "Osoba", "Iznos","Datum","Količina"};

    @Override
    public String getColumnName(int columnIndex) {
        return tableHeaders[columnIndex];
    }

    public TablicaModelRashod(List<Rashod> rashod) {
        this.rashod = rashod;
    }

    @Override
    public int getRowCount() {
        return rashod == null ? 0 : rashod.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rashod p = rashod.get(rowIndex);
        Object value = "??";
        switch (columnIndex) {
            case 0 ->
                value = p.getVrsta().getNaziv();
            case 1 ->
                value = p.getOsoba();
            case 2 ->
                value = p.getIznos();
            case 3 ->
                value = p.getDatum();
            case 4 ->
                value = p.getKolicina();
        }
        return value;
    }

    public Rashod getRashodAt(int red) {
        return rashod.get(red);
    }

}
