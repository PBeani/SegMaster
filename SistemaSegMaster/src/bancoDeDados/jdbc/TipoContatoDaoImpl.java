package bancoDeDados.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.TipoContato;

public class TipoContatoDaoImpl extends ConectorJDBC implements TipoContatoDao {

    public TipoContatoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereTipoContato(TipoContato tipo) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into tipo_contato (desc_tipo_contato) values (?)");
        try {
            pstmt.setString(1, tipo.getDesc_tipo_contato());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar tipo de contato");
        }
        fechaConexao();
    }

    @Override
    public void alteraTipoContato(TipoContato tipo) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update tipo_contato set desc_tipo_contato = ? where id_tipo_contato = ?");
        try {
            pstmt.setString(1, tipo.getDesc_tipo_contato());
            pstmt.setInt(2, tipo.getId_tipo_contato());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização do tipo de contato.");
        }

        fechaConexao();
    }

    @Override
    public TipoContato selecionaTipoContato(int cod) throws BancoException {
        abreConexao();

        TipoContato categoria = null;
        preparaComandoSQL("select * from tipo_contato where id_tipo_contato = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                String desc = rs.getString(2);

                categoria = new TipoContato(codigo, desc);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de tipo de contato.");
        }
        
        fechaConexao();
        return categoria;
    }

    @Override
    public LinkedList<TipoContato> listaTipoContato() throws BancoException {
        LinkedList<TipoContato> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from tipo_contato");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);

                TipoContato item = new TipoContato(codigo, nome);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de tipo de contato.");
        }

        fechaConexao();
        return lista;
    }

    @Override
    public void removeTipoContato(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from tipo_contato where id_tipo_contato = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção de tipo de contato.");
        }

        fechaConexao();
    }

}
