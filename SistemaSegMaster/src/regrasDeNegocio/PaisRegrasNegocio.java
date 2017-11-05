package regrasDeNegocio;

import java.util.LinkedList;
import java.util.List;


import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.PaisDao;
import beans.Pais;

public class PaisRegrasNegocio {
	private PaisDao paisDao;

    public boolean cadastroPais(Pais pais) throws Exception {
        try {
        	//fazer funcao para listar Pais
            List<Pais> listaPais = paisDao.buscaPaisSigla(pais.getSigla());
            if (!listaPais.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pais ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir pais
            paisDao.inserePais(pais);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar pais");
        }
    }
    
    public Pais seleciona(int cod) throws Exception {
        try {
            return paisDao.selecionaPais(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void altera(Pais pais) throws Exception {
        try {
        	paisDao.alteraPais(pais);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public LinkedList<Pais> listaPais() throws Exception {
        try {
            return paisDao.listaPais();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	paisDao.removePais(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}
