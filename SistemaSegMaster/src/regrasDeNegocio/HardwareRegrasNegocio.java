package regrasDeNegocio;

import java.util.List;


import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.HardwareDao;
import beans.Hardware;


public class HardwareRegrasNegocio {
	private GerenciadorBancoDados gerenciadorBancoDados;

    public boolean cadastroHardware(Hardware hardware) throws Exception {
        try {
        	//fazer funcao para buscar Hardware
            List<Hardware> listaHardware = gerenciadorBancoDados.buscaHardwareDesc(hardware.getDesc_hardware());
            if (!listaHardware.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hardware ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir Hardware
            gerenciadorBancoDados.insereHardware(hardware);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar Hardware");
        }
    }
}
