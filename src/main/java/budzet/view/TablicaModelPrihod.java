/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.view;

import budzet.model.Prihod;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivan
 */
public class TablicaModelPrihod extends AbstractTableModel {

    private List<Prihod> prihodi;

    private final String[] tableHeaders = {"Naziv", "Osoba", "Iznos","Datum"};

    @Override
    public String getColumnName(int columnIndex) {
        return tableHeaders[columnIndex];
    }
    
    public TablicaModelPrihod(List<Prihod> prihodi) {
        this.prihodi = prihodi;
    }

    @Override
    public int getRowCount() {
        return prihodi == null ? 0 : prihodi.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prihod p = prihodi.get(rowIndex);
        Object value = "??";
        switch (columnIndex) {
            case 0 -> value = p.getVrsta().getNaziv();
            case 1 -> value = p.getOsoba();
            case 2 -> value = p.getIznos();
            case 3 -> value = p.getDatum();
        }
        return value;
    }
    
    public Prihod getPrihodAt(int red){
        return prihodi.get(red);
    }

}
