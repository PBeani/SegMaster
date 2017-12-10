package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.ClienteJuridicoDao;
import bancoDeDados.jdbc.ClienteJuridicoDaoImpl;
import bancoDeDados.jdbc.EnderecoCDaoImpl;
import beans.ClienteJuridico;

public class Cliente_JuridicoRegrasNegocio {

    private ClienteJuridicoDao clienteJuridicoDao;
    
    public Cliente_JuridicoRegrasNegocio() throws BancoException {
        this.clienteJuridicoDao = new ClienteJuridicoDaoImpl();
    }
    
    public int cadastroClienteJuridico(ClienteJuridico cliente) throws Exception {
        try {
            //fazer funcao para listar clienteJuridico
            ClienteJuridico clienteJuridico = clienteJuridicoDao.selecionaClienteJuridicoCNPJ(cliente.getCnpj());
            if (clienteJuridico != null) {
                JOptionPane.showMessageDialog(null, "CNPJ ja cadastrado");
                return -1;
            }
            int key = clienteJuridicoDao.insereClienteJuridico(cliente);
            return key;
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
    
    public void atualizaClienteJuridico(ClienteJuridico cliente) throws Exception {
        clienteJuridicoDao.atualizaClienteJuridico(cliente);
    }
}
