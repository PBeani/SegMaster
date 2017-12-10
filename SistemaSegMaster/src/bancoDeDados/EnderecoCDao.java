/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados;

import beans.Endereco;
/**
 *
 * @author pedro
 */
public interface EnderecoCDao {
    
    public int insereEndereco(Endereco e) throws BancoException;
    
    public void atualiza(Endereco e) throws BancoException;
    
    public Endereco seleciona(int i) throws BancoException;
    
    public void remove(int i) throws BancoException;
    
}
