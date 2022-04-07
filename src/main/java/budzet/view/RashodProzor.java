/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package budzet.view;

import budzet.controller.ObradaOsoba;
import budzet.controller.ObradaRashod;
import budzet.controller.ObradaVrsta;
import budzet.model.Osoba;
import budzet.model.Rashod;
import budzet.model.Stavka;
import budzet.model.Vrsta;
import budzet.util.MojException;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan
 */
public class RashodProzor extends javax.swing.JFrame {

    private DefaultTableModel m;
    private ObradaRashod obrada;
    private DecimalFormat nf;
    private SimpleDateFormat df, fd;
    private Rashod rashod;

    /**
     * Creates new form RashodProzor
     */
    public RashodProzor() {
        initComponents();
        postavke();

    }

    private void postavke() {
        ucitajOsobe();
        ucitajVrste();

        ucitaj();

        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
    }

    private void ucitaj() {
        obrada = new ObradaRashod();
        TablicaModelRashod m = new TablicaModelRashod(new ObradaRashod().read());
        tbRashod.setModel(m);
    }

    private void ucitajVrste() {
        DefaultComboBoxModel<Vrsta> ms = new DefaultComboBoxModel<>();
        Vrsta v = new Vrsta();
        v.setSifra(Long.valueOf(0));
        v.setNaziv("-");
        ms.addElement(v);
        new ObradaVrsta().read().forEach(s -> {
            ms.addElement(s);
        });
        cmbVrsta.setModel(ms);
    }

    private void ucitajOsobe() {
        DefaultComboBoxModel<Osoba> ms = new DefaultComboBoxModel<>();
        Osoba o = new Osoba();
        o.setSifra(Long.valueOf(0));
        o.setIme("nije");
        o.setPrezime("odabrano");
        ms.addElement(o);
        new ObradaOsoba<Osoba>().read().forEach(s -> {
            ms.addElement((Osoba) s);
        });
        cmbPlatitelj.setModel(ms);
    }

    private void preuzmiVrijednosti() {
        var e = obrada.getEntitet();
        e.setVrsta((Vrsta) cmbVrsta.getSelectedItem());
        e.setOsoba((Osoba) cmbPlatitelj.getSelectedItem());
        e.setIznos(new BigDecimal(Double.parseDouble(txtIznos.getText())));
        if (dpDatum.getDate() != null) {
            e.setDatum(
                    Date.from(
                            dpDatum.getDate().atStartOfDay().atZone(
                                    ZoneId.systemDefault()
                            ).toInstant()
                    )
            );
        } else {
            e.setDatum(null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRashod = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        dpDatum = new com.github.lgooddatepicker.components.DatePicker();
        cmbPlatitelj = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtVrsta = new javax.swing.JTextField();
        txtIznos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbVrsta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnKreiraj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbRashod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vrsta", "Primatelj", "Iznos", "Datum placanja", "Kolicina"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbRashod);

        cmbPlatitelj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPlatiteljActionPerformed(evt);
            }
        });

        jLabel1.setText("Naziv rashoda");

        txtVrsta.setText("Upiši novi naziv");
        txtVrsta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtVrstaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVrstaFocusLost(evt);
            }
        });

        txtIznos.setPreferredSize(new java.awt.Dimension(32, 24));

        jLabel4.setText("Datum placanja");

        jLabel3.setText("Iznos");

        cmbVrsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVrstaActionPerformed(evt);
            }
        });

        jLabel2.setText("Platitelj");

        btnKreiraj.setText("Kreiraj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtVrsta)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(cmbPlatitelj, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnKreiraj)
                                .addGap(18, 18, 18)
                                .addComponent(btnPromjeni)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisi)))
                        .addGap(0, 9, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPlatitelj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKreiraj)
                    .addComponent(btnPromjeni)
                    .addComponent(btnObrisi))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbVrstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVrstaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVrstaActionPerformed

    private void txtVrstaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVrstaFocusLost
        txtVrsta.setText("Upiši novi naziv");
    }//GEN-LAST:event_txtVrstaFocusLost

    private void txtVrstaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVrstaFocusGained
        txtVrsta.setText("");
    }//GEN-LAST:event_txtVrstaFocusGained

    private void cmbPlatiteljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPlatiteljActionPerformed

    }//GEN-LAST:event_cmbPlatiteljActionPerformed

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        try {
            if (obrada.getEntitet() == null) {
                obrada.setEntitet(new Rashod());
            }
            preuzmiVrijednosti();
            obrada.create();
            ucitaj();

        } catch (MojException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        List<Rashod> entiteti = obrada.read();
        var red = tbRashod.getSelectedRow();
        obrada.setEntitet(entiteti.get(red));
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }

        try {

            preuzmiVrijednosti();
            obrada.update();
            JOptionPane.showMessageDialog(getRootPane(), "Promjenjeno");
            ucitaj();

        } catch (MojException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        List<Rashod> entiteti = obrada.read();
        var red = tbRashod.getSelectedRow();
        obrada.setEntitet(entiteti.get(red));
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }

        if (JOptionPane.showConfirmDialog(
                getRootPane(),
                "Sigurno obrisati ?", "Brisanje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
            return;
        }

        try {

            obrada.delete();
            JOptionPane.showMessageDialog(getRootPane(), "Obrisano");
            ucitaj();
        } catch (MojException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Osoba> cmbPlatitelj;
    private javax.swing.JComboBox<Vrsta> cmbVrsta;
    private com.github.lgooddatepicker.components.DatePicker dpDatum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRashod;
    private javax.swing.JTextField txtIznos;
    private javax.swing.JTextField txtVrsta;
    // End of variables declaration//GEN-END:variables
}
