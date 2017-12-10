/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.TipoContatoDao;
import bancoDeDados.jdbc.TipoContatoDaoImpl;
import beans.TipoContato;
import java.util.LinkedList;
import javax.swing.JOptionPane;

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
    
    public boolean cadastro(TipoContato tipo) throws Exception {
        try {
        	//fazer funcao para buscar Hardware
            boolean existe = tipoContatoDaoImpl.existe(tipo.getDesc_tipo_contato());
            if (existe) {
                JOptionPane.showMessageDialog(null, "Tipo de contato ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir Hardware
            tipoContatoDaoImpl.insereTipoContato(tipo);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar tipo de contato");
        }
    }
    
    public TipoContato seleciona(int cod) throws Exception {
        try {
            return tipoContatoDaoImpl.selecionaTipoContato(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    } 
    
    public boolean altera(TipoContato tipo) throws Exception {
        try {
        	tipoContatoDaoImpl.alteraTipoContato(tipo);
                return true;
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	tipoContatoDaoImpl.removeTipoContato(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    public TipoContato seleciona(String s)throws BancoException{
        return tipoContatoDaoImpl.selecionaTipoContato(s);
    }
}
