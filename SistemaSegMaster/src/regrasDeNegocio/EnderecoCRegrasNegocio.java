/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.EnderecoCDao;
import bancoDeDados.jdbc.ClienteDaoImpl;
import bancoDeDados.jdbc.EnderecoCDaoImpl;
import beans.Cliente;
import beans.Endereco;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class EnderecoCRegrasNegocio {

    private EnderecoCDaoImpl endDao;

    public EnderecoCRegrasNegocio() throws BancoException {
        this.endDao = new EnderecoCDaoImpl();
    }

    public int cadastro(Endereco e) throws Exception {

        int key = endDao.insereEndereco(e);
        return key;

    }
    
    public void atualiza(Endereco e) throws Exception {
        endDao.atualiza(e);
    }

    public void remove(int i) throws Exception {
        try {
            endDao.remove(i);
        } catch (BancoException e) {
            throw new Exception("Falha ao remover estado");
        }
    }
    
    public Endereco seleciona(int i) throws Exception {
        try {
            return endDao.seleciona(i);
        } catch (BancoException e) {
            throw new Exception("Falha ao selecionar estado");
        }
    }
}
