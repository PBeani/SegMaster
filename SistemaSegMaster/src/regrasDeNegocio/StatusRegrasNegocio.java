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
    
    
}
