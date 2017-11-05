package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
//import bancoDeDados.CategoriaCertificadoDao;
//import beans.CategoriaCertificado;

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
}
