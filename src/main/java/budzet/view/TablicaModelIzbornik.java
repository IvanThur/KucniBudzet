/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.view;

import budzet.model.Stavka;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivan
 */
public class TablicaModelIzbornik extends AbstractTableModel {

    private List<Stavka> list = new ArrayList();
    
    private String[] columnNames = {"Naziv", "Osoba", "Iznos",
        "Datum.time"};

    public TablicaModelIzbornik(List<Stavka> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stavka s = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getVrsta().getNaziv();
            case 1:
                return s.getOsoba();
            case 2:
                return s.getIznos();
            case 3:
                return s.getDatum();

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return BigDecimal.class;
            case 3:
                return Date.class;
        }
        return null;
    }
    
    

}
