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
        preparaComandoSQL("insert into municipios (cod_estado, descricao) values (?,?) ");
        try {
            pstmt.setInt(1, municipio.getCod_estado());
            pstmt.setString(2, municipio.getDescricao());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar municipio");
        }
        fechaConexao();
    }
}
