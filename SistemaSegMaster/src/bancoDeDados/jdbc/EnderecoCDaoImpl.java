/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados.jdbc;

import bancoDeDados.BancoException;
import bancoDeDados.ConectorJDBC;
import bancoDeDados.EnderecoCDao;
import beans.ClienteFisico;
import beans.Endereco;
import beans.Hierarquia;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class EnderecoCDaoImpl extends ConectorJDBC implements EnderecoCDao {
    
    public EnderecoCDaoImpl() throws BancoException {
        super();
    }
    
    @Override
    public int insereEndereco(Endereco e) throws BancoException {
        int chave = -1;
        abreConexao();
        preparaComandoSQL(
                "insert into endereco (id_estado, id_municipio, bairro, logradouro, numero, complemento, cep) values (?,?,?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS);
        try {
            pstmt.setInt(1, e.getCod_estado());
            pstmt.setInt(2, e.getCod_municipio());
            pstmt.setString(3, e.getBairro());
            pstmt.setString(4, e.getLogradouro());
            pstmt.setString(5, e.getNumero());
            pstmt.setString(6, e.getComplemento());
            pstmt.setString(7, e.getCep());
            pstmt.execute();
            
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                chave = rs.getInt(1);
            }
            
        } catch (SQLException i) {
            throw new BancoException("Problema ao cadastrar Endereço.");
        }
        fechaConexao();
        return chave;
    }
    
    @Override
    public void remove(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from endereco where id_endereco= ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção do endereço.");
        }

        fechaConexao();
    }
    
    @Override
    public Endereco seleciona(int cod) throws BancoException {
        abreConexao();
        Endereco end = null;
        preparaComandoSQL("select * from endereco where id_endereco = ?");
        try {
            pstmt.setInt(1, cod);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                int estado = rs.getInt(2);
                int municipio = rs.getInt(3);
                String bairro = rs.getString(4);
                String logradouro = rs.getString(5);
                String numero = rs.getString(6);
                String complemento = rs.getString(7);
                String cep = rs.getString(8);
                
                end = new Endereco(id, estado, municipio, bairro, logradouro, numero, complemento, cep);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção do endereço.");
        }

        fechaConexao();
        return end;
    }
    
    @Override
    public void atualiza(Endereco e) throws BancoException {
        int chave = -1;
        abreConexao();
        preparaComandoSQL(
                "update endereco set id_estado = ?, id_municipio = ?, bairro = ?, logradouro = ?, numero = ?, complemento = ?, cep = ? where id_endereco = ?");
        try {
            pstmt.setInt(1, e.getCod_estado());
            pstmt.setInt(2, e.getCod_municipio());
            pstmt.setString(3, e.getBairro());
            pstmt.setString(4, e.getLogradouro());
            pstmt.setString(5, e.getNumero());
            pstmt.setString(6, e.getComplemento());
            pstmt.setString(7, e.getCep());
            pstmt.setInt(8, e.getId_endereco());
            pstmt.execute();
            
        } catch (SQLException i) {
            throw new BancoException("Problema ao cadastrar Endereço.");
        }
        fechaConexao();
    }
}
