package bancoDeDados;

import beans.TipoCliente;
import java.util.LinkedList;

public interface TipoClienteDao {

    public void insereTipoCliente(TipoCliente c) throws BancoException;

    public void alteraTipoCliente(TipoCliente c) throws BancoException;

    public TipoCliente selecionaTipoCliente(int cod) throws BancoException;

    public LinkedList<TipoCliente> listaTipoCliente() throws BancoException;

    public void removeTipoCliente(int cod) throws BancoException;
    
    public boolean existe(String s)throws BancoException;
}
