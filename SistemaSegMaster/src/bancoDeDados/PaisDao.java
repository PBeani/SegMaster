package bancoDeDados;

import beans.Pais;

import java.util.LinkedList;

public interface PaisDao {
    
    public void inserePais(Pais p) throws BancoException;
    
    public void alteraPais(Pais p) throws BancoException;

    public Pais selecionaPais(int cod) throws BancoException;

    public LinkedList<Pais> listaEstado() throws BancoException;

    public void removePais(int cod) throws BancoException;
}
