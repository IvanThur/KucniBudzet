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
import budzet.model.Vrsta;
import budzet.util.HibernateUtil;
import budzet.util.MojException;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author Ivan
 */
public class RashodProzor extends javax.swing.JFrame {

    private DefaultTableModel m;
    private ObradaRashod obrada;
    private DecimalFormat nf;
    

    /**
     * Creates new form RashodProzor
     */
    public RashodProzor() {
        initComponents();

        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dpDatum.setSettings(dps);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("hr", "HR"));
        nf = new DecimalFormat("###,###.00", symbols);

        postavke();

    }

    private void postavke() {
        ucitajOsobe();
        ucitajVrste();
        ucitaj();

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
        try {
            e.setIznos(new BigDecimal(nf.parse(txtIznos.getText()).toString()));
            e.setKolicina(new BigDecimal(nf.parse(txtKolicina.getText()).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(RashodProzor.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        btnDodajVrsta = new javax.swing.JButton();
        txtIme = new javax.swing.JTextField();
        btnDodajOsoba = new javax.swing.JButton();
        txtPrezime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();

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

        btnDodajVrsta.setText("Dodaj");
        btnDodajVrsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajVrstaActionPerformed(evt);
            }
        });

        txtIme.setText("Upiši Ime");
        txtIme.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtImeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtImeFocusLost(evt);
            }
        });

        btnDodajOsoba.setText("Dodaj");
        btnDodajOsoba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajOsobaActionPerformed(evt);
            }
        });

        txtPrezime.setText("Upiši Prezime");
        txtPrezime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrezimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrezimeFocusLost(evt);
            }
        });

        jLabel5.setText("Količina");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDodajVrsta))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnKreiraj)
                                .addGap(18, 18, 18)
                                .addComponent(btnPromjeni)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisi))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtKolicina))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(113, 113, 113)
                                    .addComponent(jLabel5))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbPlatitelj, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDodajOsoba)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajVrsta))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbPlatitelj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDodajOsoba)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(27, Short.MAX_VALUE))
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
        if (txtVrsta.getText().isBlank()) {
            txtVrsta.setText("Upiši novi naziv");
        }
    }//GEN-LAST:event_txtVrstaFocusLost

    private void txtVrstaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVrstaFocusGained
        txtVrsta.setText("");
    }//GEN-LAST:event_txtVrstaFocusGained

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

    private void btnDodajVrstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajVrstaActionPerformed
        Session session = HibernateUtil.getSession(); 
        Vrsta v;
        v = new Vrsta();
        v.setNaziv(txtVrsta.getText());
        v.setPrihod(false);
        session.save(v);
        ucitajVrste();
        System.out.println("Kreirao vrstu: " + v.getNaziv());


    }//GEN-LAST:event_btnDodajVrstaActionPerformed

    private void txtImeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImeFocusGained
        txtIme.setText("");
    }//GEN-LAST:event_txtImeFocusGained

    private void btnDodajOsobaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajOsobaActionPerformed
        
    }//GEN-LAST:event_btnDodajOsobaActionPerformed

    private void txtPrezimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrezimeFocusGained
        txtPrezime.setText("");
    }//GEN-LAST:event_txtPrezimeFocusGained

    private void txtImeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImeFocusLost
        if (txtIme.getText().isBlank()) {
            txtIme.setText("Upiši ime");
        }
    }//GEN-LAST:event_txtImeFocusLost

    private void txtPrezimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrezimeFocusLost
        if (txtPrezime.getText().isBlank()) {
            txtPrezime.setText("Upiši prezime");
        }
    }//GEN-LAST:event_txtPrezimeFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajOsoba;
    private javax.swing.JButton btnDodajVrsta;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRashod;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtIznos;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtVrsta;
    // End of variables declaration//GEN-END:variables
}
