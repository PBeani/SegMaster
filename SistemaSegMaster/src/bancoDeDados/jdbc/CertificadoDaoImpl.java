package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Certificado;
import beans.CertificadoResult;
import java.sql.Date;

public class CertificadoDaoImpl extends ConectorJDBC implements CertificadoDao {

    public CertificadoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereCertificado(Certificado certificado) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into certificado (id_tipo_certificado, id_categoria_certificado, id_hardware, id_hierarquia, num_certificado, data_validade, id_pedido) values (?,?,?,?,?,?,?) ");
        try {
            pstmt.setInt(1, certificado.getCod_tipo_certificado());
            pstmt.setInt(2, certificado.getCod_categoria_certificado());
            pstmt.setInt(3, certificado.getCod_hardware());
            pstmt.setInt(4, certificado.getCod_hierarquia());
            pstmt.setString(5, certificado.getNum_certificado());
            pstmt.setDate(6, java.sql.Date.valueOf(certificado.getData_validade()));
            pstmt.setInt(7, certificado.getCod_pedido());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar certificado");
        }
        fechaConexao();
    }

    public boolean existeCertificado(String num) throws BancoException {
        boolean resp;
        abreConexao();

        Certificado certificado = null;
        preparaComandoSQL("select * from certificado where num_certificado = ?");
        try {
            pstmt.setString(1, num);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                resp = true;
            } else {
                resp = false;
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de Certificado.");
        }

        fechaConexao();
        return resp;
    }

    public Certificado selecionaCertificado(int cod) throws BancoException {
        abreConexao();

        Certificado certificado = null;
        preparaComandoSQL("select * from certificado where id_certificado = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                int codTipoCertificado = rs.getInt(2);
                int codCategoriaCertificado = rs.getInt(3);
                int codHardware = rs.getInt(4);
                int codHierarquia = rs.getInt(5);
                int codPedido = rs.getInt(6);
                String num = rs.getString(7);
                Date data = rs.getDate(8);

                certificado = new Certificado(codigo, codTipoCertificado, codCategoriaCertificado, codHardware, codHierarquia, codPedido, num, data);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de Certificado.");
        }

        fechaConexao();
        return certificado;
    }

    public void alteraCertificado(Certificado certificado) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update certificado set num_certificado = ?, id_tipo_certificado = ?, id_categoria_certificado = ?, id_hardware = ?, id_hierarquia = ?, id_pedido = ?, data_validade = ? where id_certificado = ?");
        try {
            pstmt.setString(1, certificado.getNum_certificado());
            pstmt.setInt(2, certificado.getCod_tipo_certificado());
            pstmt.setInt(3, certificado.getCod_categoria_certificado());
            pstmt.setInt(4, certificado.getCod_hardware());
            pstmt.setInt(5, certificado.getCod_hierarquia());
            pstmt.setInt(6, certificado.getCod_pedido());
            pstmt.setDate(7, java.sql.Date.valueOf(certificado.getData_validade()));
            pstmt.setInt(8, certificado.getId_certificado());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização de Certificado.");
        }

        fechaConexao();
    }

    public LinkedList<CertificadoResult> listaCertificado() throws BancoException {
        LinkedList<CertificadoResult> lista = new LinkedList<>();
        CertificadoResult item = null;
        
        abreConexao();

        preparaComandoSQL("select certificado.id_certificado, certificado.num_certificado, cliente.nome_cliente, certificado.data_validade " +
        "from certificado " +
        "left join pedido on certificado.id_pedido = pedido.id_pedido " +
        "left join cliente on pedido.id_cliente = cliente.id_cliente");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String num = rs.getString(2);
                String cli = rs.getString(3);
                String date = rs.getDate(4).toString();

                item = new CertificadoResult(codigo, num, cli, date);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Certificados.");
        }

        fechaConexao();
        return lista;
    }
    
    public LinkedList<CertificadoResult> listaCertificadoCat() throws BancoException {
        LinkedList<CertificadoResult> lista = new LinkedList<>();
        CertificadoResult item = null;
        
        abreConexao();

        preparaComandoSQL("SELECT categoria_certificado.desc_categoria_certificado, "
                + "COUNT(certificado.id_certificado) FROM certificado "
                + "LEFT JOIN categoria_certificado "
                + "ON certificado.id_categoria_certificado = categoria_certificado.id_categoria_certificado " 
                + "GROUP BY desc_categoria_certificado;");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String cat = rs.getString(1);
                int qtd = rs.getInt(2);

                item = new CertificadoResult(qtd, cat);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Certificados.");
        }

        fechaConexao();
        return lista;
    }
    
    public LinkedList<CertificadoResult> listaCertificadoTipo() throws BancoException {
        LinkedList<CertificadoResult> lista = new LinkedList<>();
        CertificadoResult item = null;
        
        abreConexao();

        preparaComandoSQL("SELECT tipo_certificado.desc_tipo_certificado, "
                + "COUNT(certificado.id_certificado) FROM certificado "
                + "LEFT JOIN tipo_certificado "
                + "ON certificado.id_tipo_certificado = tipo_certificado.id_tipo_certificado " 
                + "GROUP BY desc_tipo_certificado;");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String cat = rs.getString(1);
                int qtd = rs.getInt(2);

                item = new CertificadoResult(qtd, cat);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Certificados.");
        }

        fechaConexao();
        return lista;
    }
    
    public LinkedList<CertificadoResult> listaCertificadoFiltro(String s) throws BancoException {
        LinkedList<CertificadoResult> lista = new LinkedList<>();
        CertificadoResult item = null;
        
        abreConexao();

        preparaComandoSQL("select certificado.id_certificado, certificado.num_certificado, cliente.nome_cliente, certificado.data_validade " +
        "from certificado " +
        "left join pedido on certificado.id_pedido = pedido.id_pedido " +
        "left join cliente on pedido.id_cliente = cliente.id_cliente " +
        "where certificado.num_certificado LIKE ? " +
        "UNION "+ 
        "select certificado.id_certificado, certificado.num_certificado, cliente.nome_cliente, certificado.data_validade " +
        "from certificado " +
        "left join pedido on certificado.id_pedido = pedido.id_pedido " +
        "left join cliente on pedido.id_cliente = cliente.id_cliente " +
        "where cliente.nome_cliente LIKE ? "
        );
        try {
            pstmt.setString(1, "%" + s + "%");
            pstmt.setString(2, "%" + s + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String num = rs.getString(2);
                String cli = rs.getString(3);
                String date = rs.getDate(4).toString();

                item = new CertificadoResult(codigo, num, cli, date);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Certificados.");
        }

        fechaConexao();
        return lista;
    }

    public void removeCertificado(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from certificado where id_certificado = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção de Certificado.");
        }

        fechaConexao();
    }
}
