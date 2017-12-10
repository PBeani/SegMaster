package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import beans.Cliente;
import bancoDeDados.*;
import beans.ClientResult;

public class ClienteDaoImpl extends ConectorJDBC implements ClienteDao {

    public ClienteDaoImpl() throws BancoException {
        super();
    }

    @Override
    public int insereCliente(Cliente cliente) throws BancoException {
        int chave = -1;
        abreConexao();
        preparaComandoSQL(
                "insert into cliente (nome_cliente, id_tipo_cliente, id_endereco) values (?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS);
        try {
            pstmt.setString(1, cliente.getNome_cliente());
            pstmt.setInt(2, cliente.getCod_tipo_cliente());
            pstmt.setInt(3, cliente.getEndereco());
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
    public void atualizaCliente(Cliente cliente) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "update cliente set nome_cliente = ? where id_cliente = ? ");
        try {
            pstmt.setString(1, cliente.getNome_cliente());
            pstmt.setInt(2, cliente.getId_cliente());
            pstmt.execute();

        } catch (SQLException e) {
            throw new BancoException("Problema ao atualizar Cliente.");
        }
        fechaConexao();
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
    
    public Cliente selecionaClienteEnd(int cod) throws BancoException {
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
                int end = rs.getInt(4);

                cliente = new Cliente(codigo, nome, tipo, end);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção do Item.");
        }
        fechaConexao();

        return cliente;
    }

    @Override
    public LinkedList<ClientResult> listaCliente() throws BancoException {
        LinkedList<ClientResult> lista = new LinkedList<>();
        abreConexao();
        ClientResult cliente = null;
        preparaComandoSQL("select cliente.id_cliente, cliente.nome_cliente, cliente_fisico.cpf, cliente_juridico.cnpj, cliente_juridico.nome_empresa"
                + " from cliente"
                + " left join cliente_fisico on cliente.id_cliente = cliente_fisico.id_cliente"
                + " left join cliente_juridico on cliente.id_cliente = cliente_juridico.id_cliente");
        try {
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String cnpj = rs.getString(4);
                String empresa = rs.getString(5);

                String doc = cpf != null ? cpf : cnpj;
                String emp = empresa != null ? empresa : "-";

                cliente = new ClientResult(codigo, nome, doc, emp);
                lista.add(cliente);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problemas ao gerar lista Clientes");
        }
        fechaConexao();
        return lista;

    }

    @Override
    public LinkedList<ClientResult> buscaCliente(String s) throws BancoException {
        LinkedList<ClientResult> lista = new LinkedList<>();
        abreConexao();
        ClientResult cliente = null;
        preparaComandoSQL("select cliente.id_cliente, cliente.nome_cliente, cliente_fisico.cpf, cliente_juridico.cnpj, cliente_juridico.nome_empresa"
                + " from cliente"
                + " left join cliente_fisico on cliente.id_cliente = cliente_fisico.id_cliente"
                + " left join cliente_juridico on cliente.id_cliente = cliente_juridico.id_cliente"
                + " where cliente.nome_cliente LIKE ?");
        try {
            pstmt.setString(1, "%" + s + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String cnpj = rs.getString(4);
                String empresa = rs.getString(5);

                String doc = cpf != null ? cpf : cnpj;
                String emp = empresa != null ? empresa : "-";

                cliente = new ClientResult(codigo, nome, doc, emp);
                lista.add(cliente);
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problemas ao gerar lista Clientes");
        }
        fechaConexao();
        return lista;

    }

    @Override
    public void remove(Cliente cliente) throws BancoException{
        abreConexao();

        preparaComandoSQL("delete from cliente where id_cliente= ?");
        try {
            pstmt.setInt(1, cliente.getId_cliente());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção do cliente.");
        }

        fechaConexao();
    }

}
