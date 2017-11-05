package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.GerenciadorBancoDados;
import beans.Cliente_Juridico;

public class Cliente_JuridicoRegrasNegocio {
	private GerenciadorBancoDados gerenciadorBancoDados;
	
    public boolean cadastroCliente_Juridico(Cliente_Juridico cliente) throws Exception {
        try {
        	//fazer funcao para listar clienteJuridico
            List<Cliente_Juridico> listaClienteJuridico = gerenciadorBancoDados.buscaClienteJuridicoCNPJ(cliente.getCnpj());
            if (!listaClienteJuridico.isEmpty()) {
                JOptionPane.showMessageDialog(null, "CNPJ ja cadastrado");
                return false;
            }
            gerenciadorBancoDados.insereClienteJuridico(cliente);
            return true;
        } catch (BancoException e) {
			throw new Exception("Cliente ja cadastrado.");
        }
    }
}
