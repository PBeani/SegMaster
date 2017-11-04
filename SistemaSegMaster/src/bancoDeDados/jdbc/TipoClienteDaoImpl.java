package bancoDeDados.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.TipoCliente;

public class TipoClienteDaoImpl extends ConectorJDBC implements TipoClienteDao {

    public TipoClienteDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereTipoCliente(TipoCliente tipo) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into tipo_cliente (desc_tipo_cliente) values (?)");
        try {
            pstmt.setString(1, tipo.getDesc_tipo_cliente());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar tipo de cliente.");
        }
        fechaConexao();
    }

    @Override
    public void alteraTipoCliente(TipoCliente tipo) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update tipo_cliente set desc_tipo_cliente = ? where id_tipo_cliente = ?");
        try {
            pstmt.setString(1, tipo.getDesc_tipo_cliente());
            pstmt.setInt(2, tipo.getId_tipo_cliente());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização de tipo de cliente");
        }

        fechaConexao();
    }

    @Override
    public TipoCliente selecionaTipoCliente(int cod) throws BancoException {
        abreConexao();

        TipoCliente categoria = null;
        preparaComandoSQL("select * from tipo_cliente where id_tipo_cliente = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                String desc = rs.getString(2);

                categoria = new TipoCliente(codigo, desc);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de tipo de cliente.");
        }
        
        fechaConexao();
        return categoria;
    }

    @Override
    public LinkedList<TipoCliente> listaTipoCliente() throws BancoException {
        LinkedList<TipoCliente> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from tipo_cliente");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);

                TipoCliente item = new TipoCliente(codigo, nome);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de tipo de cliente.");
        }

        fechaConexao();
        return lista;
    }

    @Override
    public void removeTipoCliente(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from tipo_cliente where id_tipo_cliente = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção de tipo de cliente.");
        }

        fechaConexao();
    }

}
