package bancoDeDados;

import beans.StatusComissao;
import java.util.LinkedList;

public interface StatusComissaoDao {

    public void insereStatusComissao(StatusComissao c) throws BancoException;

    public void alteraStatusComissao(StatusComissao c) throws BancoException;

    public StatusComissao selecionaStatusComissao(int cod) throws BancoException;

    public LinkedList<StatusComissao> listaStatusComissao() throws BancoException;

    public void removeStatusComissao(int cod) throws BancoException;
}