package regrasDeNegocio;

import java.util.LinkedList;
import java.util.List;


import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.HardwareDao;
import beans.Hardware;


public class HardwareRegrasNegocio {
	private HardwareDao hardwareDao;

    public boolean cadastroHardware(Hardware hardware) throws Exception {
        try {
        	//fazer funcao para buscar Hardware
            List<Hardware> listaHardware = hardwareDao.buscaHardwareDesc(hardware.getDesc_hardware());
            if (!listaHardware.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hardware ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir Hardware
            hardwareDao.insereHardware(hardware);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar Hardware");
        }
    }
    
    public Hardware seleciona(int cod) throws Exception {
        try {
            return hardwareDao.selecionaHardware(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    } 
    
    public void altera(Hardware hardware) throws Exception {
        try {
        	hardwareDao.alteraHardware(hardware);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public LinkedList<Hardware> listaHardware() throws Exception {
        try {
            return hardwareDao.listaHardware();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	hardwareDao.removeHardware(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}
