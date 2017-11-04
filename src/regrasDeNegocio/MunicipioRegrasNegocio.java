package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.GerenciadorBancoDados;
import beans.Municipio;

public class MunicipioRegrasNegocio {
	private GerenciadorBancoDados gerenciadorBancoDados;

    public boolean cadastroMunicipio(Municipio municipio) throws Exception {
        try {
        	//fazer funcao para listar Municipio
            List<Municipio> listaMunicipio = gerenciadorBancoDados.buscaMunicipioDesc(municipio.getDescricao());
            if (!listaMunicipio.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Municipio ja cadastrado");
                return false;
            }
            
            //alterar a funcao para ser INSEREMUNICIPIO
            gerenciadorBancoDados.insereCidade();
            return true;
        } catch (BancoException e) {
			throw new Exception("Municipio ja cadastrado.");
        }
    }
}
