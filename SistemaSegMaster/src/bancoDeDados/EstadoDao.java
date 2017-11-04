package bancoDeDados;

import beans.Estado;
import java.util.LinkedList;

public interface EstadoDao {
    
    public void insereEstado(Estado e) throws BancoException;
    
    public void alteraEstado(Estado e) throws BancoException;

    public Estado selecionaEstado(int cod) throws BancoException;

    public LinkedList<Estado> listaEstado() throws BancoException;

    public void removeEstado(int cod) throws BancoException;
}
