/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.ContabilidadeDaoImpl;
import beans.Contabilidade;
import beans.Municipio;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author cliente
 */
public class ContabilidadeRegrasNegocio {

    private ContabilidadeDaoImpl cat;

    public ContabilidadeRegrasNegocio() throws BancoException {
        this.cat = new ContabilidadeDaoImpl();
    }

    public boolean cadastroContabilidade(Contabilidade contabilidade) throws BancoException {
       
            boolean existeContabilidade = cat.existeContabilidade(contabilidade);
            if (existeContabilidade) {
                return false;
            }
            cat.insereContabilidade(contabilidade);
            return true;

        
    }
    
    public void alteraContabilidade(Contabilidade contabilidade)throws BancoException{
        cat.alteraContabilidade(contabilidade);
    }
    
    public LinkedList<Contabilidade> listaContabilidade(Municipio muni)throws BancoException{
        
        return cat.listaContabilidade(muni);
        
    }
    public LinkedList<Contabilidade> listaContabilidade(String nome)throws BancoException{
        return cat.listaContabilidade(nome);
    }
    
    public Contabilidade seleciona(int cod)throws BancoException{
        return cat.seleciona(cod);
    }
    public LinkedList<Contabilidade> listaContabilidade()throws BancoException{
        return cat.listaContabilidade();
        
    }
    public boolean excluir(Contabilidade cont)throws BancoException{
        return cat.excluir(cont);
    }

}
