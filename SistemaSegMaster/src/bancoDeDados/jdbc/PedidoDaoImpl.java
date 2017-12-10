package bancoDeDados.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import bancoDeDados.*;
import beans.Pedido;
import beans.PedidoResult;
import java.sql.Date;
import java.time.LocalDate;

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
    
    public void alteraPedido(Pedido pedido) throws BancoException {
        abreConexao();

        preparaComandoSQL(
                "update pedido set cod_cliente = ?, dt_expedicao = ?, cod_contador = ?, valor_bruto = ? where id_pedido = ?");
        try {
            pstmt.setInt(1, pedido.getCodCliente());
            pstmt.setDate(2, java.sql.Date.valueOf(pedido.getDtExpedicao()));
            pstmt.setInt(3, pedido.getCodContador());
            pstmt.setDouble(4, pedido.getValorBruto());
            pstmt.setInt(5, pedido.getIdPedido());
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema ao realizar atualização de Pedido.");
        }

        fechaConexao();
    }

    public Pedido selecionaPedido(int cod) throws BancoException {
        abreConexao();

        Pedido pedido = null;
        preparaComandoSQL("select * from pedido where id_pedido = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt(1);
                int codCliente = rs.getInt(2);
                Date dtExpedicao = rs.getDate(3);
                int codContador = rs.getInt(4);
                double valorBruto = rs.getDouble(5);
                
                pedido = new Pedido(codigo, codCliente, dtExpedicao, codContador,valorBruto );
            }
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de Pedido.");
        }
        
        fechaConexao();
        return pedido;
    }

    public LinkedList<Pedido> listaPedido() throws BancoException {
        LinkedList<Pedido> lista = new LinkedList<>();

        abreConexao();

        preparaComandoSQL("select * from pedido");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                int codCliente = rs.getInt(2);
                Date dtExpedicao = rs.getDate(3);
                int codContador = rs.getInt(4);
                double valorBruto = rs.getDouble(5);

                Pedido item = new Pedido(codigo, codCliente, dtExpedicao, codContador,valorBruto);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Pedidos.");
        }

        fechaConexao();
        return lista;
    }
    
    @Override
    public LinkedList<PedidoResult> listaPedidoMin() throws BancoException {
        LinkedList<PedidoResult> lista = new LinkedList<>();

        abreConexao();
        PedidoResult item = null;
        preparaComandoSQL("select pedido.id_pedido, cliente.nome_cliente, contador.nome_contador"
                + " from pedido"
                + " left join cliente on pedido.id_cliente = cliente.id_cliente"
                + " left join contador on pedido.id_contador = contador.id_contador");
        try {
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String cli = rs.getString(2);
                String con = rs.getString(3);

                item = new PedidoResult(codigo, cli, con);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Pedidos.");
        }

        fechaConexao();
        return lista;
    }
    
    @Override
    public LinkedList<PedidoResult> listaPedidoMinFilter(String s) throws BancoException {
        LinkedList<PedidoResult> lista = new LinkedList<>();

        abreConexao();
        PedidoResult item = null;
        preparaComandoSQL("select pedido.id_pedido, cliente.nome_cliente, contador.nome_contador"
                + " from pedido"
                + " left join cliente on pedido.id_cliente = cliente.id_cliente"
                + " left join contador on pedido.id_contador = contador.id_contador"
                + " where cliente.nome_cliente LIKE ?"
                + " UNION"
                + " select pedido.id_pedido, cliente.nome_cliente, contador.nome_contador"
                + " from pedido"
                + " left join cliente on pedido.id_cliente = cliente.id_cliente"
                + " left join contador on pedido.id_contador = contador.id_contador"
                + " where contador.nome_contador LIKE ?");
        try {
            pstmt.setString(1, "%" + s + "%");
            pstmt.setString(2, "%" + s + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt(1);
                String cli = rs.getString(2);
                String con = rs.getString(3);

                item = new PedidoResult(codigo, cli, con);
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new BancoException("Problema na geração da lista de Pedidos.");
        }

        fechaConexao();
        return lista;
    }

    public void removePedido(int cod) throws BancoException {
        abreConexao();

        preparaComandoSQL("delete from pedido where id_pedido = ?");
        try {
            pstmt.setInt(1, cod);
            pstmt.execute();
        } catch (SQLException e) {
            throw new BancoException("Problema na remoção de Pedido.");
        }

        fechaConexao();
    }
    public boolean existePedido(int cod) throws BancoException{
        boolean resp;
        abreConexao();

        Pedido pedido = null;
        preparaComandoSQL("select * from pedido where id_pedido = ?");
        try {
            pstmt.setInt(1, cod);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                resp=true;
            }
            else resp=false;
        } catch (SQLException e) {
            fechaConexao();
            throw new BancoException("Problema na seleção de Pedido.");
        }
        
        fechaConexao();
        return resp;
    }
}
