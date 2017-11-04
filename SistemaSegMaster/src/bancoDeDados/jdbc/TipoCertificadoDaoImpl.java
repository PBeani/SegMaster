package bancoDeDados.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.TipoCertificado;

public class TipoCertificadoDaoImpl extends ConectorJDBC implements TipoCertificadoDao {

    public TipoCertificadoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereTipoCertificado(TipoCertificado tipo) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into tipo_certificado (desc_tipo_certificado) values (?)");
        try {
            pstmt.setString(1, tipo.getDesc_tipo_certificado());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar tipo do certificado");
        }
        fechaConexao();
    }

    @Override
    public void alteraTipoCertificado(TipoCertificado tipo) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update tipo_certificado set desc_tipo_certificado = ? where id_tipo_certificado = ?");
        try {
            pstmt.setString(1, tipo.getDesc_tipo_certificado());
            pstmt.setInt(2, tipo.getId_tipo_certificado());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização da tipo do certificado.");
        }

        fechaConexao();
    }

    @Override
    public TipoCertificado selecionaTipoCertificado(int cod) throws BancoException {
        abreConexao();

        TipoCertificado tipo = null;
        preparaComandoSQL("select * from tipo_certificado where id_tipo_certificado = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                String desc = rs.getString(2);

                tipo = new TipoCertificado(codigo, desc);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de tipo do certificado.");
        }
        
        fechaConexao();
        return tipo;
    }

    @Override
    public LinkedList<TipoCertificado> listaTipoCertificado() throws BancoException {
        LinkedList<TipoCertificado> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from tipo_certificado");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);

                TipoCertificado item = new TipoCertificado(codigo, nome);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de tipo do certificado.");
        }

        fechaConexao();
        return lista;
    }

    @Override
    public void removeTipoCertificado(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from tipo_certificado where id_tipo_certificado = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção do tipo do certificado.");
        }

        fechaConexao();
    }

}
