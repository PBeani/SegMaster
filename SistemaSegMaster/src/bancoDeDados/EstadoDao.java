package bancoDeDados;

import beans.Estado;

public interface EstadoDao {
    
    public void insereEstado(Estado e) throws BancoException;
//    public Estado selecionaEstado() throws BancoException;
}
