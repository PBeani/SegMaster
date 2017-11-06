/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.TipoContatoDaoImpl;
import beans.TipoContato;
import java.util.LinkedList;

/**
 *
 * @author cliente
 */
public class TipoContatoRegrasNegocio {
    private TipoContatoDaoImpl tipoContatoDaoImpl;
    public TipoContatoRegrasNegocio() throws BancoException {
        tipoContatoDaoImpl = new TipoContatoDaoImpl();
    }
    
    public LinkedList<TipoContato> listaTipoContato() throws Exception{
            try {
                return tipoContatoDaoImpl.listaTipoContato();
            } catch (BancoException e) {
                throw new Exception("Nao foi possivel acessar o banco de dados.");
            }
    
    }
    
    
}
