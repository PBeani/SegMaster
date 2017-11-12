/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.TipoCertificadoDaoImpl;
import beans.TipoCertificado;
import beans.TipoCliente;
import java.util.LinkedList;
import javax.swing.JOptionPane;

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
    
     public boolean cadastro(TipoCertificado tipo) throws Exception {
        try {
        	//fazer funcao para buscar Hardware
            boolean existe = tipoCertificado.existe(tipo.getDesc_tipo_certificado());
            if (existe) {
                JOptionPane.showMessageDialog(null, "Tipo de certificado ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir Hardware
            tipoCertificado.insereTipoCertificado(tipo);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar tipo de certificado");
        }
    }
    
    public TipoCertificado seleciona(int cod) throws Exception {
        try {
            return tipoCertificado.selecionaTipoCertificado(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    } 
    
    public boolean altera(TipoCertificado tipo) throws Exception {
        try {
        	tipoCertificado.alteraTipoCertificado(tipo);
                return true;
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	tipoCertificado.removeTipoCertificado(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
}
