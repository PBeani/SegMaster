/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.PedidoDaoImpl;
import beans.Pedido;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author amand_000
 */
public class PedidoRegrasNegocio {
    private PedidoDaoImpl pedidoDao;

    public PedidoRegrasNegocio() throws BancoException {
        pedidoDao = new PedidoDaoImpl();
    }
        

    public boolean cadastroPedido(Pedido pedido) throws Exception {
        try {
            boolean existePedido = pedidoDao.existePedido(pedido.getIdPedido());
            if (existePedido) {
                JOptionPane.showMessageDialog(null, "Pedido ja cadastrado");
                return false;
            }
            
            pedidoDao.inserePedido(pedido);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar Pedido");
        }
    }
    
    public Pedido seleciona(int cod) throws Exception {
        try {
            return pedidoDao.selecionaPedido(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    } 
    
    public boolean altera(Pedido pedido) throws Exception {
        try {
        	pedidoDao.alteraPedido(pedido);
                return true;
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public LinkedList<Pedido> listaPedido() throws Exception {
        try {
            return pedidoDao.listaPedido();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	pedidoDao.removePedido(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}
