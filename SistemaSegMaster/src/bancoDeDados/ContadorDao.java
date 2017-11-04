package bancoDeDados;

import beans.Contador;

public interface ContadorDao {
    
    public void insereContador(Contador contador) throws BancoException;
}
