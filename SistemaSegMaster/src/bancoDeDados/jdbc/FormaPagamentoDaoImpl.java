package bancoDeDados.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.FormaPagamento;

public class FormaPagamentoDaoImpl extends ConectorJDBC implements FormaPagamentoDao {

    public FormaPagamentoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereFormaPagamento(FormaPagamento forma) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into forma_pagamento (desc_forma_pagamento) values (?)");
        try {
            pstmt.setString(1, forma.getDesc_forma_pagamento());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar forma de pagamento");
        }
        fechaConexao();
    }

    @Override
    public void alteraFormaPagamento(FormaPagamento forma) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update forma_pagamento set desc_forma_pagamento= ? where id_forma_pagamento = ?");
        try {
            pstmt.setString(1, forma.getDesc_forma_pagamento());
            pstmt.setInt(2, forma.getId_forma_pagamento());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização da forma de pagamento.");
        }

        fechaConexao();
    }

    @Override
    public FormaPagamento selecionaFormaPagamento(int cod) throws BancoException {
        abreConexao();

        FormaPagamento forma = null;
        preparaComandoSQL("select * from forma_pagamento where id_forma_pagamento = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                String desc = rs.getString(2);

                forma = new FormaPagamento(codigo, desc);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de categoria do certificado.");
        }
        
        fechaConexao();
        return forma;
    }

    @Override
    public LinkedList<FormaPagamento> listaFormaPagamento() throws BancoException {
        LinkedList<FormaPagamento> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from forma_pagamento");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);

                FormaPagamento item = new FormaPagamento(codigo, nome);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de forma de pagamento.");
        }

        fechaConexao();
        return lista;
    }

    @Override
    public void removeFormaPagamento(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from forma_pagamento where id_forma_pagamento = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção da forma de pagamento.");
        }

        fechaConexao();
    }

}
