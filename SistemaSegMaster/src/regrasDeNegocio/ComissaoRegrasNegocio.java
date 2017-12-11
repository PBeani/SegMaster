/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.ComissaoDaoImpl;
import beans.Comissao;
import beans.ComissaoResult;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author amand_000
 */
public class ComissaoRegrasNegocio {
   
    private ComissaoDaoImpl comissaoDaoImpl;

    public ComissaoRegrasNegocio() throws BancoException {
        this.comissaoDaoImpl = new ComissaoDaoImpl();
    }

    public boolean cadastroComissao(Comissao comissao) throws Exception {
        try {
            //fazer funcao para listar Municipio
            boolean existeComissao = comissaoDaoImpl.existeComissao(comissao.getId_comissao());
            if (existeComissao) {
                JOptionPane.showMessageDialog(null, "Comissao ja cadastrado");
                return false;
            }

            //alterar a funcao para ser INSEREMUNICIPIO
            comissaoDaoImpl.insereComissao(comissao);
            return true;
        } catch (BancoException e) {
            throw new Exception("Erro ao cadastrar comissao");
        }
    }

    public Comissao seleciona(int cod) throws Exception {
        try {
            return comissaoDaoImpl.selecionaComissao(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public boolean altera(Comissao comissao) throws Exception {
        try {
            comissaoDaoImpl.alteraComissao(comissao);
            return true;
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public LinkedList<ComissaoResult> listaComissao() throws Exception {
        try {

            return comissaoDaoImpl.listaComissao();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public LinkedList<ComissaoResult> listaComissaoMedia() throws Exception {
        try {

            return comissaoDaoImpl.listaComissaoMedia();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public LinkedList<ComissaoResult> listaComissaoFiltro(int i) throws Exception {
        try {

            return comissaoDaoImpl.listaComissaoFiltro(i);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public void remove(int cod) throws Exception {
        try {
            comissaoDaoImpl.removeComissao(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    } 
}
