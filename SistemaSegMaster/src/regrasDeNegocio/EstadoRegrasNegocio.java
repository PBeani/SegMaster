package regrasDeNegocio;

import java.util.List;


import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.EstadoDao;
import beans.Estado;

public class EstadoRegrasNegocio {
	private EstadoDao estadoDao;

    public boolean cadastroEstado(Estado estado) throws Exception {
        try {
        	//fazer funcao para listar Estado
            List<Estado> listaEstado = estadoDao.buscaEstadoSigla(estado.getSigla());
            if (!listaEstado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Estado ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir estado
            estadoDao.insereEstado(estado);
            return true;
        } catch (BancoException e) {
			throw new Exception("Estado ja cadastrado.");
        }
    }
}
