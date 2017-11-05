package regrasDeNegocio;

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
}
