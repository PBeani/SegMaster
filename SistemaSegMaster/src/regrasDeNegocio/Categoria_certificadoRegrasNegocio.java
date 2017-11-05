package regrasDeNegocio;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.CategoriaCertificadoDao;
import beans.CategoriaCertificado;
import dto.Usuario;
import regrasNegocio.NegocioException;
import utilidades.Log;

public class Categoria_certificadoRegrasNegocio {
	private CategoriaCertificadoDao categoriaCertificadoDao;

    public boolean cadastroCategoriaCertificado(CategoriaCertificado catCertificado) throws Exception {
        try {
        	//fazer funcao para buscar categoria certificado
            List<CategoriaCertificado> listaCategoriaCertificado = categoriaCertificadoDao.buscaCategoriaCertificadoDesc(catCertificado.getDesc_categoria_certificado());
            if (!listaCategoriaCertificado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Categoria certificado ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir categoria certificado
            categoriaCertificadoDao.insereCategoriaCertificado(catCertificado);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar categoria certificado");
        }
    }
    
    public CategoriaCertificado seleciona(int cod) throws Exception {
        try {
            return categoriaCertificadoDao.selecionaCategoriaCertificado(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void altera(CategoriaCertificado catCertificado) throws Exception {
        try {
        	categoriaCertificadoDao.alteraCategoriaCertificado(catCertificado);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public LinkedList<CategoriaCertificado> listaCategoriaCertificado() throws Exception {
        try {
            return categoriaCertificadoDao.listaCategoriaCertificado();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	categoriaCertificadoDao.removeCategoriaCertificado(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}
