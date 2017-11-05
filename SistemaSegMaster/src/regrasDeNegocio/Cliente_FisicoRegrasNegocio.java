package regrasDeNegocio;

import java.util.List;


import javax.swing.JOptionPane;

import bancoDeDados.BancoException;


public class Cliente_FisicoRegrasNegocio {
	private ClienteFisicoDao clienteFisicoDao;
	
    public boolean cadastroClienteFisico(ClienteFisico cliente) throws Exception {
        try {
        	//fazer funcao para listar clienteFisico
            List<ClienteFisico> listaClienteFisico = clienteFisicoDao.buscaClienteFisicoCPF(cliente.getCpf());
            if (!listaClienteFisico.isEmpty()) {
                JOptionPane.showMessageDialog(null, "CPF ja cadastrado");
                return false;
            }
            clienteFisicoDao.insereClienteFisico(cliente);
            return true;
        } catch (BancoException e) {
			throw new Exception("Falha ao cadastrar cliente");
        }
    }
    
    public ClienteFisico seleciona(int cod) throws Exception {
        try {
            return clienteFisicoDao.selecionaClienteFisico(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }  
}