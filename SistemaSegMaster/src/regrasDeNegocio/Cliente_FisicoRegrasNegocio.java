package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.ClienteFisicoDao;
import bancoDeDados.jdbc.ClienteFisicoDaoImpl;
import bancoDeDados.jdbc.EnderecoCDaoImpl;
import beans.ClienteFisico;

public class Cliente_FisicoRegrasNegocio {

    private ClienteFisicoDao clienteFisicoDao;

    public Cliente_FisicoRegrasNegocio() throws BancoException {
        this.clienteFisicoDao = new ClienteFisicoDaoImpl();
    }

    public int cadastroClienteFisico(ClienteFisico cliente) throws Exception {
        try {
            //fazer funcao para listar clienteFisico
            ClienteFisico clienteFisico = clienteFisicoDao.selecionaClienteFisicoCPF(cliente.getCpf());
            if (clienteFisico != null) {
                JOptionPane.showMessageDialog(null, "CPF ja cadastrado");
                return -1;
            }
            int key = clienteFisicoDao.insereClienteFisico(cliente);
            return key;
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
    
    public void atualizaClienteFisico(ClienteFisico cliente) throws Exception {
        clienteFisicoDao.atualizaFisico(cliente);
    }
}
