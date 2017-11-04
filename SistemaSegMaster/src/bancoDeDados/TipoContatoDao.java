package bancoDeDados;

import beans.TipoContato;
import java.util.LinkedList;

public interface TipoContatoDao {

    public void insereTipoContato(TipoContato c) throws BancoException;

    public void alteraTipoContato(TipoContato c) throws BancoException;

    public TipoContato selecionaTipoContato(int cod) throws BancoException;

    public LinkedList<TipoContato> listaTipoContato() throws BancoException;

    public void removeTipoContato(int cod) throws BancoException;
}
