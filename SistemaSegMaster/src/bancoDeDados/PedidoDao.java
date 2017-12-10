package bancoDeDados;

import beans.Pedido;
import beans.PedidoResult;
import java.util.LinkedList;

public interface PedidoDao {
    
    public void inserePedido(Pedido pedido) throws BancoException;
    
    public LinkedList<PedidoResult> listaPedidoMin() throws BancoException;
    
    public LinkedList<PedidoResult> listaPedidoMinFilter(String s) throws BancoException;
}
