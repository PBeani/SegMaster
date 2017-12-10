package bancoDeDados;

import beans.ClienteJuridico;

public interface ClienteJuridicoDao {

    public int insereClienteJuridico(ClienteJuridico cliente) throws BancoException;
    
    public void atualizaClienteJuridico(ClienteJuridico cliente) throws BancoException;
    
    public ClienteJuridico selecionaClienteJuridico(int cod) throws BancoException;
    
    public ClienteJuridico selecionaClienteJuridicoCNPJ (String cnpj) throws BancoException;
}
