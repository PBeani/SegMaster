/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.Administrativo.Adicionar;

import bancoDeDados.BancoException;
import beans.StatusComissao;
import interfaces.Administrativo.Consultas.ConsultaStatusComissao;
import interfaces.Administrativo.PainelAdministrativo;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import regrasDeNegocio.StatusRegrasNegocio;

/**
 *
 * @author pedro
 */
public class AdicionarStatusComissao extends javax.swing.JPanel {

    /**
     * Creates new form AdicionarStatusComissao
     */
    PainelAdministrativo parent;
    public AdicionarStatusComissao(PainelAdministrativo p) {
        parent = p;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        descricao = new javax.swing.JTextField();
        cancelar = new javax.swing.JLabel();
        salvar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Adicionar Status de Comissão");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("Descrição:");

        descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descricaoActionPerformed(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color(204, 0, 0));
        cancelar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelar.setText("Cancelar");
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.setOpaque(true);
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarMouseClicked(evt);
            }
        });

        salvar.setBackground(new java.awt.Color(0, 204, 0));
        salvar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        salvar.setForeground(new java.awt.Color(255, 255, 255));
        salvar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salvar.setText("Salvar");
        salvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salvar.setOpaque(true);
        salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salvarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(descricao, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(316, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descricaoActionPerformed

    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        retornarLista();
    }//GEN-LAST:event_cancelarMouseClicked

    private void salvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salvarMouseClicked
        // TODO add your handling code here:
        
        try {
            String textoDescricao = descricao.getText();            
            StatusRegrasNegocio e = new StatusRegrasNegocio();
            StatusComissao statusComissao  = new StatusComissao(textoDescricao);
            if (e.cadastraStatusComissao(statusComissao)) {
                JOptionPane.showMessageDialog(null, "Novo Status da comissao salvo com sucesso");    
                retornarLista();
            }
        
        } catch (BancoException ex) {
            JOptionPane.showMessageDialog(null, "problema no acesso ao banco de dados");
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_salvarMouseClicked
    private void retornarLista() {
        JPanel lastPanel = parent.getLastPanel();
        JPanel painelConsultas = parent.getPainelConsulta();
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            painelConsultas.revalidate();
        } else {
            painelConsultas.revalidate();
        }
        ConsultaStatusComissao panelAdm = new ConsultaStatusComissao(parent);
        JPanel content = panelAdm;
        content.setBounds(0, 0, painelConsultas.getSize().width, painelConsultas.getSize().height);
        content.setVisible(true);

        try {
            StatusRegrasNegocio status = new StatusRegrasNegocio();
            LinkedList<StatusComissao> listaStatus = status.listaStatusComissao();
            panelAdm.montaTabelaStatusComissao(listaStatus);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        painelConsultas.add(content);
        parent.add(painelConsultas);
        parent.setLastPanel(content);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cancelar;
    private javax.swing.JTextField descricao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel salvar;
    // End of variables declaration//GEN-END:variables
}
