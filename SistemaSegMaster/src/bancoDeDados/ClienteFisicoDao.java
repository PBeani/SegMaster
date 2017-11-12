package bancoDeDados;

import java.util.LinkedList;

import beans.ClienteFisico;

public interface ClienteFisicoDao {

    public void insereClienteFisico(ClienteFisico cliente) throws BancoException;
    
    public ClienteFisico selecionaClienteFisico(int cod) throws BancoException;
    
    public ClienteFisico selecionaClienteFisicoCPF(String cpf) throws BancoException;
}
