package beans;

public class Comissao {
	
	int id_comissao;
	int cod_pedido;
	double valor_comissao;
        double porcentagem_comissao;
	int cod_status_comissao;
	int cod_forma_pagamento;
	
	public Comissao(int id_comissao, int cod_pedido, double valor_comissao, int cod_status_comissao,
			int cod_forma_pagamento, double porcentagem_comissao) {
		super();
		this.id_comissao = id_comissao;
		this.cod_pedido = cod_pedido;
		this.valor_comissao = valor_comissao;
		this.cod_status_comissao = cod_status_comissao;
		this.cod_forma_pagamento = cod_forma_pagamento;
                this.porcentagem_comissao = porcentagem_comissao;
	}

    public Comissao(int id_status_comissao, int id_forma_pagamento, double valor1, double porcentagem1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Comissao(int status, int pedido, int pag, double valor, double prc) {
        this.cod_status_comissao = status;
        this.cod_pedido = pedido;
        this.cod_forma_pagamento = pag;
        this.valor_comissao = valor;
        this.porcentagem_comissao = prc;
    }
    
    public Comissao(int cod, int status, int pedido, int pag, double valor, double prc) {
        this.id_comissao = cod;
        this.cod_status_comissao = status;
        this.cod_pedido = pedido;
        this.cod_forma_pagamento = pag;
        this.valor_comissao = valor;
        this.porcentagem_comissao = prc;
    }

	public int getId_comissao() {
		return id_comissao;
	}

	public void setId_comissao(int id_comissao) {
		this.id_comissao = id_comissao;
	}

	public int getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public double getPorcentagem_comissao() {
		return porcentagem_comissao;
	}

	public void setPorcentagem_comissao(double porcentagem_comissao) {
		this.porcentagem_comissao = porcentagem_comissao;
	}

        public double getValor_comissao() {
		return valor_comissao;
	}

	public void setValor_comissao(double valor_comissao) {
		this.valor_comissao = valor_comissao;
	}
        
	public int getCod_status_comissao() {
		return cod_status_comissao;
	}

	public void setCod_status_comissao(int cod_status_comissao) {
		this.cod_status_comissao = cod_status_comissao;
	}

	public int getCod_forma_pagamento() {
		return cod_forma_pagamento;
	}

	public void setCod_forma_pagamento(int cod_forma_pagamento) {
		this.cod_forma_pagamento = cod_forma_pagamento;
	}
	
	

}
