package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.GerenciadorBancoDados;
import beans.Categoria_certificado;

public class Categoria_certificadoRegrasNegocio {
	private GerenciadorBancoDados gerenciadorBancoDados;

    public boolean cadastroCategoria_certificado(Categoria_certificado catCertificado) throws Exception {
        try {
        	//fazer funcao para buscar categoria certificado
            List<Categoria_certificado> listaCategoria_certificado = gerenciadorBancoDados.buscaCategoria_certificadoDesc(catCertificado.getDesc_categoria_certificado());
            if (!listaCategoria_certificado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Categoria certificado ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir categoria certificado
            gerenciadorBancoDados.insereCategoria_certificado(catCertificado);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar categoria certificado");
        }
    }
}
