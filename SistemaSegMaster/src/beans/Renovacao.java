package beans;

public class Renovacao {

	private int id_renovacao;
	private int cod_pedido_antigo;
	private int cod_pedido_atual;
	
	public Renovacao(int id_renovacao, int cod_pedido_antigo, int cod_pedido_atual) {
		super();
		this.id_renovacao = id_renovacao;
		this.cod_pedido_antigo = cod_pedido_antigo;
		this.cod_pedido_atual = cod_pedido_atual;
	}

	public int getId_renovacao() {
		return id_renovacao;
	}

	public void setId_renovacao(int id_renovacao) {
		this.id_renovacao = id_renovacao;
	}

	public int getCod_pedido_antigo() {
		return cod_pedido_antigo;
	}

	public void setCod_pedido_antigo(int cod_pedido_antigo) {
		this.cod_pedido_antigo = cod_pedido_antigo;
	}

	public int getCod_pedido_atual() {
		return cod_pedido_atual;
	}

	public void setCod_pedido_atual(int cod_pedido_atual) {
		this.cod_pedido_atual = cod_pedido_atual;
	}
	
	
	
}
