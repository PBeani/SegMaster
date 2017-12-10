package bancoDeDados;

import beans.Contador;
import beans.Contato;
import beans.ContatoCliente;
import beans.DadosContato;

public interface ContadorDao {
    
    public int insereContador(Contador contador) throws BancoException;
    //public boolean existeContador(String nome) throws BancoException;
    public int insereContatoContador(int c,int d)throws BancoException;

}
