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
import java.util.LinkedList;

/**
 *
 * @author cliente
 */
public class ContadorRegrasNegocio {

    private ContadorDaoImpl cont;

    public ContadorRegrasNegocio() throws BancoException {
        cont = new ContadorDaoImpl();
    }

    public int insereContador(Contador contador) throws BancoException {
        int x = cont.existeContador(contador.getNomeContador());        
        if (x != -1) {
            contador.setId_contador(x);
            cont.insereContadorContabilidade(contador);
            return x;
        }
        int n = cont.insereContador(contador);
        contador.setId_contador(n);
        cont.insereContadorContabilidade(contador);//insere na tabela contabilidade_contador
        return n;
    }

    public int insereContatoContador(int c, int d) throws BancoException {
        return cont.insereContatoContador(c, d);
    }

    public LinkedList<Contador> listaContadores(String nome) throws BancoException {
        return cont.listaContador(nome);
    }
}
