package beans;

public class ClienteFisico extends Cliente{

	private String cpf;
        private int codFisico;
	
	public ClienteFisico(int cod_cliente, int codFisico, String nome, String cpf, int tipoCliente) {
		super(cod_cliente, nome, tipoCliente);
                this.codFisico = codFisico;
		this.cpf = cpf;
	}
	
        public ClienteFisico(int cod_cliente, String nome, String cpf, int tipoCliente, int end) {
		super(cod_cliente, nome, tipoCliente, end);
                this.codFisico = codFisico;
		this.cpf = cpf;
	}
	
        public ClienteFisico(String nome, String cpf, int tipoCliente, int codEnd) {
		super(nome, tipoCliente, codEnd);
		this.cpf = cpf;
	}
        
        public ClienteFisico(int cod, String doc) {
            codFisico = cod;
            cpf = doc;
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
