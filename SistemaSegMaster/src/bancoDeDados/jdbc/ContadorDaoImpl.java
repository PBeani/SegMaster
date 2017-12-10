package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Contador;
import beans.Contato;
import beans.ContatoCliente;
import beans.DadosContato;

public class ContadorDaoImpl extends ConectorJDBC implements ContadorDao {

    public ContadorDaoImpl() throws BancoException {
        super();
    }

    @Override
    public int insereContador(Contador contador) throws BancoException {
        int chave=-1;
        abreConexao();
        preparaComandoSQL("insert into contador (nome_contador,cod_contabilidade) values (?,?) ",PreparedStatement.RETURN_GENERATED_KEYS);
        try {
            pstmt.setString(1, contador.getNomeContador());
            pstmt.setInt(2, contador.getCod_contabilidade());
            rs=pstmt.executeQuery();
            if(rs.next()){
                chave=rs.getInt(1);
            }            
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar contador");
        }
        fechaConexao();
        return chave;
    }

    @Override
    public int insereContatoContador(int id_contador,int id_dados_contato) throws BancoException { //Cliente == contador
        int chave = -1;
        abreConexao();
        preparaComandoSQL("insert into contato_contador (id_contador,id_dados_contato) values (?,?) ",PreparedStatement.RETURN_GENERATED_KEYS);
        try {
            pstmt.setInt(1, id_contador);
            pstmt.setInt(2, id_dados_contato);
            rs=pstmt.executeQuery();
            if(rs.next()){
                chave=rs.getInt(1);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema ao cadastrar contador");
        }
        fechaConexao();
        return chave;
        
    }

   /* @Override
    public boolean existeContador(String nome) throws BancoException {
        abreConexao();
        preparaComandoSQL("select * from contador where nome_contador ");
        try {
            pstmt.setInt(1, contato.getCliente());
            //
            rs=pstmt.executeQuery();
            if(rs.next()){
                chave=rs.getInt(1);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema ao cadastrar contador");
        }
        fechaConexao();
        
        
    }*/
}
