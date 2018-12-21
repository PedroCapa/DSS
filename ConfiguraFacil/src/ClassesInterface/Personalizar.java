/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesInterface;

import Classes.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;

/**
 *
 * @author pmcca
 */
public class Personalizar extends javax.swing.JFrame {

    private ConfiguraFacil cf;
    private Cliente c;
    private Modelo m;
    
    public Personalizar() {
        initComponents();
    }
    
    public Personalizar(ConfiguraFacil cf, Cliente c, Modelo m){
        this();
        this.cf = cf;
        this.c = c;
        this.m = m;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cor = new javax.swing.ButtonGroup();
        Motor = new javax.swing.ButtonGroup();
        Jantes = new javax.swing.ButtonGroup();
        Estofos = new javax.swing.ButtonGroup();
        spoiler = new javax.swing.JRadioButton();
        automatico = new javax.swing.JRadioButton();
        escape = new javax.swing.JRadioButton();
        teto = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        climatizacao = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        Confirmar = new javax.swing.JButton();
        Voltar = new javax.swing.JButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        vidrosEscuros = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        spoiler.setText("Spoiler");

        automatico.setText("Condutor Automatico");

        escape.setText("Escape Regulavel");
        escape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escapeActionPerformed(evt);
            }
        });

        teto.setText("Teto de Abir");

        jLabel1.setFont(new java.awt.Font("Harlow Solid Italic", 0, 18)); // NOI18N
        jLabel1.setText("Motor");

        Motor.add(jRadioButton5);
        jRadioButton5.setText("177 cu in ");

        Motor.add(jRadioButton6);
        jRadioButton6.setText("Boss 302 V8");

        Motor.add(jRadioButton7);
        jRadioButton7.setText(" 385 engine");

        Motor.add(jRadioButton8);
        jRadioButton8.setText("V 12 ");

        Motor.add(jRadioButton9);
        jRadioButton9.setText("225 Horsepower 312 Cubic Inch V8 Engine");

        Motor.add(jRadioButton10);
        jRadioButton10.setText("2.3 EcoBoost 290cv ");

        Motor.add(jRadioButton11);
        jRadioButton11.setText("Lynx");

        jLabel2.setFont(new java.awt.Font("Harlow Solid Italic", 0, 18)); // NOI18N
        jLabel2.setText(" Extras");

        jLabel3.setFont(new java.awt.Font("Harlow Solid Italic", 0, 18)); // NOI18N
        jLabel3.setText("Cor");

        Cor.add(jRadioButton12);
        jRadioButton12.setText("Branco");

        Cor.add(jRadioButton13);
        jRadioButton13.setText("Vermelho");

        Cor.add(jRadioButton14);
        jRadioButton14.setText("Azul");

        Cor.add(jRadioButton15);
        jRadioButton15.setText("Preto");

        climatizacao.setText("Sistema de Climatização");

        jLabel5.setFont(new java.awt.Font("Harlow Solid Italic", 0, 18)); // NOI18N
        jLabel5.setText("Jantes");

        Jantes.add(jRadioButton19);
        jRadioButton19.setText("Liga Leve");

        Jantes.add(jRadioButton20);
        jRadioButton20.setText("Ferro");

        jLabel6.setFont(new java.awt.Font("Harlow Solid Italic", 0, 18)); // NOI18N
        jLabel6.setText(" Estofos");

        Confirmar.setText("Confirmar");
        Confirmar.setToolTipText("Confirmar compra");
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });

        Voltar.setText("Voltar");
        Voltar.setToolTipText("Voltar atrás");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        Estofos.add(jRadioButton21);
        jRadioButton21.setText("Couro Cognac");
        jRadioButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton21ActionPerformed(evt);
            }
        });

        Estofos.add(jRadioButton22);
        jRadioButton22.setText("Couro Alcantara");

        Estofos.add(jRadioButton23);
        jRadioButton23.setText("Couro Recaro  Red");

        vidrosEscuros.setText("Vidros Escurecidos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Confirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton6)
                                .addGap(2, 2, 2)
                                .addComponent(jRadioButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton11))
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton20))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton23))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton15))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton10)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(escape)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(climatizacao))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spoiler)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(automatico)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vidrosEscuros)
                            .addComponent(teto))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {automatico, escape, spoiler, teto});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton12)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14)
                    .addComponent(jRadioButton15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton19)
                    .addComponent(jRadioButton20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton21)
                    .addComponent(jRadioButton22)
                    .addComponent(jRadioButton23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teto)
                    .addComponent(escape)
                    .addComponent(climatizacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spoiler)
                    .addComponent(automatico)
                    .addComponent(vidrosEscuros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Confirmar)
                    .addComponent(Voltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private List<String> validaDados() {
        List<String> pecas = new ArrayList<>();
        for(Enumeration<AbstractButton> buttons = Cor.getElements(); buttons.hasMoreElements();){
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                pecas.add(button.getText());
            }
        }
        for(Enumeration<AbstractButton> buttons = Motor.getElements(); buttons.hasMoreElements();){
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                pecas.add(button.getText());
            }
        }
        for(Enumeration<AbstractButton> buttons = Jantes.getElements(); buttons.hasMoreElements();){
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                pecas.add(button.getText());
            }
        }
        for(Enumeration<AbstractButton> buttons = Estofos.getElements(); buttons.hasMoreElements();){
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                pecas.add(button.getText());
            }
        }
        if (pecas.size() < 4)
            javax.swing.JOptionPane.showMessageDialog(this, "Campos por preencher", "Dados incorretos", 0);
        if (this.escape.isSelected())
            pecas.add(this.escape.getText());
        if (this.climatizacao.isSelected())
            pecas.add(this.climatizacao.getText());
        if (this.teto.isSelected())
            pecas.add(this.teto.getText());
        if (this.spoiler.isSelected())
            pecas.add(this.spoiler.getText());
        if (this.automatico.isSelected())
            pecas.add(this.automatico.getText());
        if (this.vidrosEscuros.isSelected())
            pecas.add(this.vidrosEscuros.getText());
        return pecas;
    }    
    
    private void jRadioButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton21ActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VoltarActionPerformed

    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
        ConfirmaCompra cc = new ConfirmaCompra(this.cf, this.c, this.m, new Pacote(),this.cf.stringToPeca(validaDados()));
        cc.setVisible(true);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_ConfirmarActionPerformed

    private void escapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escapeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escapeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Personalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personalizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmar;
    private javax.swing.ButtonGroup Cor;
    private javax.swing.ButtonGroup Estofos;
    private javax.swing.ButtonGroup Jantes;
    private javax.swing.ButtonGroup Motor;
    private javax.swing.JButton Voltar;
    private javax.swing.JRadioButton automatico;
    private javax.swing.JRadioButton climatizacao;
    private javax.swing.JRadioButton escape;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JRadioButton spoiler;
    private javax.swing.JRadioButton teto;
    private javax.swing.JRadioButton vidrosEscuros;
    // End of variables declaration//GEN-END:variables
}
