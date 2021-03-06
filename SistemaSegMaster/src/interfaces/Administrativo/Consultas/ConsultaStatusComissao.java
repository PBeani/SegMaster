/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.Administrativo.Consultas;

import bancoDeDados.BancoException;
import beans.StatusComissao;
import interfaces.Administrativo.Adicionar.AdicionarStatusComissao;
import interfaces.Administrativo.Editar.EditarFormaPagamento;
import interfaces.Administrativo.Editar.EditarStatusComissao;
import interfaces.Administrativo.PainelAdministrativo;
import interfaces.ItemSelecionado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import regrasDeNegocio.Forma_pagamentoRegrasNegocio;
import regrasDeNegocio.StatusRegrasNegocio;

/**
 *
 * @author pedro
 */
public class ConsultaStatusComissao extends javax.swing.JPanel {

    /**
     * Creates new form ConsultaStatusComissao
     */
    PainelAdministrativo parent;

    public ConsultaStatusComissao(PainelAdministrativo p) {
        parent = p;
        initComponents();

        jTable1.addMouseListener(new MouseAdapter() {
            private int linha;
            private String opcoes[] = new String[]{"Alterar", "Excluir"};

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int i = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Alerta", -1, -1, null, opcoes, 0);
                    linha = jTable1.getSelectedRow();
                    int cod = Integer.parseInt(String.valueOf(jTable1.getValueAt(linha, 0)));
                    if (i == 0) { // Atualizar
                        ItemSelecionado.getInstance().setID(cod);
                        JPanel lastPanel = parent.getLastPanel();
                        JPanel painelConsultas = parent.getPainelConsulta();
                        if (lastPanel != null) {
                            lastPanel.setVisible(false);
                            painelConsultas.revalidate();
                        } else {
                            painelConsultas.revalidate();
                        }
                        EditarStatusComissao editar = new EditarStatusComissao(parent);
                        editar.dados(cod);
                        JPanel content = editar;
                        content.setBounds(0, 0, painelConsultas.getSize().width, painelConsultas.getSize().height);
                        content.setVisible(true);

                        painelConsultas.add(content);
                        parent.add(painelConsultas);
                        parent.setLastPanel(content);
                    }
                    if (i == 1) {
                        try {
                            StatusRegrasNegocio regras = new StatusRegrasNegocio();
                            regras.remove(cod);
                            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
                            try {
                                StatusRegrasNegocio status = new StatusRegrasNegocio();
                                LinkedList<StatusComissao> listaStatus = status.listaStatusComissao();
                                montaTabelaStatusComissao(listaStatus);
                            } catch (Exception ex) {
                                Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            }
        });
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
        addStatusComissao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        addStatusComissao.setBackground(new java.awt.Color(0, 204, 255));
        addStatusComissao.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        addStatusComissao.setForeground(new java.awt.Color(255, 255, 255));
        addStatusComissao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addStatusComissao.setText("Adicionar Status de Comissão");
        addStatusComissao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addStatusComissao.setOpaque(true);
        addStatusComissao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStatusComissaoMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Status de Comissão");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addStatusComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(addStatusComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void montaTabelaStatusComissao(List<StatusComissao> listaStatusComissao) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for (StatusComissao status : listaStatusComissao) {
            model.addRow(new Object[]{status.getId_status_comissao(), status.getDesc_status_comissao()});

        }
        jTable1.setRowSorter(new TableRowSorter(model));

    }

    private void addStatusComissaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStatusComissaoMouseClicked
        JPanel lastPanel = parent.getLastPanel();
        JPanel painelConsultas = parent.getPainelConsulta();
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            painelConsultas.revalidate();
        } else {
            painelConsultas.revalidate();
        }
        AdicionarStatusComissao panelAdm = new AdicionarStatusComissao(parent);
        JPanel content = panelAdm;
        content.setBounds(0, 0, painelConsultas.getSize().width, painelConsultas.getSize().height);
        content.setVisible(true);

        painelConsultas.add(content);
        parent.add(painelConsultas);
        parent.setLastPanel(content);
    }//GEN-LAST:event_addStatusComissaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addStatusComissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
