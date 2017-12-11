/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados.jdbc;

import bancoDeDados.BancoException;
import bancoDeDados.ConectorJDBC;
import bancoDeDados.ContabilidadeDao;
import beans.CategoriaCertificado;
import beans.Contabilidade;
import beans.Municipio;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cliente
 */
public class ContabilidadeDaoImpl extends ConectorJDBC implements ContabilidadeDao {

    public ContabilidadeDaoImpl() throws BancoException {

    }

    @Override
    public boolean existeContabilidade(Contabilidade cont) throws BancoException {
        boolean resp = false;
        try {
            abreConexao();
            preparaComandoSQL("select * from contabilidade where nome_contabilidade = ?");
            pstmt.setString(1, cont.getNome_contabilidade());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                resp = true;
            }

        } catch (SQLException ex) {
            fechaConexao();
            throw new BancoException("Problema na seleção do estado.");
        }
        fechaConexao();
        return resp;
    }

    @Override
    public void insereContabilidade(Contabilidade c) throws BancoException {

        abreConexao();
        preparaComandoSQL("insert into contabilidade (nome_contabilidade,cnpj,id_endereco) values (?,?,?) ");

        try {
            pstmt.setString(1, c.getNome_contabilidade());
            pstmt.setString(2, c.getCnpj());
            pstmt.setInt(3, c.getCod_endereco());
            pstmt.execute();

        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar contabilidade");
        }
        fechaConexao();
    }

    @Override
    public LinkedList<Contabilidade> listaContabilidade(Municipio m) throws BancoException {

        LinkedList<Contabilidade> cont = new LinkedList<>();
        try {
            abreConexao();
            preparaComandoSQL("select c.id_contabilidade,c.nome_contabilidade,c.cnpj,c.cod_parceria,c.id_endereco from segmaster.contabilidade as c inner join segmaster.endereco as e on c.id_endereco = e.id_endereco inner join segmaster.municipios as m on e.id_municipio=m.id_municipio where m.id_municipio LIKE ?");
            pstmt.setInt(1, m.getId_municipio());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int cod = rs.getInt(1);
                String nome = rs.getString(2);
                String cnpj = rs.getString(3);
                int cod_parceria = rs.getInt(4);
                int id_endereco = rs.getInt(5);
                Contabilidade conta = new Contabilidade(cod, nome, cnpj, cod_parceria,id_endereco);
                cont.add(conta);
            }
        } catch (SQLException ex) {
            fechaConexao();
            throw new BancoException("Problemas ao gerar lista Contabilidade");
        }
        fechaConexao();
        return cont;
    }

    @Override
    public void alteraContabilidade(Contabilidade c) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update contabilidade set nome_contabilidade = ?, cnpj = ?, ies_parceiro=?, cod_parceria = ?, id_endereco=? where id_contabilidade = ?");
        try {
            pstmt.setString(1, c.getNome_contabilidade());
            pstmt.setString(2, c.getCnpj());
            pstmt.setInt(3, c.getIes_parceiro());
            pstmt.setInt(4, c.getCod_parceria());
            pstmt.setInt(5,c.getCod_endereco());
            pstmt.setInt(6,c.getId_contabilidade());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização da contabilidade .");
        }

        fechaConexao();

    }

    @Override
    public Contabilidade seleciona(int cod) throws BancoException {
        abreConexao();

        Contabilidade cont = null;
        preparaComandoSQL("select * from contabilidade where id_contabilidade = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                String nome= rs.getString(1);
                String cnpj = rs.getString(2);
                int ies_parceiro=rs.getInt(3);
                int cod_parceria=rs.getInt(4);
                int id_endereco=rs.getInt(5);

                cont = new Contabilidade(nome,cnpj,ies_parceiro,cod_parceria,id_endereco);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de contabilidade.");
        }
        
        fechaConexao();
        return cont;
        
        
    }

    @Override
    public LinkedList<Contabilidade> listaContabilidade() throws BancoException {
        LinkedList<Contabilidade> cont = new LinkedList<>();
        try {
            abreConexao();
            preparaComandoSQL("select * from contabilidade");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int cod = rs.getInt(1);
                String nome = rs.getString(2);
                String cnpj = rs.getString(3);
                int cod_parceria = rs.getInt(4);
                Contabilidade conta = new Contabilidade(cod, nome, cnpj, cod_parceria);
                cont.add(conta);
            }
        } catch (SQLException ex) {
            fechaConexao();
            throw new BancoException("Problemas ao gerar lista Contabilidade");
        }
        fechaConexao();
        return cont;
        
    }

    @Override
    public boolean excluir(Contabilidade c) throws BancoException {
        boolean resp = true;
        abreConexao();
        preparaComandoSQL("delete from contabilidade where id_contabilidade = ?");
        try {
            pstmt.setInt(1, c.getId_contabilidade());
            pstmt.execute();
        } catch (SQLException e) {
            resp=false;
            fechaConexao();
            throw new BancoException("Problema na remoção da contabilidade.");
        }
        fechaConexao();
        return resp;
    }

    @Override
    public LinkedList<Contabilidade> listaContabilidade(String nomes) throws BancoException {
        LinkedList<Contabilidade> cont = new LinkedList<>();
        try {
            abreConexao();
            preparaComandoSQL("select * from contabilidade where nome_contabilidade=?");
            pstmt.setString(1, nomes);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int cod = rs.getInt(1);
                String nome = rs.getString(2);
                String cnpj = rs.getString(3);
                int cod_parceria = rs.getInt(4);
                Contabilidade conta = new Contabilidade(cod, nome, cnpj, cod_parceria);
                cont.add(conta);
            }
        } catch (SQLException ex) {
            fechaConexao();
            throw new BancoException("Problemas ao gerar lista Contabilidade");
        }
        fechaConexao();
        return cont;
        
        
    }

}
