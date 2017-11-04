package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import beans.Cliente;
import bancoDeDados.BancoException;
import bancoDeDados.GerenciadorBancoDados;

public class ClienteRegrasNegocio {
	private GerenciadorBancoDados gerenciadorBancoDados;

	
    public boolean cadastroCliente(Cliente cliente) throws Exception {
        try {
        	//fazer funcao para listar clientes
            List<Cliente> listaCliente = gerenciadorBancoDados.buscaClienteId(cliente.getId_cliente());
            if (!listaCliente.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Cliente ja cadastrado");
                return false;
            }
            gerenciadorBancoDados.insereCliente(cliente);
            return true;
        } catch (BancoException e) {
			throw new Exception("Cliente ja cadastrado.");
        }
    }
    
    
}
