package bancoDeDados;

import beans.CategoriaCertificado;

import java.util.LinkedList;

public interface CategoriaCertificadoDao {

    public void insereCategoriaCertificado(CategoriaCertificado c) throws BancoException;

    public void alteraCategoriaCertificado(CategoriaCertificado c) throws BancoException;

    public CategoriaCertificado selecionaCategoriaCertificado(int cod) throws BancoException;
    
    public boolean existeCategoriaCertificado(String desc) throws BancoException;

    public LinkedList<CategoriaCertificado> listaCategoriaCertificado() throws BancoException;

    public void removeCategoriaCertificado(int cod) throws BancoException;
}
