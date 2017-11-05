package regrasDeNegocio;

import java.util.List;


import javax.swing.JOptionPane;

import beans.Cliente;
import bancoDeDados.BancoException;
import bancoDeDados.ClienteDao;

public class ClienteRegrasNegocio {
	private ClienteDao clienteDao;

	
    public boolean cadastroCliente(Cliente cliente) throws Exception {
        try {
        	//fazer funcao para listar clientes
            List<Cliente> listaCliente = clienteDao.buscaClienteId(cliente.getId_cliente());
            if (!listaCliente.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Cliente ja cadastrado");
                return false;
            }
            clienteDao.insereCliente(cliente);
            return true;
        } catch (BancoException e) {
			throw new Exception("Cliente ja cadastrado.");
        }
    }
    
    
}
