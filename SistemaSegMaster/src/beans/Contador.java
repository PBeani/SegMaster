package beans;

public class Contador {

	private int id_contador;
	private String nomeContador;
	private int cod_contabilidade;
        private String nome_contabilidade;
        
        public Contador(String nome, int cod, String nomeContabilidade){
            nomeContador=nome;
            id_contador=cod;
            nome_contabilidade=nomeContabilidade;
        }
	
	public Contador(int id_contador, String nomeContador, int cod_contabilidade) {
		super();
		this.id_contador = id_contador;
		this.nomeContador = nomeContador;
		this.cod_contabilidade = cod_contabilidade;
	}
        public Contador(String s, int cod){
            nomeContador=s;
            id_contador=cod;
        }
        

    public Contador(int cod, String text) {
        nomeContador=text;
        cod_contabilidade=cod;
    }

    public String getNome_contabilidade() {
        return nome_contabilidade;
    }
	
	public int getId_contador() {
		return id_contador;
	}
	public void setId_contador(int id_contador) {
		this.id_contador = id_contador;
	}
	public String getNomeContador() {
		return nomeContador;
	}
	public void setNomeContador(String nomeContador) {
		this.nomeContador = nomeContador;
	}
	public int getCod_contabilidade() {
		return cod_contabilidade;
	}
	public void setCod_contabilidade(int cod_contabilidade) {
		this.cod_contabilidade = cod_contabilidade;
	}
	
	
}
