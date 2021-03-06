/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorgreati.view.equipamentos;

import br.com.vitorgreati.model.Projeto;
import br.com.vitorgreati.persistence.ProjetoDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vitor
 */
public class TelaSelecionarProjeto extends javax.swing.JFrame {

    private ProjetoDAO projetoDAO;
    private ArrayList<Projeto> projetos;
    
    private JFrame frameInvocador;
    
    public static final int ATUALIZAR = 0;
    public static final int EXCLUIR = 1;
    public static final int CONSULTA = 2;
    
    private int modo;
    /**
     * Creates new form TelaSelecionarProjeto
     */
    public TelaSelecionarProjeto(int modo, JFrame frameInvocador) {
        initComponents();
        projetoDAO = new ProjetoDAO();
        this.modo = modo;
        projetos = new ArrayList<>();
        
        this.frameInvocador = frameInvocador;
        
        switch(modo){
            case ATUALIZAR:
                setTitle("Selecionar projeto para atualizar");
                btSelecionar.setText("Atualizar...");
                break;
            case EXCLUIR:
                setTitle("Excluir projeto");
                btSelecionar.setText("Excluir");
                break;
            case CONSULTA:
                setTitle("Consultar projeto");
                btSelecionar.setText("Detalhes");
                btCancelar.setText("Fechar");
        }
        setLocationRelativeTo(null);
        
        this.projetos = projetoDAO.listar();
        DefaultTableModel model = (DefaultTableModel) tbProjetos.getModel();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        model.setRowCount(0);
        for(Projeto p : projetos){
            model.addRow(new String[]{p.getNome(),format.format(p.getDataInicio()),format.format(p.getDataFinal())});
        }
        if(model.getRowCount() == 0) ativarDesativarBotoesPelaTabela();
        
    }

    
    public TelaSelecionarProjeto(String busca, int modo, JFrame frameInvocador) {
        initComponents();
        projetoDAO = new ProjetoDAO();
        this.modo = modo;
        projetos = new ArrayList<>();
        
        this.frameInvocador = frameInvocador;
        this.modo = modo;
        
        switch(modo){
            case ATUALIZAR:
                setTitle("Selecionar projeto para atualizar");
                btSelecionar.setText("Atualizar...");
                break;
            case EXCLUIR:
                setTitle("Excluir projeto");
                btSelecionar.setText("Excluir");
                break;
            case CONSULTA:
                setTitle("Consultar projeto");
                btSelecionar.setText("Detalhes");
                btCancelar.setText("Fechar");
        }
        
        tfNome.setText(busca);
        
        setLocationRelativeTo(null);
        
        ArrayList<Projeto> projetos = projetoDAO.buscarOtimizado(busca, "");
        DefaultTableModel model = (DefaultTableModel) tbProjetos.getModel();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        model.setRowCount(0);
        for(Projeto p:projetos){
            model.addRow(new String[]{p.getNome(),format.format(p.getDataInicio()),format.format(p.getDataFinal())});
            this.projetos.add(p);
        }
        if(model.getRowCount()==0){ativarDesativarBotoesPelaTabela();}
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfParticipante = new javax.swing.JTextField();
        btLimpar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProjetos = new javax.swing.JTable();
        btCancelar = new javax.swing.JButton();
        btSelecionar = new javax.swing.JButton();

        jScrollPane2.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar projeto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        jLabel1.setText("Nome:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Participante:");

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tfNome))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(tfParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Projetos encontrados"));

        tbProjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Início", "Término"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProjetos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProjetosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProjetos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSelecionar.setText("Selecionar");
        btSelecionar.setEnabled(false);
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSelecionar)
                    .addComponent(btCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<Projeto> projetos = projetoDAO.buscarOtimizado(tfNome.getText(), tfParticipante.getText());
        DefaultTableModel model = (DefaultTableModel) tbProjetos.getModel();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        model.setRowCount(0);
        for(Projeto p:projetos){
            model.addRow(new String[]{p.getNome(),format.format(p.getDataInicio()),format.format(p.getDataFinal())});
            this.projetos.add(p);
        }
        if(model.getRowCount()==0){ativarDesativarBotoesPelaTabela();}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        switch(modo){
            case ATUALIZAR:
                new TelaEditorProjeto(projetos.get(tbProjetos.getSelectedRow()),this.frameInvocador).setVisible(true);
                //setEnabled(false);
                dispose();
                break;
            case EXCLUIR:
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir este projeto do sistema?", "Confirmar exclusão", 
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(opcao==0){
                    projetoDAO.excluir(projetos.get(tbProjetos.getSelectedRow()));
                    JOptionPane.showMessageDialog(null, "O projeto foi excluído.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    this.frameInvocador.setEnabled(true);
                    dispose();
                }
                break;
            case CONSULTA:
                new TelaDetalhesProjeto(projetos.get(tbProjetos.getSelectedRow()),this).setVisible(true);
                setEnabled(false);
                break;
                
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btSelecionarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.frameInvocador.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void tbProjetosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProjetosMouseClicked
        ativarDesativarBotoesPelaTabela();
// TODO add your handling code here:
    }//GEN-LAST:event_tbProjetosMouseClicked

    private void ativarDesativarBotoesPelaTabela(){
        if(tbProjetos.getSelectedRow() != -1)
            btSelecionar.setEnabled(true);
        else
            btSelecionar.setEnabled(false);
    }
    
    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        tfNome.setText("");
        tfParticipante.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_btLimparActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.frameInvocador.setEnabled(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaSelecionarProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSelecionarProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSelecionarProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSelecionarProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSelecionarProjeto(0, null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTable tbProjetos;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfParticipante;
    // End of variables declaration//GEN-END:variables
}
