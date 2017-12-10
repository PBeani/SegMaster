package beans;

public class Contabilidade {

    private int id_contabilidade;
    private String nome_contabilidade;
    private String cnpj;
    private int ies_parceiro;
    private int cod_parceria;
    private int cod_endereco;

    public Contabilidade(String nome_contabilidade, String cnpj, int ies_parceiro, int cod_parceria, int cod_endereco) {
        this.nome_contabilidade = nome_contabilidade;
        this.cnpj = cnpj;
        this.ies_parceiro = ies_parceiro;
        this.cod_parceria = cod_parceria;
        this.cod_endereco = cod_endereco;
    }
     public Contabilidade(int id_contabilidade,String nome_contabilidade, String cnpj, int cod_parceria, int cod_endereco) {
        this.id_contabilidade=id_contabilidade;
        this.nome_contabilidade = nome_contabilidade;
        this.cnpj = cnpj;
        this.cod_parceria = cod_parceria;
        this.cod_endereco = cod_endereco;
    }
    

    
    
    public Contabilidade(String nome_contabilidade, String cnpj, int cod_parceria, int cod_endereco) {
        this.nome_contabilidade = nome_contabilidade;
        this.cnpj = cnpj;
        this.cod_parceria = cod_parceria;
        this.cod_endereco = cod_endereco;
    }

    public Contabilidade(int id_contabilidade, String nome_contabilidade, String cnpj, int ies_parceiro,
            int cod_parceria, int cod_endereco) {
        super();
        this.id_contabilidade = id_contabilidade;
        this.nome_contabilidade = nome_contabilidade;
        this.cnpj = cnpj;
        this.ies_parceiro = ies_parceiro;
        this.cod_parceria = cod_parceria;
        this.cod_endereco = cod_endereco;
    }

    public Contabilidade(int id_contabilidade, String nome_contabilidade, String cnpj, int cod_parceria) {
        this.id_contabilidade = id_contabilidade;
        this.nome_contabilidade = nome_contabilidade;
        this.cnpj = cnpj;
        this.cod_parceria = cod_parceria;
    }

    public int getId_contabilidade() {
        return id_contabilidade;
    }

    public void setId_contabilidade(int id_contabilidade) {
        this.id_contabilidade = id_contabilidade;
    }

    public String getNome_contabilidade() {
        return nome_contabilidade;
    }

    public void setNome_contabilidade(String nome_contabilidade) {
        this.nome_contabilidade = nome_contabilidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getIes_parceiro() {
        return ies_parceiro;
    }

    public void setIes_parceiro(int ies_parceiro) {
        this.ies_parceiro = ies_parceiro;
    }

    public int getCod_parceria() {
        return cod_parceria;
    }

    public void setCod_parceria(int cod_parceria) {
        this.cod_parceria = cod_parceria;
    }

    public int getCod_endereco() {
        return cod_endereco;
    }

    public void setCod_endereco(int cod_endereco) {
        this.cod_endereco = cod_endereco;
    }

}
