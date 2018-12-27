package ClassesInterface;

import Classes.*;

/**
 *Classe associada ao menu principal de um funcionário
 */
public class MenuPrincipalFuncionario extends javax.swing.JFrame {

    /**Variável de instância que contêm informação sobe o sistema*/
    private ConfiguraFacil cf;
    /**Construtor vazio*/
    public MenuPrincipalFuncionario() {
        initComponents();
    }
    /**Construtor parameterizado
     * @param cf Contêm informação sobe o sistema
     */
    public MenuPrincipalFuncionario(ConfiguraFacil cf){
        this();
        this.cf = cf;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdicionarStock = new javax.swing.JToggleButton();
        Carro = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        StockDisponivel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AdicionarStock.setText("AdicionarStock");
        AdicionarStock.setToolTipText("Adicionar peças");
        AdicionarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarStockActionPerformed(evt);
            }
        });

        Carro.setText("Carro Pronto");
        Carro.setToolTipText("Mudar o estado do carro no caso de estar pronto");
        Carro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Harlow Solid Italic", 0, 18)); // NOI18N
        jLabel1.setText(" Sitio nº1 de compra de carros online");

        StockDisponivel.setText("Stock Disponível");
        StockDisponivel.setToolTipText("Verificar o stock ");
        StockDisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockDisponivelActionPerformed(evt);
            }
        });

        jButton1.setText("Carros em Fila");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(StockDisponivel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Carro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdicionarStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AdicionarStock, Carro, StockDisponivel, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(143, 143, 143)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdicionarStock)
                    .addComponent(Carro)
                    .addComponent(StockDisponivel)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que permite ao funcionário adicionar peças
     * @param evt Evento associado ao botão adicionar stock
     */
    private void AdicionarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarStockActionPerformed
        AdicionaStock as = new AdicionaStock(this.cf);
        as.setVisible(true);
    }//GEN-LAST:event_AdicionarStockActionPerformed
    /**
     * Método que permite ao funcinário colocar um carro pronto
     * @param evt Evento associado ao botão carro pronto
     */
    private void CarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarroActionPerformed
        CarroPronto cc = new CarroPronto(this.cf);
        cc.setVisible(true);
    }//GEN-LAST:event_CarroActionPerformed
    /**
     * Método que permite ao funcionário ver o stock disponível na fábrica, abrindo uma nova janela
     * @param evt Evento associado ao botão stock disponivel
     */
    private void StockDisponivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockDisponivelActionPerformed
        StockDisponivel cc = new StockDisponivel(this.cf);
        cc.setVisible(true);
    }//GEN-LAST:event_StockDisponivelActionPerformed
    /**
     * Método que permite ao funcinário ver os carros em produção, abrindo uma janela nova
     * @param evt Evento associado ao botão carros em producao
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CarrosEmFila cc = new CarrosEmFila(this.cf);
        cc.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton AdicionarStock;
    private javax.swing.JToggleButton Carro;
    private javax.swing.JButton StockDisponivel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
