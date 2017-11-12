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
            ClienteJuridico clienteJuridico = clienteJuridicoDao.selecionaClienteJuridicoCNPJ(cliente.getCnpj());
            if (clienteJuridico!=null) {
                JOptionPane.showMessageDialog(null, "CNPJ ja cadastrado");
                return false;
            }
            clienteJuridicoDao.insereClienteJuridico(cliente);
            return true;
        } catch (BancoException e) {
			throw new Exception("Falha ao cadastrar cliente juridico");
        }
    }
    
    public ClienteJuridico seleciona(int cod) throws Exception {
        try {
            return clienteJuridicoDao.selecionaClienteJuridico(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }  
}
