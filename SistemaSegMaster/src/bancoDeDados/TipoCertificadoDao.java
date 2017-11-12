package bancoDeDados;

import beans.TipoCertificado;
import java.util.LinkedList;

public interface TipoCertificadoDao {

    public void insereTipoCertificado(TipoCertificado c) throws BancoException;

    public void alteraTipoCertificado(TipoCertificado c) throws BancoException;

    public TipoCertificado selecionaTipoCertificado(int cod) throws BancoException;

    public LinkedList<TipoCertificado> listaTipoCertificado() throws BancoException;

    public void removeTipoCertificado(int cod) throws BancoException;
    
    public boolean existe (String s)throws BancoException;
}
