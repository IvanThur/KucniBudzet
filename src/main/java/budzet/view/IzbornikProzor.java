/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package budzet.view;

import budzet.controller.Obrada;
import budzet.model.Stavka;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan
 */
public class IzbornikProzor extends javax.swing.JFrame {
    
    private Obrada obrada;
    private DefaultTableModel m;

    /**
     * Creates new form IzbornikProzor
     */
    public IzbornikProzor() {
        initComponents();
        postavke();
    }
    private void postavke(){
        setTitle("Izbornik moje super duper app");
        
        
    }
    
    private void ucitaj() {

        List<Stavka> entiteti = obrada.read();
        
        Object[] red = new Object[5];

        for (int i = 0; i < entiteti.size(); i++) {
            red[0] = entiteti.get(i).getVrsta().getNaziv();
            red[1] = entiteti.get(i).getOsoba().getIme();
            red[2] = entiteti.get(i).getOsoba().getPrezime();
            red[3] = entiteti.get(i).getIznos();
            red[4] = entiteti.get(i).getDatum();
            m.addRow(red);
        }
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
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mPrihod = new javax.swing.JMenu();
        mRashod = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    /**
     * @param args the command line arguments
     */
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu mPrihod;
    private javax.swing.JMenu mRashod;
    // End of variables declaration//GEN-END:variables

}
