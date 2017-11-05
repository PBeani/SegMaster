package regrasDeNegocio;

import java.util.LinkedList;
import java.util.List;


import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.HierarquiaDao;
import beans.Hierarquia;

public class HierarquiaRegrasNegocio {
	private HierarquiaDao hierarquiaDao;

    public boolean cadastroHardware(Hierarquia hierarquia) throws Exception {
        try {
        	//fazer funcao para buscar Hierarquia
            List<Hierarquia> listaHierarquia = hierarquiaDao.buscaHierarquiaDesc(hierarquia.getDesc_hierarquia());
            if (!listaHierarquia.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hierarquia ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir Hardware
            hierarquiaDao.insereHierarquia(hierarquia);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar Hierarquia");
        }
    }
    
    public Hierarquia seleciona(int cod) throws Exception {
        try {
            return hierarquiaDao.selecionaHierarquia(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void altera(Hierarquia hierarquia) throws Exception {
        try {
        	hierarquiaDao.alteraHierarquia(hierarquia);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public LinkedList<Hierarquia> listaHierarquia() throws Exception {
        try {
            return hierarquiaDao.listaHierarquia();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	hierarquiaDao.removeHierarquia(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}
