package regrasDeNegocio;

import java.util.List;


import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.FormaPagamentoDao;
import beans.FormaPagamento;

public class Forma_pagamentoRegrasNegocio {
	private FormaPagamentoDao formaPagamentoDao;

    public boolean cadastroFormaPagamento(FormaPagamento formaPagamento) throws Exception {
        try {
        	//fazer funcao para buscar Forma_pagamento
            List<FormaPagamento> listaForma_pagamento = formaPagamentoDao.buscaFormaPagamentoDesc(formaPagamento.getDesc_forma_pagamento());
            if (!FormaPagamento.isEmpty()) {
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
}
