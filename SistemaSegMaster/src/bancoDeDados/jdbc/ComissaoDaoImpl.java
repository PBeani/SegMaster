/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados.jdbc;

import bancoDeDados.BancoException;
import bancoDeDados.ConectorJDBC;
import beans.Comissao;
import beans.ComissaoResult;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author amand_000
 */
public class ComissaoDaoImpl extends ConectorJDBC{
    
    public ComissaoDaoImpl() throws BancoException {
        super();
    }

    public void insereComissao(Comissao comissao) throws BancoException, SQLException {
        abreConexao();
        preparaComandoSQL("insert into comissao (id_pedido, valor_comissao, id_status_comissao, id_forma_pagamento, prc_comissao) values (?,?,?,?,?) ");
        try {
            pstmt.setInt(1, comissao.getCod_pedido());
            pstmt.setDouble(2, comissao.getValor_comissao());
            pstmt.setInt(3, comissao.getCod_status_comissao());
            pstmt.setInt(4, comissao.getCod_forma_pagamento());
            pstmt.setDouble(5, comissao.getPorcentagem_comissao());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar comissao");
        }
        fechaConexao();
    }
    
    public void alteraComissao(Comissao comissao) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update comissao set id_pedido = ?, valor_comissao = ?, id_status_comissao = ?, id_forma_pagamento = ?, prc_comissao = ? where id_comissao = ?");
        try {
            pstmt.setInt(1, comissao.getCod_pedido());
            pstmt.setDouble(2, comissao.getValor_comissao());
            pstmt.setInt(3, comissao.getCod_status_comissao());
            pstmt.setInt(4, comissao.getCod_forma_pagamento());
            pstmt.setDouble(5, comissao.getPorcentagem_comissao());
            pstmt.setInt(6, comissao.getId_comissao());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização de Comissao.");
        }

        fechaConexao();
    }

    public Comissao selecionaComissao(int cod) throws BancoException {
        abreConexao();

        Comissao comissao = null;
        preparaComandoSQL("select * from comissao where id_comissao = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                int codPedido = rs.getInt(2);
                double codValor = rs.getInt(3);
                int codStatus = rs.getInt(4);
                int codPagamento = rs.getInt(5);
                double codPorcentagem = rs.getInt(6);
                
                comissao = new Comissao(codigo, codPedido, codValor, codStatus, codPagamento, codPorcentagem);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de Comissao.");
        }
        
        fechaConexao();
        return comissao;
    }

    public LinkedList<ComissaoResult> listaComissao() throws BancoException {
        LinkedList<ComissaoResult> lista = new LinkedList<>();
        ComissaoResult item = null;
        abreConexao();
        
        preparaComandoSQL("select id_comissao, id_pedido, valor_comissao" +
        " from comissao");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                int pedido = rs.getInt(2);
                double valor = rs.getDouble(3);

                item = new ComissaoResult(codigo, pedido, valor);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Comissoes.");
        }

        fechaConexao();
        return lista;
    }
    
    public LinkedList<ComissaoResult> listaComissaoFiltro(int i) throws BancoException {
        LinkedList<ComissaoResult> lista = new LinkedList<>();
        ComissaoResult item = null;
        abreConexao();
        
        preparaComandoSQL("select id_comissao, id_pedido, valor_comissao" +
        " from comissao where id_pedido = ?");
        try {
            pstmt.setInt(1, i);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                int pedido = rs.getInt(2);
                double valor = rs.getDouble(3);

                item = new ComissaoResult(codigo, pedido, valor);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Comissoes.");
        }

        fechaConexao();
        return lista;
    }
    
    public void removeComissao(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from comissao where id_comissao = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção de Comissao.");
        }

        fechaConexao();
    }
    public boolean existeComissao(int cod) throws BancoException{
        boolean resp;
        abreConexao();

        Comissao comissao = null;
        preparaComandoSQL("select * from comissao where id_comissao = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                resp=true;
            }
            else resp=false;
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de Comissao.");
        }
        
        fechaConexao();
        return resp;
    }
    
}
