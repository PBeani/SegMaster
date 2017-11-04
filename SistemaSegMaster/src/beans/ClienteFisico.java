package beans;

public class ClienteFisico extends Cliente{

	private String cpf;
        private int codFisico;
	
	public ClienteFisico(int cod_cliente, String nome, String cpf, int tipoCliente, int codFisico) {
		super(cod_cliente, nome, tipoCliente);
                this.codFisico = codFisico;
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
        public int getCodFisico() {
		return codFisico;
	}

	public void setCodFisico(int cod) {
		this.codFisico = cod;
	}
}
