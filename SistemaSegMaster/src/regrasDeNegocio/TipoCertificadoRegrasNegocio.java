/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.TipoCertificadoDaoImpl;
import beans.TipoCertificado;
import java.util.LinkedList;

/**
 *
 * @author cliente
 */
public class TipoCertificadoRegrasNegocio {
        private TipoCertificadoDaoImpl tipoCertificado;

    public TipoCertificadoRegrasNegocio() throws BancoException {
        this.tipoCertificado = new TipoCertificadoDaoImpl();
    }
    public LinkedList<TipoCertificado> listaTipoCertificado () throws Exception{
        try {
                return tipoCertificado.listaTipoCertificado();
            } catch (BancoException e) {
                throw new Exception("Nao foi possivel acessar o banco de dados.");
            }
    }
    
    
}
