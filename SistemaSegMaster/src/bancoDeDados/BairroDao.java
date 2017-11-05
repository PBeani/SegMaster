package bancoDeDados;

import beans.Bairro;

import java.util.LinkedList;

public interface BairroDao {
    
    public void insereBairro(Bairro bairro) throws BancoException;
    
    public void alteraBairro(Bairro bairro) throws BancoException;

    public Bairro selecionaBairro(int cod) throws BancoException;

    public LinkedList<Bairro> listaEstado() throws BancoException;

    public void removeBairro(int cod) throws BancoException;
}