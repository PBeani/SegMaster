/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.Contador;

import bancoDeDados.BancoException;
import beans.Contabilidade;
import beans.Contador;
import interfaces.HomeAdmin;
import interfaces.ItemSelecionado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import regrasDeNegocio.ContabilidadeRegrasNegocio;
import regrasDeNegocio.ContadorRegrasNegocio;

/**
 *
 * @author pedro
 */
public class ConsultarContador extends javax.swing.JPanel {

    HomeAdmin home;
    /**
     * Creates new form ConsultarContador
     */
    public ConsultarContador(HomeAdmin h) {
        initComponents();
        home=h;
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
                        JPanel lastPanel = home.getLastPanel();
                        JPanel painelConsultas = home.paineldeconteudo;
                        if (lastPanel != null) {
                            lastPanel.setVisible(false);
                            painelConsultas.revalidate();
                        } else {
                            painelConsultas.revalidate();
                        }
                        ContadorRegrasNegocio end;
                        try {
                            ContabilidadeRegrasNegocio cont = new ContabilidadeRegrasNegocio();                            
                            String nome_contador= (String)jTable1.getValueAt(linha,1);
                            String nome_contabilidade = (String)jTable1.getValueAt(linha,2);
                            Contabilidade c = cont.listaContabilidade(nome_contabilidade).get(0);
                            end = new ContadorRegrasNegocio();
                            
                            Contador contador = new Contador( nome_contador,cod);
                            EditarContador editar = new EditarContador(home,contador, c);
                            JPanel content = editar;
                            //editar.dados(cod);
                            content.setBounds(0, 0, painelConsultas.getSize().width, painelConsultas.getSize().height);
                            content.setVisible(true);

                            painelConsultas.add(content);
                            home.add(painelConsultas);
                            home.setLastPanel(content);
                        } catch (BancoException ex) {
                        }
                    }
                    if (i == 1) {
                        try {
                            ContabilidadeRegrasNegocio cont = new ContabilidadeRegrasNegocio(); 
                            Contabilidade c = cont.listaContabilidade(nome.getText()).get(linha);                          
                            
                            Contador contador = new Contador(cod,jTable1.getValueAt(linha,1).toString());
                            ContadorRegrasNegocio con = new ContadorRegrasNegocio();
                            EditarContador editar = new EditarContador(home, contador, c);

                            if (cont.excluir(c)) {
                                if (con.excluiContador(contador)) {
                                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
                                }
                            }
                            editar.remove(cod);
                            constroiJTable(contador);

                        }catch (BancoException ex) {
                        }
                    }

                }
            }
        });
    }
    public void constroiJTable(Contador cont) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            ContadorRegrasNegocio conta = new ContadorRegrasNegocio();
            LinkedList<Contador> lista = conta.listaContadores(cont.getNomeContador());
            
            
            for (Contador conts : lista) {
                model.addRow(new Object[]{
                    conts.getId_contador(),
                    conts.getNome_contabilidade(),
                    conts.getNome_contabilidade()
                });
            }
            jTable1.setRowSorter(new TableRowSorter(model));
        } catch (BancoException ex) {
            JOptionPane.showMessageDialog(null, "problema na consulta da tabela de contabilidade");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pesquisar = new javax.swing.JButton();
        nome = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 153, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Contabilidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Consultar Contadores");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        pesquisar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        pesquisar.setText("Pesquisar");
        pesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisarMouseClicked(evt);
            }
        });
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(263, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jLabel1)
                            .addGap(638, 638, 638))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(521, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(80, 80, 80)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarActionPerformed

    private void pesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesquisarMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String n = nome.getText();
        ContadorRegrasNegocio cont;
        try {
            cont = new ContadorRegrasNegocio();
            for(Contador conts: cont.listaContadores(n)){
                model.addRow(new Object[]{
                    conts.getId_contador(),
                    conts.getNomeContador(),
                    conts.getNome_contabilidade()
                });
                
            }
            jTable1.setRowSorter(new TableRowSorter(model));
        } catch (BancoException ex) {
            Logger.getLogger(ConsultarContador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_pesquisarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nome;
    private javax.swing.JButton pesquisar;
    // End of variables declaration//GEN-END:variables
}
