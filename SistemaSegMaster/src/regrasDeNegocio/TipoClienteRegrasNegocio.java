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
import javax.swing.JOptionPane;

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
    
    public boolean cadastro(TipoCliente tipo) throws Exception {
        try {
        	//fazer funcao para buscar Hardware
            boolean existe = tipoClienteDaoImpl.existe(tipo.getDesc_tipo_cliente());
            if (existe) {
                JOptionPane.showMessageDialog(null, "Tipo de cliente ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir Hardware
            tipoClienteDaoImpl.insereTipoCliente(tipo);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar tipo de cliente");
        }
    }
    
    public TipoCliente seleciona(int cod) throws Exception {
        try {
            return tipoClienteDaoImpl.selecionaTipoCliente(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    } 
    
    public boolean altera(TipoCliente tipo) throws Exception {
        try {
        	tipoClienteDaoImpl.alteraTipoCliente(tipo);
                return true;
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	tipoClienteDaoImpl.removeTipoCliente(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    
}
