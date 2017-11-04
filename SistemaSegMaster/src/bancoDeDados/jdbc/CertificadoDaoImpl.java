package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Certificado;

public class CertificadoDaoImpl extends ConectorJDBC implements CertificadoDao {

    public CertificadoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereCertificado(Certificado certificado) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into certificado (cod_tipo_certificado, cod_categoria_certificado, cod_hardware, cod_hierarquia, num_certificado, data_validade) values (?,?,?,?,?,?) ");
        try {
            pstmt.setInt(1, certificado.getCod_tipo_certificado());
            pstmt.setInt(2, certificado.getCod_categoria_certificado());
            pstmt.setInt(3, certificado.getCod_hardware());
            pstmt.setInt(4, certificado.getCod_hierarquia());
            pstmt.setString(5, certificado.getNum_certificado());
            pstmt.setDate(6, java.sql.Date.valueOf(certificado.getData_validade()));
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar certificado");
        }
        fechaConexao();
    }
}
