package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.GerenciadorBancoDados;
import beans.Hierarquia;

public class HierarquiaRegrasNegocio {
	private GerenciadorBancoDados gerenciadorBancoDados;

    public boolean cadastroHardware(Hierarquia hierarquia) throws Exception {
        try {
        	//fazer funcao para buscar Hierarquia
            List<Hierarquia> listaHierarquia = gerenciadorBancoDados.buscaHierarquiaDesc(hierarquia.getDesc_hierarquia());
            if (!listaHierarquia.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hierarquia ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir Hardware
            gerenciadorBancoDados.insereHierarquia(hierarquia);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar Hierarquia");
        }
    }
}
