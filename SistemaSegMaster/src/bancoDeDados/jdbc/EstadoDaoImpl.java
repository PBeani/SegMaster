package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Estado;
import javax.swing.JOptionPane;

public class EstadoDaoImpl extends ConectorJDBC implements EstadoDao {

    public EstadoDaoImpl() throws BancoException  {
        super();        
    }

    @Override
    public void insereEstado(Estado estado) throws BancoException {
        abreConexao();
        
        preparaComandoSQL("insert into estados (desc_estado, sigla) values (?,?) ");

        try {
            
            pstmt.setString(1, estado.getDesc_estado());
            pstmt.setString(2, estado.getSigla());
            pstmt.execute();
            
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar estado");
        }
        fechaConexao();
    }
    
    @Override
    public void alteraEstado(Estado estado) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update estados set desc_estado = ?, sigla = ? where id_estado = ?");
        try {
            pstmt.setString(1, estado.getDesc_estado());
            pstmt.setString(2, estado.getSigla());
            pstmt.setInt(3, estado.getId_estado());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização do estado.");
        }

        fechaConexao();
    }

    @Override
    public Estado selecionaEstado(int cod) throws BancoException {
        abreConexao();

        Estado estado = null;
        preparaComandoSQL("select * from estados where id_estado = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                String desc = rs.getString(2);
                String sigla = rs.getString(3);

                estado = new Estado(codigo, desc, sigla);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção do estado.");
        }
        
        fechaConexao();
        return estado;
    }

    @Override
    public LinkedList<Estado> listaEstado() throws BancoException {
        
        LinkedList<Estado> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from estados");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);
                String sigla = rs.getString(3);
                
                Estado item = new Estado(codigo, nome, sigla);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de estados.");
        }

        fechaConexao();
        return lista;
    }

    @Override
    public void removeEstado(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from estados where id_estado = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção do estado.");
        }

        fechaConexao();
    }
    public boolean existeEstado(String sigla)throws BancoException{
        boolean resp;
        abreConexao();
        preparaComandoSQL("select * from estados where sigla = ?");
        try {
            pstmt.setString(1, sigla);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                resp = true;
            }
            else resp = false;
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção do estado.");
        }
        
        fechaConexao();
        return resp;
    }
}
