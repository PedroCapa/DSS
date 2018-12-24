/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesInterface;

import Classes.*;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import javax.swing.AbstractButton;

/**
 *
 * @author pmcca
 */
public class ComprarCarro extends javax.swing.JFrame {

    private ConfiguraFacil cf;
    private Cliente c;
    
    public ComprarCarro() {
        initComponents();
    }
    
    public ComprarCarro(ConfiguraFacil cf, Cliente c){
        this();
        this.cf = cf;
        this.c = c;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modelos = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        Pacote = new javax.swing.JButton();
        Otima = new javax.swing.JButton();
        Personalizar = new javax.swing.JButton();
        modelT = new javax.swing.JRadioButton();
        Boss302Mustang = new javax.swing.JRadioButton();
        Boss429Mustang = new javax.swing.JRadioButton();
        Thunderbird = new javax.swing.JRadioButton();
        Indigo = new javax.swing.JRadioButton();
        edge = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Harlow Solid Italic", 0, 18)); // NOI18N
        jLabel1.setText(" Selecione a melhor opção para si ");

        Pacote.setText("Escolher Pacote");
        Pacote.setToolTipText("Escolher um pacote de forma a ter um desconto");
        Pacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PacoteActionPerformed(evt);
            }
        });

        Otima.setText("Configuração ótima");
        Otima.setToolTipText("Melhor escolha de acordo com o seu orçamento");
        Otima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtimaActionPerformed(evt);
            }
        });

        Personalizar.setText("Personalizar");
        Personalizar.setToolTipText("Carro conforme o seu gosto");
        Personalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonalizarActionPerformed(evt);
            }
        });

        modelos.add(modelT);
        modelT.setText("Model T");
        modelT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelTActionPerformed(evt);
            }
        });

        modelos.add(Boss302Mustang);
        Boss302Mustang.setText("Boss 302 Mustang");
        Boss302Mustang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boss302MustangActionPerformed(evt);
            }
        });

        modelos.add(Boss429Mustang);
        Boss429Mustang.setText("Boss 429 Mustang");
        Boss429Mustang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boss429MustangActionPerformed(evt);
            }
        });

        modelos.add(Thunderbird);
        Thunderbird.setText("Thunderbird");
        Thunderbird.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThunderbirdActionPerformed(evt);
            }
        });

        modelos.add(Indigo);
        Indigo.setText("Indigo Concept");

        modelos.add(edge);
        edge.setText("Edge");
        edge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edgeActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Model T.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Ford 302 Mustang.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ThunderBird.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Indigo Concept.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Boss 429 mustang.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Edge.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Otima)
                .addGap(10, 10, 10)
                .addComponent(Pacote, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Personalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Indigo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(222, 222, 222)
                                .addComponent(edge, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boss302Mustang)
                                .addGap(222, 222, 222)
                                .addComponent(Thunderbird, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modelT, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(222, 222, 222)
                                .addComponent(Boss429Mustang))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modelT)
                    .addComponent(Boss429Mustang))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Boss302Mustang)
                    .addComponent(Thunderbird))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Indigo)
                    .addComponent(edge))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Otima)
                    .addComponent(Pacote)
                    .addComponent(Personalizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String validaDados() {
        String escolhido = "";
        for(Enumeration<AbstractButton> buttons = modelos.getElements(); buttons.hasMoreElements();){
             AbstractButton button = buttons.nextElement();

            if (button.isSelected())
                escolhido =  button.getText();
        }
        if (escolhido.equals(""))
            javax.swing.JOptionPane.showMessageDialog(this, "Campos por preencher", "Dados incorretos", 0);

        return escolhido;
    }
    
    private void Boss302MustangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boss302MustangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Boss302MustangActionPerformed

    private void modelTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelTActionPerformed

    private void edgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edgeActionPerformed

    private void Boss429MustangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boss429MustangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Boss429MustangActionPerformed

    private void ThunderbirdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThunderbirdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThunderbirdActionPerformed
    
    private void PacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PacoteActionPerformed
        if(!validaDados().equals("")){    
            EscolherPacote ep = new EscolherPacote(this.cf, this.c, this.cf.getModelos().get(validaDados()).clone());
            ep.setVisible(true);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_PacoteActionPerformed

    private void OtimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtimaActionPerformed
        if(!validaDados().equals("")){
            ConfiguracaoOtima co = new ConfiguracaoOtima(this.cf, this.c, this.cf.getModelos().get(validaDados()).clone());
            co.setVisible(true);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_OtimaActionPerformed

    private void PersonalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonalizarActionPerformed
        if(!validaDados().equals("")){
            Personalizar p = new Personalizar(this.cf, this.c, this.cf.getModelos().get(validaDados()).clone());
            p.setVisible(true);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_PersonalizarActionPerformed

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
            java.util.logging.Logger.getLogger(ComprarCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComprarCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComprarCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComprarCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComprarCarro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Boss302Mustang;
    private javax.swing.JRadioButton Boss429Mustang;
    private javax.swing.JRadioButton Indigo;
    private javax.swing.JButton Otima;
    private javax.swing.JButton Pacote;
    private javax.swing.JButton Personalizar;
    private javax.swing.JRadioButton Thunderbird;
    private javax.swing.JRadioButton edge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton modelT;
    private javax.swing.ButtonGroup modelos;
    // End of variables declaration//GEN-END:variables
}
