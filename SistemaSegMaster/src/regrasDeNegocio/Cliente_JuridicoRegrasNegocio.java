package regrasDeNegocio;

import java.util.List;


import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.ClienteJuridicoDao;
import beans.ClienteJuridico;

public class Cliente_JuridicoRegrasNegocio {
	private ClienteJuridicoDao clienteJuridicoDao;
	
    public boolean cadastroClienteJuridico(ClienteJuridico cliente) throws Exception {
        try {
        	//fazer funcao para listar clienteJuridico
            List<ClienteJuridico> listaClienteJuridico = clienteJuridicoDao.buscaClienteJuridicoCNPJ(cliente.getCnpj());
            if (!listaClienteJuridico.isEmpty()) {
                JOptionPane.showMessageDialog(null, "CNPJ ja cadastrado");
                return false;
            }
            clienteJuridicoDao.insereClienteJuridico(cliente);
            return true;
        } catch (BancoException e) {
			throw new Exception("Cliente ja cadastrado.");
        }
    }
}
