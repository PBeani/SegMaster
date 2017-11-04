package beans;

public class ClienteJuridico extends Cliente {

    private int id_cliente_juridico;
    private String cnpj;
    private String nomeEmpresa;

    public ClienteJuridico(int id_cliente, int id_cliente_juridico, String cnpj, String nomeEmpresa, String nome, int tipo) {
        super(id_cliente, nome, tipo);
        this.id_cliente_juridico = id_cliente_juridico;
        this.cnpj = cnpj;
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public int getId_cliente_juridico() {
        return id_cliente_juridico;
    }

    public void setId_cliente_juridico(int id_cliente_juridico) {
        this.id_cliente_juridico = id_cliente_juridico;
    }
}
