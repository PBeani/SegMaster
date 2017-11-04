package bancoDeDados.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Hierarquia;

public class HierarquiaDaoImpl extends ConectorJDBC implements HierarquiaDao {

    public HierarquiaDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereHierarquia(Hierarquia hierarquia) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into hierarquia (desc_hierarquia) values (?)");
        try {
            pstmt.setString(1, hierarquia.getDesc_hierarquia());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar Hierarquia.");
        }
        fechaConexao();
    }

    @Override
    public void alteraHierarquia(Hierarquia hierarquia) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update hierarquia set desc_hierarquia = ? where id_hierarquia = ?");
        try {
            pstmt.setString(1, hierarquia.getDesc_hierarquia());
            pstmt.setInt(2, hierarquia.getId_hierarquia());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização da hierarquia.");
        }

        fechaConexao();
    }

    @Override
    public Hierarquia selecionaHierarquia(int cod) throws BancoException {
        abreConexao();

        Hierarquia hierarquia = null;
        preparaComandoSQL("select * from hierarquia where id_hierarquia = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                String desc = rs.getString(2);

                hierarquia = new Hierarquia(codigo, desc);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de hierarquia.");
        }
        
        fechaConexao();
        return hierarquia;
    }

    @Override
    public LinkedList<Hierarquia> listaHierarquia() throws BancoException {
        LinkedList<Hierarquia> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from hierarquia");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);

                Hierarquia item = new Hierarquia(codigo, nome);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de hierarquia.");
        }

        fechaConexao();
        return lista;
    }

    @Override
    public void removeHierarquia(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from hierarquia where id_hierarquia= ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção da hierarquia.");
        }

        fechaConexao();
    }

}
