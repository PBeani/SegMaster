package regrasDeNegocio;

import java.util.List;


import javax.swing.JOptionPane;

import beans.Cliente;
import bancoDeDados.BancoException;
import bancoDeDados.ClienteDao;
import bancoDeDados.jdbc.ClienteDaoImpl;
import java.util.LinkedList;

public class ClienteRegrasNegocio {
	private ClienteDaoImpl clienteDao;

    public ClienteRegrasNegocio()throws BancoException{
        this.clienteDao = new ClienteDaoImpl();
    }

	
    public boolean cadastroCliente(Cliente cliente) throws Exception {
        try {
        	//fazer funcao para listar clientes
            Cliente clienteID = clienteDao.selecionaCliente(cliente.getId_cliente());
            if (clienteID!=null) {
                JOptionPane.showMessageDialog(null, "Cliente ja cadastrado");
                return false;
            }
            clienteDao.insereCliente(cliente);
            return true;
        } catch (BancoException e) {
			throw new Exception("Falha ao cadastrar cliente");
        }
    }
    
    public Cliente seleciona(int cod) throws Exception {
        try {
            return clienteDao.selecionaCliente(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public LinkedList<Cliente> listaCliente() throws Exception{
        try{
            return clienteDao.listaCliente();
        }catch (BancoException e){
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}

