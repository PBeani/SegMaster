package bancoDeDados;

import beans.ClientResult;
import java.util.LinkedList;


import beans.Cliente;

public interface ClienteDao {

    public int insereCliente(Cliente cliente) throws BancoException;
    
    public void atualizaCliente(Cliente cliente) throws BancoException;
    
    public Cliente selecionaCliente(int cod) throws BancoException;
    
    public LinkedList<ClientResult> listaCliente() throws BancoException;
    
    public LinkedList<ClientResult> buscaCliente(String s) throws BancoException;
    
    public void remove(Cliente cliente) throws BancoException;
    
}
