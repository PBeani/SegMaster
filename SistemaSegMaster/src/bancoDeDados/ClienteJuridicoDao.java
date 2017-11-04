package bancoDeDados;

import java.util.LinkedList;

import beans.ClienteJuridico;

public interface ClienteJuridicoDao {

    public void insereClienteJuridico(ClienteJuridico cliente) throws BancoException;
    public ClienteJuridico selecionaClienteJuridico(int cod) throws BancoException;
}
