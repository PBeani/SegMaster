package regrasDeNegocio;

import java.util.List;

import javax.swing.JOptionPane;

import bancoDeDados.BancoException;
import bancoDeDados.GerenciadorBancoDados;
import beans.Forma_pagamento;

public class Forma_pagamentoRegrasNegocio {
	private GerenciadorBancoDados gerenciadorBancoDados;

    public boolean cadastroHardware(Forma_pagamento formaPagamento) throws Exception {
        try {
        	//fazer funcao para buscar Forma_pagamento
            List<Forma_pagamento> listaForma_pagamento = gerenciadorBancoDados.buscaFormaPagamentoDesc(formaPagamento.getDesc_forma_pagamento());
            if (!Forma_pagamento.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Forma pagamento ja cadastrado");
                return false;
            }
            
            //falta fazer a funcao de inserir Forma pagamento
            gerenciadorBancoDados.insereFormaPagamento(formaPagamento);
            return true;
        } catch (BancoException e) {
			throw new Exception("Erro ao cadastrar Forma pagamento");
        }
    }
}
