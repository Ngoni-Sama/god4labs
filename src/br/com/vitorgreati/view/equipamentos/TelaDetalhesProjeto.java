/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorgreati.view.equipamentos;

import br.com.vitorgreati.model.Autoridade;
import br.com.vitorgreati.model.Projeto;
import br.com.vitorgreati.model.Usuario;
import br.com.vitorgreati.persistence.AutoridadeDAO;
import br.com.vitorgreati.persistence.UsuarioDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

/**
 *
 * @author Vitor
 */
public class TelaDetalhesProjeto extends javax.swing.JFrame {

    private Projeto projeto;
    private AutoridadeDAO autoridadeDao;
    private ArrayList<Usuario> orientadores;
    private ArrayList<Usuario> estudantes;
    private UsuarioDAO usuarioDAO;
    private JFrame frameInvocador;
    
    /**
     * Creates new form TelaDetalhesProjeto
     */
    public TelaDetalhesProjeto(Projeto projeto, JFrame frameInvocador) {
        initComponents();
        autoridadeDao = new AutoridadeDAO();
        orientadores = new ArrayList<>();
        estudantes = new ArrayList<>();
        this.projeto = projeto;
        this.frameInvocador = frameInvocador;
        this.usuarioDAO = new UsuarioDAO();
        projeto.setUsuarios(usuarioDAO.buscarUsuariosPorProjeto(projeto));
        preencherCampos();
        setLocationRelativeTo(null);
    }

    private void preencherCampos(){
        lbNome.setText(projeto.getNome());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        lbInicio.setText(format.format(projeto.getDataInicio()));
        lbTermino.setText(format.format(projeto.getDataFinal()));
        taDescricao.setText(projeto.getDescricao());
        
        setTitle("Projeto: "+projeto.getNome());
        
        Autoridade autOrientador = autoridadeDao.buscarPorNome("Orientador");
        Autoridade autEstudante = autoridadeDao.buscarPorNome("Estudante");
        
        DefaultListModel modelEst = new DefaultListModel();
        DefaultListModel modelOri = new DefaultListModel();
        for(Usuario u : projeto.getUsuarios()){
            if(u.getAutoridades().contains(autOrientador)){
                modelOri.addElement(u.getNome());
                orientadores.add(u);
            }else if(u.getAutoridades().contains(autEstudante)){                
                modelEst.addElement(u.getNome());
                estudantes.add(u);
            }   
        }
        ltOrientadores.setModel(modelOri);
        ltPesquisadores.setModel(modelEst);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbInicio = new javax.swing.JLabel();
        lbTermino = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ltOrientadores = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ltPesquisadores = new javax.swing.JList();
        btFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados gerais"));

        jLabel1.setText("Nome:");

        jLabel2.setText("Início:");

        jLabel3.setText("Término:");

        jScrollPane1.setBorder(null);

        taDescricao.setEditable(false);
        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        taDescricao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(taDescricao);

        jLabel4.setText("Descrição:");

        lbNome.setBackground(new java.awt.Color(255, 255, 255));
        lbNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbNome.setOpaque(true);

        lbInicio.setBackground(new java.awt.Color(255, 255, 255));
        lbInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbInicio.setOpaque(true);

        lbTermino.setBackground(new java.awt.Color(255, 255, 255));
        lbTermino.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbTermino.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(308, 308, 308))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbNome)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(lbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lbTermino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbInicio, lbNome, lbTermino});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuários vinculados"));

        jLabel8.setText("Orientadores:");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ltOrientadores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ltOrientadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ltOrientadoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ltOrientadores);

        jLabel9.setText("Pesquisadores:");

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ltPesquisadores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ltPesquisadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ltPesquisadoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ltPesquisadores);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
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
                        .addComponent(btFechar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void ltOrientadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ltOrientadoresMouseClicked
        if(evt.getClickCount()==2){
            new TelaDetalhesUsuario(orientadores.get(ltOrientadores.getSelectedIndex()),this).setVisible(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ltOrientadoresMouseClicked

    private void ltPesquisadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ltPesquisadoresMouseClicked
        if(evt.getClickCount()==2){
            new TelaDetalhesUsuario(estudantes.get(ltPesquisadores.getSelectedIndex()),this).setVisible(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ltPesquisadoresMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.frameInvocador.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.frameInvocador.setEnabled(true);   
        dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_btFecharActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDetalhesProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDetalhesProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDetalhesProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDetalhesProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDetalhesProjeto(null,null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbInicio;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTermino;
    private javax.swing.JList ltOrientadores;
    private javax.swing.JList ltPesquisadores;
    private javax.swing.JTextArea taDescricao;
    // End of variables declaration//GEN-END:variables
}
