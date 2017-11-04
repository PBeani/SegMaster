package bancoDeDados.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.CategoriaCertificado;

public class CategoriaCertificadoDaoImpl extends ConectorJDBC implements CategoriaCertificadoDao {

    public CategoriaCertificadoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereCategoriaCertificado(CategoriaCertificado categoria) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into categoria_certificado (desc_categoria_certificado) values (?)");
        try {
            pstmt.setString(1, categoria.getDesc_categoria_certificado());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar categoria do certificado");
        }
        fechaConexao();
    }

    @Override
    public void alteraCategoriaCertificado(CategoriaCertificado categoria) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update categoria_certificado set desc_categoria_certificado = ? where id_categoria_certificado = ?");
        try {
            pstmt.setString(1, categoria.getDesc_categoria_certificado());
            pstmt.setInt(2, categoria.getId_tipo_certificado());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização da categoria do certificado.");
        }

        fechaConexao();
    }

    @Override
    public CategoriaCertificado selecionaCategoriaCertificado(int cod) throws BancoException {
        abreConexao();

        CategoriaCertificado categoria = null;
        preparaComandoSQL("select * from categoria_certificado where id_categoria_certificado = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                String desc = rs.getString(2);

                categoria = new CategoriaCertificado(codigo, desc);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de categoria do certificado.");
        }
        
        fechaConexao();
        return categoria;
    }

    @Override
    public LinkedList<CategoriaCertificado> listaCategoriaCertificado() throws BancoException {
        LinkedList<CategoriaCertificado> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from categoria_certificado");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);

                CategoriaCertificado item = new CategoriaCertificado(codigo, nome);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de categorias do certificado.");
        }

        fechaConexao();
        return lista;
    }

    @Override
    public void removeCategoriaCertificado(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from categoria_certificado where id_categoria_certificado = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção da categoria do certificado.");
        }

        fechaConexao();
    }

}
