/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados;

import beans.Endereco;

/**
 *
 * @author cliente
 */
public interface EnderecoDao {
    public int insereEndereco(Endereco end) throws BancoException;
    public boolean existeEndereco(Endereco end) throws BancoException;
    public int alteraEndereco(Endereco end)throws BancoException;
    public Endereco seleciona(int cod)throws BancoException;
    public boolean excluir(Endereco end) throws BancoException;
 }
