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
        preparaComandoSQL("insert into contador (nome_contador) values (?) ",
                PreparedStatement.RETURN_GENERATED_KEYS);
        try {   
            pstmt.setString(1, contador.getNomeContador()); 
            pstmt.execute();
            rs=pstmt.getGeneratedKeys();
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

   @Override
    public int existeContador(String nome) throws BancoException {
        int resp=-1;
        abreConexao();
        preparaComandoSQL("select id_contador from contador where nome_contador=?");
        try {
            pstmt.setString(1, nome);            
            rs=pstmt.executeQuery();
            if(rs.next()){
                resp=rs.getInt(1);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema ao cadastrar contador");
        }
        fechaConexao();
        return resp;
        
    }

    @Override
    public void insereContadorContabilidade(Contador contador) throws BancoException {
        abreConexao();
        preparaComandoSQL("insert into contabilidade_contador (id_contabilidade,id_contador) values (?,?) ");
        try {
            pstmt.setInt(1, contador.getCod_contabilidade());
            pstmt.setInt(2, contador.getId_contador());
            pstmt.execute();
           
            
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema ao cadastrar contador");
        }
        fechaConexao();
    }

    @Override
    public LinkedList<Contador> listaContador(String nome) throws BancoException {
        LinkedList<Contador> cont = new LinkedList<>();
        try {
            abreConexao();
            preparaComandoSQL("select c.nome_contador,c.id_contador,contabilidade.nome_contabilidade from segmaster.contador as c inner join segmaster.contabilidade_contador as cc on cc.id_contador=c.id_contador inner join segmaster.contabilidade on cc.id_contabilidade=contabilidade.id_contabilidade where c.nome_contador LIKE (?)");
            pstmt.setString(1, "%" + nome + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {                
                String nomes = rs.getString(1);
                int idContador=rs.getInt(2);
                String nomeContabilidade = rs.getString(3);
                Contador conta = new Contador(nomes,idContador,nomeContabilidade);
                cont.add(conta);
            }
        } catch (SQLException ex) {            
            fechaConexao();
            throw new BancoException("Problemas ao gerar lista Contabilidade");
        }
        fechaConexao();
        return cont;
        
        
    }

    /*@Override
    public Contador seleciona(int cod) throws BancoException {
        abreConexao();
        preparaComandoSQL("select * from contador where id_contador=? ");
        try {
            pstmt.setInt(1, cod);            
            rs=pstmt.executeQuery();
           if(rs.next()){
               
           }
            
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema ao cadastrar contador");
        }
        fechaConexao();
        return new Contador(cod, "");
        
    }*/

    @Override
    public boolean excluiContador(Contador contador) throws BancoException {
        boolean resp = true;
        abreConexao();
        preparaComandoSQL("delete from contador where id_contador = ?");
        try {
            pstmt.setInt(1, contador.getId_contador());
            pstmt.execute();
        } catch (SQLException e) {
            resp=false;
            fechaConexao();
            throw new BancoException("Problema na remoção de contador.");
        }
        fechaConexao();
        return resp;
    }

    @Override
    public int altera(Contador contador) throws BancoException {
         abreConexao();
        preparaComandoSQL("update contador set nome_contador = ? where id_contador=? ");

        try {
            pstmt.setString(1, contador.getNomeContador());
            pstmt.setInt(2, contador.getId_contador());            
            pstmt.execute();
        } catch (SQLException ex) {
            fechaConexao();
        }
        fechaConexao();
        return 1;
        
    }
}
