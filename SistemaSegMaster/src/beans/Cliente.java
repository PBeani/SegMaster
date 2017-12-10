package beans;

public class Cliente {

    int id_cliente;
    String nome_cliente;
    int cod_tipo_cliente;
    int endereco;

    public Cliente () {
        
    }
    
    public Cliente(int id_cliente, String nome_cliente, int cod_tipo_cliente) {
        super();
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.cod_tipo_cliente = cod_tipo_cliente;
    }
    public Cliente(int id_cliente, String nome_cliente, int cod_tipo_cliente, int end) {
        super();
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.cod_tipo_cliente = cod_tipo_cliente;
        this.endereco = end;
    }
    
    public Cliente(String nome_cliente, int cod_tipo_cliente, int end) {
        super();
        this.nome_cliente = nome_cliente;
        this.cod_tipo_cliente = cod_tipo_cliente;
        endereco = end;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public int getCod_tipo_cliente() {
        return cod_tipo_cliente;
    }

    public void setCod_tipo_cliente(int cod_tipo_cliente) {
        this.cod_tipo_cliente = cod_tipo_cliente;
    }
    
    public int getEndereco() {
        return endereco;
    }
}
