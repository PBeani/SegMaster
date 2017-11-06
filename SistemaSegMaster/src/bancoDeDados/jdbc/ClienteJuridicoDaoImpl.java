package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import beans.Cliente;
import beans.ClienteJuridico;
import bancoDeDados.*;

public class ClienteJuridicoDaoImpl extends ClienteDaoImpl implements ClienteJuridicoDao {

    public ClienteJuridicoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void insereClienteJuridico(ClienteJuridico cliente) throws BancoException {
        int chave = insereCliente(cliente);
        abreConexao();

        preparaComandoSQL(
                "insert into cliente_juridico(cnpj, nome_empresa, id_cliente) values (?, ?, ?)");
        try {
            pstmt.setString(1, cliente.getCnpj());
            pstmt.setString(2, cliente.getNomeEmpresa());
            pstmt.setInt(3, chave);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar Cliente Juridico.");
        }
        fechaConexao();
    }

    @Override
    public ClienteJuridico selecionaClienteJuridico(int cod) throws BancoException {
        Cliente cliente = selecionaCliente(cod);

        int codigo = cliente.getId_cliente();
        String nome = cliente.getNome_cliente();
        int tipo = cliente.getCod_tipo_cliente();

        abreConexao();

        ClienteJuridico clienteJuridico = null;
        preparaComandoSQL("select * from cliente_juridico where id_cliente = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codJuridico = rs.getInt(1);
                String cnpj = rs.getString(3);
                String empresa = rs.getString(4);

                clienteJuridico = new ClienteJuridico(codigo, codJuridico, cnpj, empresa, nome, tipo);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção do Cliente Juridico");
        }
        fechaConexao();

        return clienteJuridico;

    }
    public ClienteJuridico selecionaClienteJuridicoCNPJ (String cnpj) throws BancoException{
        ClienteJuridico clientejuridico = null;
        abreConexao();
        
        int codJuridico=0;
        int codCliente=0;
        String nomeEmpresa = null;
        preparaComandoSQL("select * from cliente_juridico where cnpj = ? ");
        try {
            pstmt.setString(1, cnpj);
            rs = pstmt.executeQuery();
            if (rs.next()) {
               codJuridico= rs.getInt(1);
               codCliente = rs.getInt(2);
               nomeEmpresa = rs.getString(4);
            }
            preparaComandoSQL("select * from cliente where id_cliente = ?");
            
            pstmt.setInt(1,codJuridico);
            rs= pstmt.executeQuery();
            if(rs.next()){
                String nome = rs.getString(2);
                int tipoCliente = rs.getInt(3);
                                               
                clientejuridico = new ClienteJuridico(codCliente,codJuridico, cnpj, nomeEmpresa,nome, tipoCliente);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção do Cliente Fisico");
        }
        fechaConexao();
        return clientejuridico;
    }
}
