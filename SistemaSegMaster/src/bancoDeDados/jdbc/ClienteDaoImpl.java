package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import beans.Cliente;
import bancoDeDados.*;

public class ClienteDaoImpl extends ConectorJDBC implements ClienteDao {

    public ClienteDaoImpl() throws BancoException {
        super();
    }

    @Override
    public int insereCliente(Cliente cliente) throws BancoException {
        int chave = -1;
        abreConexao();
        preparaComandoSQL(
                "insert into cliente (nome_cliente, id_tipo_cliente) values (?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS);
        try {
            pstmt.setString(1, cliente.getNome_cliente());
            pstmt.setInt(2, cliente.getId_cliente());
            pstmt.execute();

            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                chave = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar Cliente.");
        }

        fechaConexao();
        return chave;
    }

    @Override
    public Cliente selecionaCliente(int cod) throws BancoException {
        abreConexao();
        Cliente cliente = null;
        preparaComandoSQL("select * from cliente where id_cliente = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);
                int tipo = rs.getInt(3);

                cliente = new Cliente(codigo, nome, tipo);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção do Item.");
        }
        fechaConexao();

        return cliente;
    }
    
    @Override
    public LinkedList<Cliente> listaCliente()throws BancoException{
        LinkedList<Cliente> lista =  new LinkedList<>();
        abreConexao();
        Cliente cliente = null;
        preparaComandoSQL("select * from cliente");
        try{
            rs=pstmt.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt(1);
                String nome=rs.getString(2);
                int tipo = rs.getInt(3);
                cliente = new Cliente(codigo, nome, tipo);
                lista.add(cliente);
            }
        }catch(SQLException e){
            fechaConexao();
            throw new BancoException("Problemas ao gerar lista Clientes");
        }
        fechaConexao();
        return lista;
        
    }
   

}
