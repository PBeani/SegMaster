/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.EnderecoDaoImpl;
import beans.Endereco;
import javax.swing.JOptionPane;

/**
 *
 * @author cliente
 */
public class EnderecoRegrasNegocio {

    private EnderecoDaoImpl end;

    public EnderecoRegrasNegocio() throws BancoException {
        end = new EnderecoDaoImpl();
    }

    public boolean excluiEndereco(Endereco endereco) throws BancoException {
        
        return end.excluir(endereco);
        
    }

    public int alteraEndereco(Endereco endereco) throws BancoException {
        return end.alteraEndereco(endereco);
    }

    public int cadastroEndereco(Endereco endereco) throws BancoException {

        if (end.existeEndereco(endereco)) {
            return -1;
        }
        return end.insereEndereco(endereco);

    }

    public Endereco selecionaEndereco(int cod) throws BancoException {
        return end.seleciona(cod);
    }

}
