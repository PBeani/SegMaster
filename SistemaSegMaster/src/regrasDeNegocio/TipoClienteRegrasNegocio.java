/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.TipoClienteDaoImpl;
import beans.TipoCliente;
import java.util.LinkedList;

/**
 *
 * @author cliente
 */
public class TipoClienteRegrasNegocio {
private TipoClienteDaoImpl tipoClienteDaoImpl;
    public TipoClienteRegrasNegocio() throws BancoException {
        tipoClienteDaoImpl = new TipoClienteDaoImpl();
    }
        
    public LinkedList<TipoCliente> listaTipoCliente() throws Exception{
        try {
                return tipoClienteDaoImpl.listaTipoCliente();
            } catch (BancoException e) {
                throw new Exception("Nao foi possivel acessar o banco de dados.");
            }
    }
    
    
    
}
