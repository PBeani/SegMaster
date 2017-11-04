package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Contador;

public class ContadorDaoImpl extends ConectorJDBC implements ContadorDao {

    public ContadorDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereContador(Contador contador) throws BancoException {
        abreConexao();
        preparaComandoSQL("insert into contador (nome_contador,cod_contabilidade) values (?,?) ");
        try {
            pstmt.setString(1, contador.getNomeContador());
            pstmt.setInt(2, contador.getCod_contabilidade());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar contador");
        }
        fechaConexao();
    }
}
