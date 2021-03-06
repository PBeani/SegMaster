/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.Administrativo.Consultas;

import bancoDeDados.BancoException;
import beans.FormaPagamento;
import interfaces.Administrativo.Adicionar.AdicionarFormaPagamento;
import interfaces.Administrativo.Editar.EditarEstado;
import interfaces.Administrativo.Editar.EditarFormaPagamento;
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
import regrasDeNegocio.EstadoRegrasNegocio;
import regrasDeNegocio.Forma_pagamentoRegrasNegocio;

/**
 *
 * @author pedro
 */
public class ConsultaFormaPagamento extends javax.swing.JPanel {

    /**
     * Creates new form ConsultaFormaPagamento
     */
    PainelAdministrativo parent;

    public ConsultaFormaPagamento(PainelAdministrativo p) {
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
                        EditarFormaPagamento editar = new EditarFormaPagamento(parent);
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
                            Forma_pagamentoRegrasNegocio regras = new Forma_pagamentoRegrasNegocio();
                            regras.remove(cod);
                            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
                            try {
                                Forma_pagamentoRegrasNegocio formaPagamente = new Forma_pagamentoRegrasNegocio();
                                LinkedList<FormaPagamento> listaFormaPagamento = formaPagamente.listaFormaPagamento();
                                montaTabelaFormaPagamento(listaFormaPagamento);
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
        addFormaPagamento = new javax.swing.JLabel();
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

        addFormaPagamento.setBackground(new java.awt.Color(0, 204, 255));
        addFormaPagamento.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        addFormaPagamento.setForeground(new java.awt.Color(255, 255, 255));
        addFormaPagamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addFormaPagamento.setText("Adicionar Forma de Pagamento");
        addFormaPagamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addFormaPagamento.setOpaque(true);
        addFormaPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addFormaPagamentoMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Forma de Pagamento");

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
                        .addComponent(addFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(addFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void montaTabelaFormaPagamento(List<FormaPagamento> listaFormaPagamento) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (FormaPagamento formaPagamento : listaFormaPagamento) {
            model.addRow(new Object[]{formaPagamento.getId_forma_pagamento(), formaPagamento.getDesc_forma_pagamento()});

        }
        jTable1.setRowSorter(new TableRowSorter(model));

    }

    private void addFormaPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addFormaPagamentoMouseClicked
        JPanel lastPanel = parent.getLastPanel();
        JPanel painelConsultas = parent.getPainelConsulta();
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            painelConsultas.revalidate();
        } else {
            painelConsultas.revalidate();
        }
        AdicionarFormaPagamento panelAdm = new AdicionarFormaPagamento(parent);
        JPanel content = panelAdm;
        content.setBounds(0, 0, painelConsultas.getSize().width, painelConsultas.getSize().height);
        content.setVisible(true);

        painelConsultas.add(content);
        parent.add(painelConsultas);
        parent.setLastPanel(content);
    }//GEN-LAST:event_addFormaPagamentoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
