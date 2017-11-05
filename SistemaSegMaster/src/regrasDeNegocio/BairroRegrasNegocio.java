package regrasDeNegocio;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.GerenciadorBancoDados;
import beans.Bairro;

public class BairroRegrasNegocio {
	private GerenciadorBancoDados gerenciadorBancoDados;

    public boolean cadastroBairro(Bairro bairro) throws Exception {
        try {
        	//fazer funcao para listar Bairro
            List<Bairro> listaBairro = gerenciadorBancoDados.buscaBairroDesc(bairro.getDesc_bairro());
            if (!listaBairro.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bairro ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir bairro
            gerenciadorBancoDados.insereBairro(bairro);
            return true;
        } catch (BancoException e) {
			throw new Exception("Bairro ja cadastrado.");
        }
    }
    public Bairro seleciona(int cod) throws Exception {
        try {
            return bairroDao.selecionaBairro(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }  
    
    public void altera(Bairro bairro) throws Exception {
        try {
        	bairroDao.alteraBairro(bairro);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public LinkedList<Bairro> listaBairro() throws Exception {
        try {
            return bairroDao.listaBairro();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	bairroDao.removeBairro(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}
