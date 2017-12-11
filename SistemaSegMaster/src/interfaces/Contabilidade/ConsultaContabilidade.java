/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.Contabilidade;

import bancoDeDados.BancoException;
import beans.CategoriaCertificado;
import beans.Contabilidade;
import beans.Endereco;
import beans.Municipio;
import interfaces.Administrativo.Editar.EditarCategoriaCertificado;
import interfaces.Administrativo.PainelAdministrativo;
import interfaces.HomeAdmin;
import interfaces.ItemSelecionado;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import regrasDeNegocio.Categoria_certificadoRegrasNegocio;
import regrasDeNegocio.ContabilidadeRegrasNegocio;
import regrasDeNegocio.EnderecoRegrasNegocio;
import regrasDeNegocio.MunicipioRegrasNegocio;

/**
 *
 * @author pedro
 */
public class ConsultaContabilidade extends javax.swing.JPanel {

    /**
     * Creates new form ConsultaContabilidade
     */
    
    HomeAdmin home;
    Municipio municipio;
    LinkedList<Contabilidade> listaContabilidade;

    public ConsultaContabilidade(HomeAdmin h) {

        initComponents();
        populaJcomboBox();
        home = h;
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
                        EnderecoRegrasNegocio end;
                        try {
                            System.out.println(linha);
                            Contabilidade c = listaContabilidade.get(linha);
                            System.out.println(c.getCod_endereco());
                            end = new EnderecoRegrasNegocio();
                            Endereco endereco = end.selecionaEndereco(c.getCod_endereco());
                            System.out.println(endereco.getBairro());
                            EditarContabilidade editar = new EditarContabilidade(home, endereco, c);
                            JPanel content = editar;
                            editar.dados(cod);
                            content.setBounds(0, 0, painelConsultas.getSize().width, painelConsultas.getSize().height);
                            content.setVisible(true);

                            painelConsultas.add(content);
                            home.add(painelConsultas);
                            home.setLastPanel(content);
                        } catch (BancoException ex) {
                            Logger.getLogger(ConsultaContabilidade.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (i == 1) {
                        try {
                            Contabilidade c = listaContabilidade.get(linha);
                            EnderecoRegrasNegocio end = new EnderecoRegrasNegocio();
                            Endereco ende = end.selecionaEndereco(c.getCod_endereco());
                            EditarContabilidade editar = new EditarContabilidade(home, ende, c);
                            ContabilidadeRegrasNegocio cont = new ContabilidadeRegrasNegocio();

                            if (cont.excluir(c)) {
                                if (end.excluiEndereco(ende)) {
                                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
                                }
                            }
                            editar.remove(cod);
                            constroiJTable(municipio);

                        } catch (HeadlessException ex) {
                        } catch (BancoException ex) {
                            Logger.getLogger(ConsultaContabilidade.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        });
    }

    public void constroiJTable(Municipio muni) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            ContabilidadeRegrasNegocio conta = new ContabilidadeRegrasNegocio();
            LinkedList<Contabilidade> lista = conta.listaContabilidade(muni);
            listaContabilidade = lista;
            for (Contabilidade cont : lista) {
                model.addRow(new Object[]{
                    cont.getId_contabilidade(),
                    cont.getNome_contabilidade(),
                    cont.getCnpj(),
                    cont.getCod_parceria()});
            }
            jTable1.setRowSorter(new TableRowSorter(model));
        } catch (BancoException ex) {
            JOptionPane.showMessageDialog(null, "problema na consulta da tabela de contabilidade");
        }

    }

    private void populaJcomboBox() {
        try {
            MunicipioRegrasNegocio muni = new MunicipioRegrasNegocio();
            LinkedList<Municipio> m = muni.listaMunicipio();

            for (Municipio munic : m) {
                municipioBox.addItem(munic);
            }

        } catch (BancoException e) {

        } catch (Exception ex) {

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

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pesquisar = new javax.swing.JButton();
        municipioBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setAutoscrolls(true);

        jSeparator1.setForeground(new java.awt.Color(255, 153, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Consultar Contabilidades");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CNPJ", "Parceria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

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

        municipioBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                municipioBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Município:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 387, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(municipioBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(municipioBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        // TODO add your handling code here:
        String municipio = municipioBox.getSelectedItem().toString();
    }//GEN-LAST:event_pesquisarActionPerformed

    private void municipioBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_municipioBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_municipioBoxActionPerformed

    private void pesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesquisarMouseClicked
        // TODO add your handling code here:
        this.municipio = (Municipio) municipioBox.getSelectedItem();
        constroiJTable(municipio);
    }//GEN-LAST:event_pesquisarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<Object> municipioBox;
    private javax.swing.JButton pesquisar;
    // End of variables declaration//GEN-END:variables
}
