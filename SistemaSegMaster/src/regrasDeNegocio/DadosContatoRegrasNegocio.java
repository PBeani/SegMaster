/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.DadosContatoDaoImpl;
import beans.ContatoCliente;
import beans.DadosContato;
import java.util.LinkedList;

/**
 *
 * @author pedro
 */
public class DadosContatoRegrasNegocio {

    private DadosContatoDaoImpl dados;

    public DadosContatoRegrasNegocio() throws BancoException {
        this.dados = new DadosContatoDaoImpl();
    }

    public int cadastro(DadosContato e) throws Exception {

        int key = dados.insereDados(e);
        return key;

    }
    
    public void atualiza(DadosContato e) throws Exception {
        dados.atualiza(e);
    }
    
    public void cadastroCliente(ContatoCliente c) throws Exception {
        dados.insereCliente(c);
    }
    public void cadastroContador(ContatoCliente c)throws BancoException{
        dados.insereContador(c);
    }
    
    public LinkedList<DadosContato> listaContatosCliente(int cod) throws BancoException {
        return dados.listaContatosCliente(cod);
    }
    public String selecionaDado (int cod_contador, int tipoContato)throws BancoException{
        return dados.selecionaDados(cod_contador,tipoContato);
    }
    
}
