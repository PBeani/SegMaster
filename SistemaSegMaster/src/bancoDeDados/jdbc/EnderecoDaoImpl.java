/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados.jdbc;

import bancoDeDados.BancoException;
import bancoDeDados.ConectorJDBC;
import bancoDeDados.EnderecoDao;
import beans.Endereco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cliente
 */
public class EnderecoDaoImpl extends ConectorJDBC implements EnderecoDao {

    public EnderecoDaoImpl() throws BancoException {

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
            fechaConexao();
            throw new BancoException("Problema ao cadastrar Endereço.");

        }
        fechaConexao();
        System.out.println(chave);
        return chave;
    }

    /*@Override
    public int insereEndereco(Endereco end) throws BancoException {       
        int cod_endereco=-1;
        abreConexao();
        System.out.println(end.getCod_estado()+"  "+end.getCep());
        preparaComandoSQL("insert into endereco (id_estado , id_municipio , bairro, logradouro, numero, complemento, cep) values (?,?,?,?,?,?,?) ",
        PreparedStatement.RETURN_GENERATED_KEYS);
        try {     
            pstmt.setInt(1, end.getCod_estado());
            pstmt.setInt(2, end.getCod_municipio());
            pstmt.setString(3, end.getBairro());
            pstmt.setString(4, end.getLogradouro());
            pstmt.setString(5, end.getNumero());
            pstmt.setString(6, end.getComplemento());
            pstmt.setString(7, end.getCep());   
            
            pstmt.execute();            
            rs = pstmt.getGeneratedKeys();
            System.out.println(rs.getInt(1));
            if(rs.next()){
                cod_endereco=rs.getInt(1);
                System.out.println(cod_endereco);
            }
        } catch (SQLException e) {
            fechaConexao();
            System.out.println("funçao insereEndereco");
            throw new BancoException("Problema ao cadastrar endereco");
        }
        fechaConexao();
        return cod_endereco;
    }*/
    @Override
    public boolean existeEndereco(Endereco end) throws BancoException {
        boolean resp = false;
        try {
            abreConexao();
            System.out.println(end.getCep());
            preparaComandoSQL("select * from endereco where cep = ? and numero = ?");
            pstmt.setString(1, end.getCep());
            pstmt.setString(2, end.getNumero());
            
            rs = pstmt.executeQuery();
            if (rs.next()) {
                resp = true;
            }

        } catch (SQLException ex) {
            fechaConexao();
        }
        fechaConexao();
        return resp;
    }

    @Override
    public int alteraEndereco(Endereco end) throws BancoException {
        abreConexao();
        preparaComandoSQL("update endereco set id_estado=?, id_municipio=?,bairro=?,logradouro=?,numero=?,complemento=?,cep=? where id_endereco=? ");

        try {
            pstmt.setInt(1, end.getCod_estado());
            pstmt.setInt(2, end.getCod_municipio());
            pstmt.setString(3, end.getBairro());
            pstmt.setString(4, end.getLogradouro());
            pstmt.setString(5, end.getNumero());
            pstmt.setString(6, end.getComplemento());
            pstmt.setString(7, end.getCep());
            pstmt.setInt(8,end.getId_endereco());
            pstmt.execute();
        } catch (SQLException ex) {
            fechaConexao();
        }
        fechaConexao();
        return 1;
    }

    @Override
    public Endereco seleciona(int cod) throws BancoException {
        Endereco end = null;
        try {
            abreConexao();
            preparaComandoSQL("select * from segmaster.endereco where id_endereco = ?");
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int id_endereco = rs.getInt(1);
                int cod_estado = rs.getInt(2);
                int cod_municipio = rs.getInt(3);
                String bairro = rs.getString(4);
                String logradouro = rs.getString(5);
                String numero = rs.getString(6);
                String complemento = rs.getString(7);
                String cep = rs.getString(8);

                System.out.println("bairro" + bairro);
                end = new Endereco(id_endereco, cod_estado, cod_municipio, bairro, logradouro, numero, complemento, cep);
            }
        } catch (SQLException ex) {
            System.out.println("seleciona");
            fechaConexao();
        }
        fechaConexao();
        return end;

    }

    @Override
    public boolean excluir(Endereco end) throws BancoException {
        boolean resp = true;
        abreConexao();
        preparaComandoSQL("delete from endereco where id_endereco = ?");
        try {
            pstmt.setInt(1, end.getId_endereco());
            pstmt.execute();
        } catch (SQLException e) {
            resp = false;
            fechaConexao();
            throw new BancoException("Problema na remoção do endereco.");
        }
        fechaConexao();
        return resp;

    }

}
