package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Municipio;

public class MunicipioDaoImpl extends ConectorJDBC implements MunicipioDao {

    public MunicipioDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereMunicipio(Municipio municipio) throws BancoException {
        abreConexao();
        preparaComandoSQL("insert into municipios (id_estado, descricao) values (?,?) ");
        try {
            pstmt.setInt(1, municipio.getCod_estado());
            pstmt.setString(2, municipio.getDescricao());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar municipio");
        }
        fechaConexao();
    }
    
    @Override
    public void alteraMunicipio(Municipio municipio) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update municipios set descricao = ?, id_estado = ? where id_municipio = ?");
        try {
            pstmt.setString(1, municipio.getDescricao());
            pstmt.setInt(2, municipio.getCod_estado());
            pstmt.setInt(3, municipio.getId_municipio());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização de Municipio.");
        }

        fechaConexao();
    }

    @Override
    public Municipio selecionaMunicipio(int cod) throws BancoException {
        abreConexao();

        Municipio municipio = null;
        preparaComandoSQL("select * from municipios where id_municipio = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                int codEstado = rs.getInt(2);
                String desc = rs.getString(3);

                municipio = new Municipio(codigo, codEstado, desc);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de Municipio.");
        }
        
        fechaConexao();
        return municipio;
    }

    @Override
    public LinkedList<Municipio> listaMunicipio() throws BancoException {
        LinkedList<Municipio> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from municipios");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                int codEstado = rs.getInt(2);
                String nome = rs.getString(3);

                Municipio item = new Municipio(codigo, codEstado, nome);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Municipios.");
        }

        fechaConexao();
        return lista;
    }
    
    @Override
    public LinkedList<Municipio> listaMunicipioEstado(int cod) throws BancoException {
        LinkedList<Municipio> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from municipios where id_estado = ?");
        try {
            pstmt.setInt(1, cod);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                int codEstado = rs.getInt(2);
                String nome = rs.getString(3);

                Municipio item = new Municipio(codigo, codEstado, nome);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Municipios.");
        }

        fechaConexao();
        return lista;
    }

    @Override
    public void removeMunicipio(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from municipios where id_municipio = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção de Municipio.");
        }

        fechaConexao();
    }
    public boolean existeMunicipio(String descricao) throws BancoException{
        boolean resp;
        abreConexao();

        Municipio municipio = null;
        preparaComandoSQL("select * from municipios where descricao = ?");
        try {
            pstmt.setString(1, descricao);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                resp=true;
            }
            else resp=false;
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de Municipio.");
        }
        
        fechaConexao();
        return resp;
    }
}
