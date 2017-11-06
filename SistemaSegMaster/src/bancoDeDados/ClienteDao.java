package bancoDeDados;

import java.util.LinkedList;


import beans.Cliente;

public interface ClienteDao {

    public int insereCliente(Cliente cliente) throws BancoException;
    
    public Cliente selecionaCliente(int cod) throws BancoException;
    
    public LinkedList<Cliente> listaCliente()throws BancoException;
    
}
