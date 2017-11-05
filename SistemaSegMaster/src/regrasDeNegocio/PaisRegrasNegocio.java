package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.GerenciadorBancoDados;
import beans.Pais;

public class PaisRegrasNegocio {
	private GerenciadorBancoDados gerenciadorBancoDados;

    public boolean cadastroPais(Pais pais) throws Exception {
        try {
        	//fazer funcao para listar Pais
            List<Pais> listaPais = gerenciadorBancoDados.buscaPaisSigla(pais.getSigla());
            if (!listaPais.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pais ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir pais
            gerenciadorBancoDados.inserePais(pais);
            return true;
        } catch (BancoException e) {
			throw new Exception("Pais ja cadastrado.");
        }
    }
}
