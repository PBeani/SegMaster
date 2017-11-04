package bancoDeDados;

import beans.Pedido;

public interface PedidoDao {
    
    public void inserePedido(Pedido pedido) throws BancoException;
}
