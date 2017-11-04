package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Pedido;

public class PedidoDaoImpl extends ConectorJDBC implements PedidoDao {

    public PedidoDaoImpl() throws BancoException {
        super();
    }

    @Override
    public void inserePedido(Pedido pedido) throws BancoException {
        abreConexao();
        preparaComandoSQL(
                "insert into pedido (cod_cliente,dt_expedicao,cod_contador,valor_bruto) values (?,?,?,?) ");
        try {
            pstmt.setInt(1, pedido.getCodCliente());
            pstmt.setDate(2, java.sql.Date.valueOf(pedido.getDtExpedicao()));
            pstmt.setInt(3, pedido.getCodContador());
            pstmt.setDouble(4, pedido.getValorBruto());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao cadastrar pedido");
        }
        fechaConexao();
    }
}
