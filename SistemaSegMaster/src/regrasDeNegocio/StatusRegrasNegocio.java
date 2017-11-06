/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.StatusComissaoDaoImpl;
import beans.StatusComissao;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author cliente
 */
public class StatusRegrasNegocio {
    private StatusComissaoDaoImpl statusDaoImpl;
    public StatusRegrasNegocio() throws BancoException {
        statusDaoImpl = new StatusComissaoDaoImpl();
    }
    
    public LinkedList<StatusComissao> listaStatusComissao() throws Exception {
        try {           
            return statusDaoImpl.listaStatusComissao();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public boolean cadastraStatusComissao(StatusComissao status) throws Exception{
        try{           
            boolean existeStatus= statusDaoImpl.existeStatusComissao(status.getDesc_status_comissao());
            if(existeStatus){
                JOptionPane.showMessageDialog(null, "Status de comissao ja cadastrado");
                return false;
            }
            statusDaoImpl.insereStatusComissao(status);
            return true;
        }catch (Exception e){
            throw new Exception("Erro ao cadastrar status");
        }
    }
    
    
}
