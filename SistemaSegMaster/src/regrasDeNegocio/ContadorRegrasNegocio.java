/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.ContadorDaoImpl;
import beans.Contador;
import beans.Contato;
import beans.ContatoCliente;

/**
 *
 * @author cliente
 */
public class ContadorRegrasNegocio {
    private ContadorDaoImpl cont;
    public ContadorRegrasNegocio() throws BancoException{
        cont = new ContadorDaoImpl();
    }
    
    public int  insereContador(Contador contador) throws BancoException{        
        return cont.insereContador(contador);
    }
    
    public int insereContatoContador(int c,int d)throws BancoException{
        return cont.insereContatoContador(c,d);
    }
}
