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
    public void insereClienteFisico(ClienteFisico cliente) throws BancoException {
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
}
