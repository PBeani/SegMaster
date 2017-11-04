package bancoDeDados;

import beans.FormaPagamento;
import java.util.LinkedList;

public interface FormaPagamentoDao {

    public void insereFormaPagamento(FormaPagamento c) throws BancoException;

    public void alteraFormaPagamento(FormaPagamento c) throws BancoException;

    public FormaPagamento selecionaFormaPagamento(int cod) throws BancoException;

    public LinkedList<FormaPagamento> listaFormaPagamento() throws BancoException;

    public void removeFormaPagamento(int cod) throws BancoException;
}
