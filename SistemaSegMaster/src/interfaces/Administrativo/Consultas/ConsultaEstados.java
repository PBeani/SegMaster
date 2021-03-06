/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.Administrativo.Consultas;

import bancoDeDados.BancoException;
import beans.Estado;
import interfaces.Administrativo.Adicionar.AdicionarEstado;
import interfaces.Administrativo.Editar.EditarEstado;
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

/**
 *
 * @author pedro
 */
public class ConsultaEstados extends javax.swing.JPanel {

    /**
     * Creates new form ConsultaEstados
     */
    PainelAdministrativo parent;

    public ConsultaEstados(PainelAdministrativo p) {
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
                        EditarEstado editar = new EditarEstado(parent);
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
                            EstadoRegrasNegocio regras = new EstadoRegrasNegocio();
                            regras.remove(cod);
                            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
                            try {
                                EstadoRegrasNegocio estado = new EstadoRegrasNegocio();
                                LinkedList<Estado> listaEstado = estado.listaEstado();
                                montaTabelaEstado(listaEstado);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        add_estado = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Estados");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Estado", "Sigla"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        add_estado.setBackground(new java.awt.Color(0, 204, 255));
        add_estado.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        add_estado.setForeground(new java.awt.Color(255, 255, 255));
        add_estado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_estado.setText("Adicionar Estado");
        add_estado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_estado.setOpaque(true);
        add_estado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_estadoMouseClicked(evt);
            }
        });

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
                        .addComponent(add_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(add_estado, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void montaTabelaEstado(List<Estado> listaEstados) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Estado estado : listaEstados) {
            model.addRow(new Object[]{estado.getId_estado(), estado.getDesc_estado(), estado.getSigla()});

        }
        jTable1.setRowSorter(new TableRowSorter(model));

    }

    private void add_estadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_estadoMouseClicked
        JPanel lastPanel = parent.getLastPanel();
        JPanel painelConsultas = parent.getPainelConsulta();
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            painelConsultas.revalidate();
        } else {
            painelConsultas.revalidate();
        }
        AdicionarEstado panelAdm = new AdicionarEstado(parent);
        JPanel content = panelAdm;
        content.setBounds(0, 0, painelConsultas.getSize().width, painelConsultas.getSize().height);
        content.setVisible(true);

        painelConsultas.add(content);
        parent.add(painelConsultas);
        parent.setLastPanel(content);
    }//GEN-LAST:event_add_estadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
