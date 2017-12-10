package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import beans.Cliente;
import bancoDeDados.BancoException;
import bancoDeDados.ClienteDao;
import bancoDeDados.ClienteFisicoDao;
import bancoDeDados.jdbc.ClienteDaoImpl;
import beans.ClientResult;
import java.util.LinkedList;

public class ClienteRegrasNegocio {

    private ClienteDaoImpl clienteDao;

    public ClienteRegrasNegocio() throws BancoException {
        this.clienteDao = new ClienteDaoImpl();
    }

    public int cadastroCliente(Cliente cliente) throws Exception {
        try {
            //fazer funcao para listar clientes
            Cliente clienteID = clienteDao.selecionaCliente(cliente.getId_cliente());
            if (clienteID != null) {
                JOptionPane.showMessageDialog(null, "Cliente ja cadastrado");
                return -1;
            }
            int key = clienteDao.insereCliente(cliente);

            return key;
        } catch (BancoException e) {
            throw new Exception("Falha ao cadastrar cliente");
        }
    }

    public Cliente seleciona(int cod) throws Exception {
        try {
            return clienteDao.selecionaClienteEnd(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public LinkedList<ClientResult> listaClientes() throws Exception {
        try {
            return clienteDao.listaCliente();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public LinkedList<ClientResult> buscaClientes(String s) throws Exception {
        try {
            return clienteDao.buscaCliente(s);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public int remove(int i) throws Exception {
        try {
            Cliente cliente = clienteDao.selecionaClienteEnd(i);
            clienteDao.remove(cliente);
            return cliente.getEndereco();
        } catch (BancoException e) {
            throw new Exception("Falha ao remover cliente");
        }
    }
}
