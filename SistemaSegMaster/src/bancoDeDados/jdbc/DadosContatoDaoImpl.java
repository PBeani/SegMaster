/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados.jdbc;

import bancoDeDados.BancoException;
import bancoDeDados.ConectorJDBC;
import bancoDeDados.DadosContatoDao;
import beans.ContatoCliente;
import beans.DadosContato;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author pedro
 */
public class DadosContatoDaoImpl extends ConectorJDBC implements DadosContatoDao {

    public DadosContatoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public int insereDados(DadosContato e) throws BancoException {
        int chave = -1;
        abreConexao();
        preparaComandoSQL(
                "insert into dados_contato (id_tipo_contato, desc_dados_contato) values (?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS);
        try {
            pstmt.setInt(1, e.getTipo());
            pstmt.setString(2, e.getDesc());
            pstmt.execute();

            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                chave = rs.getInt(1);
            }
            
        } catch (SQLException i) {
            throw new BancoException("Problema ao cadastrar Contato.");
        }
        fechaConexao();
        return chave;
    }
    
    @Override
    public void atualiza(DadosContato e) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "update dados_contato set desc_dados_contato = ? where id_dados_contato = ? ");
        try {
            pstmt.setString(1, e.getDesc());
            pstmt.setInt(2, e.getCod());
            pstmt.execute();

        } catch (SQLException i) {
            throw new BancoException("Problema ao cadastrar Contato.");
        }
        fechaConexao();
    }

    @Override
    public void insereCliente(ContatoCliente e) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into contato_cliente (id_cliente, id_dados_contato) values (?,?)");
        try {
            pstmt.setInt(1, e.getCliente());
            pstmt.setInt(2, e.getDados());
            pstmt.execute();
        } catch (SQLException i) {
            throw new BancoException("Problema ao cadastrar Contato.");
        }
        fechaConexao();
    }

    @Override
    public LinkedList<DadosContato> listaContatosCliente(int cod) throws BancoException {
        LinkedList<DadosContato> lista = new LinkedList<>();
        abreConexao();
        DadosContato dados = null;
        preparaComandoSQL("select dados_contato.id_dados_contato, dados_contato.id_tipo_contato, dados_contato.desc_dados_contato"
                + " from contato_cliente"
                + " left join dados_contato on contato_cliente.id_dados_contato = dados_contato.id_dados_contato"
                + " where id_cliente = ?");
        try {
            pstmt.setInt(1, cod);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt(1);
                int tipo = rs.getInt(2);
                String desc = rs.getString(3);

                dados = new DadosContato(codigo, tipo, desc);
                lista.add(dados);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problemas ao gerar lista de contatos");
        }
        fechaConexao();
        return lista;
    }

    @Override
    public void insereContador(ContatoCliente e) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into contato_contador (id_contador, id_dados_contato) values (?,?)");
        try {
            pstmt.setInt(1, e.getCliente());
            pstmt.setInt(2, e.getDados());
            pstmt.execute();
        } catch (SQLException i) {
            throw new BancoException("Problema ao cadastrar Contato.");
        }
        fechaConexao();
    }
}
