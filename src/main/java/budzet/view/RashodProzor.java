/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package budzet.view;

import budzet.controller.ObradaOsoba;
import budzet.controller.ObradaRashod;
import budzet.controller.ObradaVrsta;
import budzet.model.Osoba;
import budzet.model.Vrsta;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Ivan
 */
public class RashodProzor extends javax.swing.JFrame {
    
    private ObradaRashod obrada;

    /**
     * Creates new form RashodProzor
     */
    public RashodProzor() {
        initComponents();
        postavke();
        
        
        
        
    }
    
    private void postavke(){
        ucitajOsobe();
        ucitajVrste();
        
        obrada = new ObradaRashod();
        TablicaModelRashod m= new TablicaModelRashod(new ObradaRashod().read());
        jTable1.setModel(m);
        
        
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
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
        new ObradaOsoba<Osoba>().read().forEach(s-> {
            ms.addElement((Osoba) s);
        });
        cmbPlatitelj.setModel(ms);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        cmbPlatitelj = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtVrsta = new javax.swing.JTextField();
        txtIznos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbVrsta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

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

        jLabel4.setText("Datum primanja");

        jLabel3.setText("Iznos");

        cmbVrsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVrstaActionPerformed(evt);
            }
        });

        jLabel2.setText("Platitelj");

        jButton1.setText("Kreiraj");

        jButton2.setText("Promjeni");

        jButton3.setText("Obriši");

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
                                .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
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
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
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

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Osoba> cmbPlatitelj;
    private javax.swing.JComboBox<Vrsta> cmbVrsta;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIznos;
    private javax.swing.JTextField txtVrsta;
    // End of variables declaration//GEN-END:variables
}
