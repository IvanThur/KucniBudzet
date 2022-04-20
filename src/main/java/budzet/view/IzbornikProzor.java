/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package budzet.view;

import budzet.controller.Obrada;
import budzet.controller.ObradaPrihod;
import budzet.controller.ObradaRashod;
import budzet.model.Prihod;
import budzet.model.Rashod;
import budzet.model.Stavka;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan
 */
public class IzbornikProzor extends javax.swing.JFrame {

    private DefaultTableModel m;
    private Obrada obrada;
    private DecimalFormat nf;
    private ObradaPrihod obradaprihod;
    private ObradaRashod obradarashod;

    private List<Stavka> stavka;

    /**
     * Creates new form IzbornikProzor
     */
    public IzbornikProzor() {
        initComponents();
        postavke();
    }

    private void postavke() {

        obradaprihod = new ObradaPrihod();
        obradarashod = new ObradaRashod();

        setTitle("Izbornik");

        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dpPocetak.setSettings(dps);
        DatePickerSettings dpss = new DatePickerSettings(new Locale("hr", "HR"));
        dpss.setFormatForDatesCommonEra("dd.MM.yyyy");
        dpss.setTranslationClear("Očisti");
        dpss.setTranslationToday("Danas");
        dpKraj.setSettings(dpss);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("hr", "HR"));
        nf = new DecimalFormat("###,###.00", symbols);

        dpPocetak.setDate(LocalDate.of(2015, 1, 1));
        dpKraj.setDateToToday();
        ucitaj();

    }

    private void ucitaj() {

        List<Stavka> stavka = new ArrayList<>();
        List<Prihod> prihod = obradaprihod.read();
        List<Rashod> rashod = obradarashod.read();

        /*
         * if (txtTrazi.getText().equals("Upiši naziv") ||
         * txtTrazi.getText().isEmpty()) { stavka.addAll(prihod);
         * stavka.addAll(rashod); }
         */
        for (Prihod p : prihod) {
            if (chbFilter.isSelected() && chbDatum.isSelected()) {
                if (p.getVrsta().getNaziv().toLowerCase().contains(txtTrazi.getText().toLowerCase()) && p.getDatum().after(datePickerToDate(dpPocetak)) && p.getDatum().before(datePickerToDate(dpKraj))) {
                    stavka.add(p);
                }
            }
            if (chbFilter.isSelected() && !chbDatum.isSelected()) {
                if (p.getVrsta().getNaziv().toLowerCase().contains(txtTrazi.getText().toLowerCase())) {
                    stavka.add(p);
                }
            }

            if ((chbDatum.isSelected() && !chbFilter.isSelected()) && p.getDatum().after(datePickerToDate(dpPocetak)) && p.getDatum().before(datePickerToDate(dpKraj))) {
                stavka.add(p);
            }

        }

        for (Rashod r : rashod) {
            if (chbFilter.isSelected() && chbDatum.isSelected()) {
                if (r.getVrsta().getNaziv().toLowerCase().contains(txtTrazi.getText().toLowerCase()) && r.getDatum().after(datePickerToDate(dpPocetak)) && r.getDatum().before(datePickerToDate(dpKraj))) {
                    stavka.add(r);
                }
            }
            if (chbFilter.isSelected() && !chbDatum.isSelected()) {
                if (r.getVrsta().getNaziv().toLowerCase().contains(txtTrazi.getText().toLowerCase())) {
                    stavka.add(r);
                }
            }

            if ((chbDatum.isSelected() && !chbFilter.isSelected()) && r.getDatum().after(datePickerToDate(dpPocetak)) && r.getDatum().before(datePickerToDate(dpKraj))) {
                stavka.add(r);
            }
        }

        var z = BigDecimal.ZERO;
        for (Stavka s : stavka) {
            z = s.getIznos().add(z);
        }

        txtUkupno.setText(z.toString());

        Collections.sort(stavka, (Stavka o1, Stavka o2) -> o2.getDatum().compareTo(o1.getDatum()));
        TablicaModelIzbornik m = new TablicaModelIzbornik(stavka);

        tbPregled.setModel(m);

    }

    private Date datePickerToDate(DatePicker datePicker) {
        if (datePicker.getDate() != null) {
            return Date.from(
                    datePicker.getDate().atStartOfDay().atZone(
                            ZoneId.systemDefault()).toInstant()
            );
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPregled = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTrazi = new javax.swing.JTextField();
        dpPocetak = new com.github.lgooddatepicker.components.DatePicker();
        dpKraj = new com.github.lgooddatepicker.components.DatePicker();
        btnOsvjezi = new javax.swing.JButton();
        txtUkupno = new javax.swing.JTextField();
        chbFilter = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chbDatum = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mPrihod = new javax.swing.JMenu();
        mRashod = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbPregled.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbPregled);

        jLabel1.setText("Traži");

        txtTrazi.setText("Upiši naziv");
        txtTrazi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTraziFocusGained(evt);
            }
        });
        txtTrazi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTraziKeyTyped(evt);
            }
        });

        btnOsvjezi.setText("Osvježi");
        btnOsvjezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsvjeziActionPerformed(evt);
            }
        });

        chbFilter.setText("Filtriraj po nazivu");
        chbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbFilterActionPerformed(evt);
            }
        });

        jLabel2.setText("Datum početka");

        jLabel3.setText("Datum kraja");

        chbDatum.setText("Traži po datumu");

        jLabel4.setText("Ukupno");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        mPrihod.setText("Prihod");
        mPrihod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mPrihodMouseClicked(evt);
            }
        });
        jMenuBar1.add(mPrihod);

        mRashod.setText("Rashod");
        mRashod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mRashodMouseClicked(evt);
            }
        });
        jMenuBar1.add(mRashod);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chbFilter)))
                        .addGap(179, 179, 179))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOsvjezi)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dpPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dpKraj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chbDatum)))
                        .addGap(9, 9, 9))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbFilter))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dpPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpKraj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbDatum))
                        .addGap(292, 292, 292)
                        .addComponent(btnOsvjezi)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mPrihodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mPrihodMouseClicked
        new PrihodProzor().setVisible(true);
    }//GEN-LAST:event_mPrihodMouseClicked

    private void mRashodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mRashodMouseClicked
        new RashodProzor().setVisible(true);
    }//GEN-LAST:event_mRashodMouseClicked

    private void txtTraziFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTraziFocusGained
        txtTrazi.setText("");
    }//GEN-LAST:event_txtTraziFocusGained

    private void btnOsvjeziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsvjeziActionPerformed
        ucitaj();
    }//GEN-LAST:event_btnOsvjeziActionPerformed

    private void txtTraziKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTraziKeyTyped
        ucitaj();
    }//GEN-LAST:event_txtTraziKeyTyped

    private void chbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbFilterActionPerformed

    }//GEN-LAST:event_chbFilterActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOsvjezi;
    private javax.swing.JCheckBox chbDatum;
    private javax.swing.JCheckBox chbFilter;
    private com.github.lgooddatepicker.components.DatePicker dpKraj;
    public com.github.lgooddatepicker.components.DatePicker dpPocetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mPrihod;
    private javax.swing.JMenu mRashod;
    private javax.swing.JTable tbPregled;
    private javax.swing.JTextField txtTrazi;
    private javax.swing.JTextField txtUkupno;
    // End of variables declaration//GEN-END:variables

}
