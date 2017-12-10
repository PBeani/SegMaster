/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados;
import beans.ContatoCliente;
import beans.DadosContato;
import java.util.LinkedList;
/**
 *
 * @author pedro
 */
public interface DadosContatoDao {
    
    public int insereDados(DadosContato d) throws BancoException;
    
    public void atualiza(DadosContato d) throws BancoException;
    
    public void insereCliente(ContatoCliente e) throws BancoException;
    
    public LinkedList<DadosContato> listaContatosCliente(int cod) throws BancoException;
}
