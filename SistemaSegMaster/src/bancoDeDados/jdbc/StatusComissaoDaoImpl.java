package bancoDeDados.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.StatusComissao;

public class StatusComissaoDaoImpl extends ConectorJDBC implements StatusComissaoDao {

    public StatusComissaoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereStatusComissao(StatusComissao status) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into status_comissao (desc_status_comissao) values (?)");
        try {
            pstmt.setString(1, status.getDesc_status_comissao());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar status da comissao");
        }
        fechaConexao();
    }

    @Override
    public void alteraStatusComissao(StatusComissao status) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update status_comissao set desc_status_comissao = ? where id_status_comissao = ?");
        try {
            pstmt.setString(1, status.getDesc_status_comissao());
            pstmt.setInt(2, status.getId_status_comissao());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização do status da comissao.");
        }

        fechaConexao();
    }

    @Override
    public StatusComissao selecionaStatusComissao(int cod) throws BancoException {
        abreConexao();

        StatusComissao status = null;
        preparaComandoSQL("select * from status_comissao where id_status_comissao = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                String desc = rs.getString(2);

                status = new StatusComissao(codigo, desc);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de status da comissao.");
        }
        
        fechaConexao();
        return status;
    }

    @Override
    public LinkedList<StatusComissao> listaStatusComissao() throws BancoException {
        LinkedList<StatusComissao> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from status_comissao");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);

                StatusComissao item = new StatusComissao(codigo, nome);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de status comissao.");
        }

        fechaConexao();
        return lista;
    }

    @Override
    public void removeStatusComissao(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from status_comissao where id_status_comissao = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção da status da comissao.");
        }

        fechaConexao();
    }
    
    public boolean existeStatusComissao(String desc) throws BancoException{
     boolean resp;
        abreConexao();        
        preparaComandoSQL("select * from status_comissao where desc_status_comissao = ?");
        try {
            pstmt.setString(1, desc);
            rs = pstmt.executeQuery();
            if (rs.next()) {    
                resp= true;
            }
            else resp = false;
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de status da comissao.");
        }
        
        fechaConexao();
        return resp;
    }

}
