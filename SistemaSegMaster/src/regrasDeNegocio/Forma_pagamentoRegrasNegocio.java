package regrasDeNegocio;

import java.util.LinkedList;
import java.util.List;


import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.FormaPagamentoDaoImpl;
import beans.FormaPagamento;

public class Forma_pagamentoRegrasNegocio {
    
private FormaPagamentoDaoImpl formaPagamentoDao;

    public Forma_pagamentoRegrasNegocio() throws BancoException {
        formaPagamentoDao = new FormaPagamentoDaoImpl();
    }
    
	

    public boolean cadastroFormaPagamento(FormaPagamento formaPagamento) throws Exception {
        try {
        	//fazer funcao para buscar Forma_pagamento
            boolean existeFormaPagamento = formaPagamentoDao.existeFormaPagamento(formaPagamento.getDesc_forma_pagamento());
            if (existeFormaPagamento) {
                JOptionPane.showMessageDialog(null, "Forma pagamento ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir Forma pagamento
            formaPagamentoDao.insereFormaPagamento(formaPagamento);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar Forma pagamento");
        }
    }
    
    public FormaPagamento seleciona(int cod) throws Exception {
        try {
            return formaPagamentoDao.selecionaFormaPagamento(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public boolean altera(FormaPagamento formaPagamento) throws Exception {
        try {
        	formaPagamentoDao.alteraFormaPagamento(formaPagamento);
                return true;
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public LinkedList<FormaPagamento> listaFormaPagamento() throws Exception {
        try {
            return formaPagamentoDao.listaFormaPagamento();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
    public void remove(int cod) throws Exception {
        try {
        	formaPagamentoDao.removeFormaPagamento(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
}
