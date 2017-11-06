package regrasDeNegocio;

import java.util.LinkedList;
import java.util.List;


import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.MunicipioDao;
import beans.Municipio;

public class MunicipioRegrasNegocio {
	private MunicipioDao municipioDao;

    public boolean cadastroMunicipio(Municipio municipio) throws Exception {
        try {
        	//fazer funcao para listar Municipio
            boolean existeMunicipio = municipioDao.existeMunicipio(municipio.getDescricao());
            if (existeMunicipio) {
                JOptionPane.showMessageDialog(null, "Municipio ja cadastrado");
                return false;
            }
            
            //alterar a funcao para ser INSEREMUNICIPIO
            municipioDao.insereMunicipio(municipio);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar municipio");
        }
    }
    
    public Municipio seleciona(int cod) throws Exception {
        try {
            return municipioDao.selecionaMunicipio(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void altera(Municipio municipio) throws Exception {
        try {
        	municipioDao.alteraMunicipio(municipio);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public LinkedList<Municipio> listaMunicipio() throws Exception {
        try {
            return municipioDao.listaMunicipio();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	municipioDao.removeMunicipio(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}
