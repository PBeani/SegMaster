/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados;

import beans.Contabilidade;
import beans.Municipio;
import java.util.LinkedList;

/**
 *
 * @author cliente
 */
public interface ContabilidadeDao {
    public boolean existeContabilidade(Contabilidade c) throws BancoException;
    
    public void insereContabilidade(Contabilidade c) throws BancoException;
    
    public LinkedList<Contabilidade> listaContabilidade(Municipio c) throws BancoException;
    public LinkedList<Contabilidade> listaContabilidade() throws BancoException;
    public void alteraContabilidade (Contabilidade c) throws BancoException;
    public Contabilidade seleciona(int cod)throws BancoException;
    
    public boolean excluir(Contabilidade c)throws BancoException;
}


