package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import beans.Cliente;
import beans.ClienteFisico;
import bancoDeDados.*;

public class ClienteFisicoDaoImpl extends ClienteDaoImpl implements ClienteFisicoDao {

    public ClienteFisicoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public int insereClienteFisico(ClienteFisico cliente) throws BancoException {
        int chave = insereCliente(cliente);
        abreConexao();

        preparaComandoSQL(
                "insert into cliente_fisico(cpf, id_cliente) values (?, ?)");
        try {
            pstmt.setString(1, cliente.getCpf());
            pstmt.setInt(2, chave);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar Cliente Fisico.");
        }
        fechaConexao();
        return chave;
    }
    
    @Override
    public void atualizaFisico(ClienteFisico cliente) throws BancoException {
        atualizaCliente(cliente);
        abreConexao();

        preparaComandoSQL(
                "update cliente_fisico set cpf = ? where id_cliente = ? ");
        try {
            pstmt.setString(1, cliente.getCpf());
            pstmt.setInt(2, cliente.getId_cliente());
            
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao atualizar Cliente Fisico.");
        }
        fechaConexao();
    }

    @Override
    public ClienteFisico selecionaClienteFisico(int cod) throws BancoException {
        Cliente cliente = selecionaCliente(cod);

        int codigo = cliente.getId_cliente();
        String nome = cliente.getNome_cliente();
        int tipo = cliente.getCod_tipo_cliente();

        abreConexao();

        ClienteFisico clienteFisico = null;
        preparaComandoSQL("select * from cliente_fisico where id_cliente = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codFisico = rs.getInt(1);
                String cpf = rs.getString(3);

                clienteFisico = new ClienteFisico(codigo, nome, cpf, tipo, codFisico);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção do Cliente Fisico");
        }
        fechaConexao();

        return clienteFisico;

    }
    
    @Override
    public ClienteFisico selecionaClienteFisicoCPF(String cpf)throws BancoException{
        ClienteFisico clientefisico = null;
        abreConexao();
        
        int codFisico=0;
        int codCliente=0;
        preparaComandoSQL("select * from cliente_fisico where cpf = ? ");
        try {
            pstmt.setString(1, cpf);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                codFisico = rs.getInt(1);
                codCliente= rs.getInt(2);                
            }
            preparaComandoSQL("select * from cliente where id_cliente = ?");
            
            pstmt.setInt(1,codFisico);
            rs= pstmt.executeQuery();
            if(rs.next()){
                String nome = rs.getString(2);
                int tipoCliente = rs.getInt(3);
                                               
                clientefisico = new ClienteFisico(codCliente, nome, cpf, tipoCliente, codFisico);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção do Cliente Fisico");
        }
        fechaConexao();
        return clientefisico;
        
    }
}
