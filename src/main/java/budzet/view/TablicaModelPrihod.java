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

    public TablicaModelPrihod(List<Prihod> prihodi) {
        this.prihodi = prihodi;
    }

    @Override
    public int getRowCount() {
        return prihodi == null ? 0 : prihodi.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prihod p = prihodi.get(rowIndex);
        Object value = "??";
        switch (columnIndex) {
            case 0 -> value = p.getVrsta().getNaziv();
            case 1 -> value = p.getOsoba().getIme();
            case 2 -> value = p.getOsoba().getPrezime();
            case 3 -> value = p.getIznos();
            case 4 -> value = p.getDatum();
        }
        return value;
    }
    
    public Prihod getPrihodAt(int red){
        return prihodi.get(red);
    }

}
