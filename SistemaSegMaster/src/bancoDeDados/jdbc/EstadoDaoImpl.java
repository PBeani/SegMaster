package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Estado;

public class EstadoDaoImpl extends ConectorJDBC implements EstadoDao {

    public EstadoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereEstado(Estado estado) throws BancoException {

        abreConexao();
        preparaComandoSQL("insert into estado (desc_estado, sigla) values (?,?) ");

        try {
            pstmt.setString(1, estado.getDesc_estado());
            pstmt.setString(2, estado.getSigla());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar estado");
        }
        fechaConexao();
    }
}
