package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.GerenciadorBancoDados;
import beans.Cliente_Fisico;

public class Cliente_FisicoRegrasNegocio {
	private GerenciadorBancoDados gerenciadorBancoDados;
	
    public boolean cadastroCliente_Fisico(Cliente_Fisico cliente) throws Exception {
        try {
        	//fazer funcao para listar clienteFisico
            List<Cliente_Fisico> listaClienteFisico = gerenciadorBancoDados.buscaClienteFisicoCPF(cliente.getCpf());
            if (!listaClienteFisico.isEmpty()) {
                JOptionPane.showMessageDialog(null, "CPF ja cadastrado");
                return false;
            }
            gerenciadorBancoDados.insereClienteFisico(cliente);
            return true;
        } catch (BancoException e) {
			throw new Exception("Falha ao cadastrar cliente");
        }
    }
    
}