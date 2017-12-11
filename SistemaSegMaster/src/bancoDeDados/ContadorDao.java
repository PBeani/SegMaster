package bancoDeDados;

import beans.Contador;
import beans.Contato;
import beans.ContatoCliente;
import beans.DadosContato;
import java.util.LinkedList;

public interface ContadorDao {
    
    public int insereContador(Contador contador) throws BancoException;
    
    public int existeContador(String nome) throws BancoException;
    
    public boolean excluiContador(Contador contador)throws BancoException;
    
    public int insereContatoContador(int c,int d)throws BancoException;
    
    public void insereContadorContabilidade(Contador contador)throws BancoException;
    
    public LinkedList<Contador> listaContador(String nome) throws BancoException;
    
    public int altera(Contador contador)throws BancoException;
    
    //public Contador seleciona(int cod)throws BancoException;

}
