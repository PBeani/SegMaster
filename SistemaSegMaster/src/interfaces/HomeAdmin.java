/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bancoDeDados.BancoException;
import beans.CertificadoResult;
import beans.ClientResult;
import beans.ComissaoResult;
import beans.Hierarquia;
import beans.PedidoResult;
import beans.SimpleObject;
import interfaces.Administrativo.PainelAdministrativo;
import interfaces.Certificado.AdicionarCertificado;
import interfaces.Certificado.ConsultaCertificado;
import interfaces.Cliente.AdicionarCliente;
import interfaces.Cliente.ConsultaCliente;
import interfaces.Comissao.AdicionarComissao;
import interfaces.Comissao.ConsultaComissao;
import interfaces.Contabilidade.AdicionarContabilidade;
import interfaces.Contabilidade.ConsultaContabilidade;
import interfaces.Contador.AdicionarContador;
import interfaces.Contador.ConsultarContador;
import interfaces.Dados.CertificadoDados;
import interfaces.Dados.ComissaoDados;
import interfaces.Pedido.AdicionarPedido;
import interfaces.Pedido.ConsultaPedido;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import regrasDeNegocio.CertificadoRegrasNegocio;
import regrasDeNegocio.ClienteRegrasNegocio;
import regrasDeNegocio.ComissaoRegrasNegocio;
import regrasDeNegocio.HierarquiaRegrasNegocio;
import regrasDeNegocio.PedidoRegrasNegocio;

/**
 *
 * @author pedro
 */
public class HomeAdmin extends javax.swing.JFrame {

    /**
     * Creates new form HomeAdmin
     */
    public HomeAdmin() {
        initComponents();
        setTitle("SegMaster");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paineldeconteudo = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        nav_administrativo = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        nav_consulta_contabilidade = new javax.swing.JMenuItem();
        nav_add_contabilidade = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        nav_contador_consultar = new javax.swing.JMenuItem();
        nav_add_contador = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        nav_consulta_cliente = new javax.swing.JMenuItem();
        nav_add_cliente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        nav_consulta_pedido = new javax.swing.JMenuItem();
        nav_add_pedido = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        nav_consulta_certificado = new javax.swing.JMenuItem();
        nav_add_certificado = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        nav_consulta_comissao = new javax.swing.JMenuItem();
        nav_adiciona_comissao = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        paineldeconteudo.setBackground(new java.awt.Color(255, 255, 255));
        paineldeconteudo.setMaximumSize(new java.awt.Dimension(920, 560));
        paineldeconteudo.setMinimumSize(new java.awt.Dimension(920, 560));

        javax.swing.GroupLayout paineldeconteudoLayout = new javax.swing.GroupLayout(paineldeconteudo);
        paineldeconteudo.setLayout(paineldeconteudoLayout);
        paineldeconteudoLayout.setHorizontalGroup(
            paineldeconteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paineldeconteudoLayout.setVerticalGroup(
            paineldeconteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(null);
        jMenuBar1.setMargin(new java.awt.Insets(20, 20, 20, 20));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(139, 37));

        nav_administrativo.setText("Administrativo");
        nav_administrativo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nav_administrativo.setMargin(new java.awt.Insets(10, 20, 10, 20));
        nav_administrativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_administrativoMouseClicked(evt);
            }
        });
        jMenuBar1.add(nav_administrativo);

        jMenu1.setText("Contabilidade");
        jMenu1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(10, 20, 10, 20));

        nav_consulta_contabilidade.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_consulta_contabilidade.setText("Consultar Contabilidade");
        nav_consulta_contabilidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_consulta_contabilidadeMouseClicked(evt);
            }
        });
        nav_consulta_contabilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_consulta_contabilidadeActionPerformed(evt);
            }
        });
        jMenu1.add(nav_consulta_contabilidade);

        nav_add_contabilidade.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_add_contabilidade.setText("Adicionar Contabilidade");
        nav_add_contabilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_add_contabilidadeActionPerformed(evt);
            }
        });
        jMenu1.add(nav_add_contabilidade);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Contador");
        jMenu2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(10, 20, 10, 20));

        nav_contador_consultar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_contador_consultar.setLabel("Consultar Contadores");
        nav_contador_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_contador_consultarActionPerformed(evt);
            }
        });
        jMenu2.add(nav_contador_consultar);

        nav_add_contador.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_add_contador.setText("Adicionar Contador");
        nav_add_contador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_add_contadorActionPerformed(evt);
            }
        });
        jMenu2.add(nav_add_contador);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Cliente");
        jMenu3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jMenu3.setMargin(new java.awt.Insets(10, 20, 10, 20));

        nav_consulta_cliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_consulta_cliente.setText("Consulta Clientes");
        nav_consulta_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_consulta_clienteMouseClicked(evt);
            }
        });
        nav_consulta_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_consulta_clienteActionPerformed(evt);
            }
        });
        jMenu3.add(nav_consulta_cliente);

        nav_add_cliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_add_cliente.setText("Adicionar Cliente");
        nav_add_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_add_clienteActionPerformed(evt);
            }
        });
        jMenu3.add(nav_add_cliente);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Pedido");
        jMenu4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jMenu4.setMargin(new java.awt.Insets(10, 20, 10, 20));

        nav_consulta_pedido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_consulta_pedido.setText("Consultar Pedidos");
        nav_consulta_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_consulta_pedidoActionPerformed(evt);
            }
        });
        jMenu4.add(nav_consulta_pedido);

        nav_add_pedido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_add_pedido.setText("Adicionar Pedido");
        nav_add_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_add_pedidoActionPerformed(evt);
            }
        });
        jMenu4.add(nav_add_pedido);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Certificado");
        jMenu5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jMenu5.setMargin(new java.awt.Insets(10, 20, 10, 20));

        nav_consulta_certificado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_consulta_certificado.setText("Consultar Certificados");
        nav_consulta_certificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_consulta_certificadoActionPerformed(evt);
            }
        });
        jMenu5.add(nav_consulta_certificado);

        nav_add_certificado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_add_certificado.setText("Adicionar Certificado");
        nav_add_certificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_add_certificadoActionPerformed(evt);
            }
        });
        jMenu5.add(nav_add_certificado);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Comissão");
        jMenu6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jMenu6.setMargin(new java.awt.Insets(10, 20, 10, 20));

        nav_consulta_comissao.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_consulta_comissao.setText("Consultar Comissões");
        nav_consulta_comissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_consulta_comissaoActionPerformed(evt);
            }
        });
        jMenu6.add(nav_consulta_comissao);

        nav_adiciona_comissao.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nav_adiciona_comissao.setText("Adicionar Comissão");
        nav_adiciona_comissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_adiciona_comissaoActionPerformed(evt);
            }
        });
        jMenu6.add(nav_adiciona_comissao);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Dados");
        jMenu7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jMenu7.setMargin(new java.awt.Insets(0, 20, 0, 20));

        jMenuItem1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem1.setText("Certificado");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jMenuItem2.setText("Comissão e Pedido");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem2);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paineldeconteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paineldeconteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nav_administrativoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_administrativoMouseClicked
        setTitle("Administrativo");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        PainelAdministrativo panelAdm = new PainelAdministrativo();
        JPanel content = panelAdm.getPanelUser();
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_administrativoMouseClicked

    private void nav_consulta_contabilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_consulta_contabilidadeActionPerformed
        setTitle("Consultar Contabilidades");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        ConsultaContabilidade panel = new ConsultaContabilidade(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_consulta_contabilidadeActionPerformed

    private void nav_consulta_contabilidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_consulta_contabilidadeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nav_consulta_contabilidadeMouseClicked

    private void nav_add_contabilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_add_contabilidadeActionPerformed
        setTitle("Adicionar Contabilidade");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        AdicionarContabilidade panel = new AdicionarContabilidade();
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_add_contabilidadeActionPerformed

    private void nav_contador_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_contador_consultarActionPerformed
        setTitle("Consultar Contadores");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        ConsultarContador panel = new ConsultarContador();
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_contador_consultarActionPerformed

    private void nav_add_contadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_add_contadorActionPerformed
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        AdicionarContador panel = new AdicionarContador();
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_add_contadorActionPerformed

    private void nav_add_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_add_clienteActionPerformed
        setTitle("Adicionar Cliente");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        AdicionarCliente panel = new AdicionarCliente(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_add_clienteActionPerformed

    private void nav_consulta_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_consulta_pedidoActionPerformed
        setTitle("Consultar Pedidos");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        ConsultaPedido panel = new ConsultaPedido(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        try {
            PedidoRegrasNegocio regras = new PedidoRegrasNegocio();
            LinkedList<PedidoResult> lista = regras.listaPedidoMin();
            panel.montaTabelaPedido(lista);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_consulta_pedidoActionPerformed

    private void nav_add_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_add_pedidoActionPerformed
        setTitle("Adicionar Pedido");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        AdicionarPedido panel = new AdicionarPedido(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);
        
        try {
            ClienteRegrasNegocio clienteRegras = new ClienteRegrasNegocio();
            LinkedList<ClientResult> lista = clienteRegras.listaClientes();
            panel.montaTabelaCliente(lista);
            
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            PedidoRegrasNegocio contadorRegras = new PedidoRegrasNegocio();
            LinkedList<SimpleObject> lista2 = contadorRegras.listaContadores();
            panel.montaTabelaContador(lista2);
            
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_add_pedidoActionPerformed

    private void nav_consulta_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_consulta_clienteMouseClicked

    }//GEN-LAST:event_nav_consulta_clienteMouseClicked

    private void nav_consulta_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_consulta_clienteActionPerformed
        setTitle("Consultar Clientes");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        ConsultaCliente panel = new ConsultaCliente(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        try {
            ClienteRegrasNegocio clienteRegras = new ClienteRegrasNegocio();
            LinkedList<ClientResult> lista = clienteRegras.listaClientes();
            panel.montaTabelaCliente(lista);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_consulta_clienteActionPerformed

    private void nav_add_certificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_add_certificadoActionPerformed
        setTitle("Adicionar Certificado");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        AdicionarCertificado panel = new AdicionarCertificado(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);
        
        try {
            PedidoRegrasNegocio regras = new PedidoRegrasNegocio();
            LinkedList<PedidoResult> lista = regras.listaPedidoMin();
            panel.montaTabelaPedido(lista);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_add_certificadoActionPerformed

    private void nav_consulta_certificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_consulta_certificadoActionPerformed
        setTitle("Consultar Certificados");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        ConsultaCertificado panel = new ConsultaCertificado(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        try {
            CertificadoRegrasNegocio regras = new CertificadoRegrasNegocio();
            LinkedList<CertificadoResult> lista = regras.listaCertificado();
            panel.montaTabelaCertificado(lista);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_consulta_certificadoActionPerformed

    private void nav_adiciona_comissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_adiciona_comissaoActionPerformed
        setTitle("Adicionar Comissao");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        AdicionarComissao panel = new AdicionarComissao(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);
        
        try {
            PedidoRegrasNegocio regras = new PedidoRegrasNegocio();
            LinkedList<PedidoResult> lista = regras.listaPedidoMin();
            panel.montaTabelaPedido(lista);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_adiciona_comissaoActionPerformed

    private void nav_consulta_comissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_consulta_comissaoActionPerformed
        setTitle("Consultar Comissões");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        ConsultaComissao panel = new ConsultaComissao(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        try {
            ComissaoRegrasNegocio regras = new ComissaoRegrasNegocio();
            LinkedList<ComissaoResult> lista = regras.listaComissao();
            panel.montaTabelaComissao(lista);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_nav_consulta_comissaoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        setTitle("Certificados");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        CertificadoDados panel = new CertificadoDados(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        // fazer essa duas funções, uma pra cada tabela. Criar um dados regra negocio que vai ter as consultas
        // das duas telas novas. é só isso, a tela la não faz nada, então é só fazer essa listagem na regra de
        // negocio nova e a função montaTabelaAlgumaCoisa na interface da tela
        try {
            ComissaoRegrasNegocio regras = new ComissaoRegrasNegocio();
            LinkedList<ComissaoResult> lista = regras.listaComissao();
            panel.montaTabelaComissao(lista);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ComissaoRegrasNegocio regras = new ComissaoRegrasNegocio();
            LinkedList<ComissaoResult> lista = regras.listaComissao();
            panel.montaTabelaComissao(lista);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        setTitle("Dados Comissão e Pedido");
        if (lastPanel != null) {
            lastPanel.setVisible(false);
            paineldeconteudo.revalidate();
        } else {
            paineldeconteudo.revalidate();
        }
        ComissaoDados panel = new ComissaoDados(this);
        JPanel content = panel;
        content.setBounds(0, 0, paineldeconteudo.getSize().width, paineldeconteudo.getSize().height);
        content.setVisible(true);

        // fazer essa duas funções, uma pra cada tabela. Criar um dados regra negocio que vai ter as consultas
        // das duas telas novas. é só isso, a tela la não faz nada, então é só fazer essa listagem na regra de
        // negocio nova e a função montaTabelaAlgumaCoisa na interface da tela
        try {
            ComissaoRegrasNegocio regras = new ComissaoRegrasNegocio();
            LinkedList<ComissaoResult> lista = regras.listaComissao();
            panel.montaTabelaComissao(lista);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ComissaoRegrasNegocio regras = new ComissaoRegrasNegocio();
            LinkedList<ComissaoResult> lista = regras.listaComissao();
            panel.montaTabelaComissao(lista);
        } catch (BancoException e) {
            JOptionPane.showMessageDialog(null, "problema no banco de dados");
        } catch (Exception ex) {
            Logger.getLogger(PainelAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }

        paineldeconteudo.add(content);
        this.add(paineldeconteudo);
        setLastPanel(content);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public JPanel lastPanel;

    public JPanel getLastPanel() {
        return lastPanel;
    }

    public void setLastPanel(JPanel last) {
        lastPanel = last;
    }

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
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem nav_add_certificado;
    private javax.swing.JMenuItem nav_add_cliente;
    private javax.swing.JMenuItem nav_add_contabilidade;
    private javax.swing.JMenuItem nav_add_contador;
    private javax.swing.JMenuItem nav_add_pedido;
    private javax.swing.JMenuItem nav_adiciona_comissao;
    private javax.swing.JMenu nav_administrativo;
    private javax.swing.JMenuItem nav_consulta_certificado;
    private javax.swing.JMenuItem nav_consulta_cliente;
    private javax.swing.JMenuItem nav_consulta_comissao;
    private javax.swing.JMenuItem nav_consulta_contabilidade;
    private javax.swing.JMenuItem nav_consulta_pedido;
    private javax.swing.JMenuItem nav_contador_consultar;
    public javax.swing.JPanel paineldeconteudo;
    // End of variables declaration//GEN-END:variables

}
