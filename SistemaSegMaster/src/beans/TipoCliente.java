package beans;

public class TipoCliente {

    private int id_tipo_cliente;
    private String desc_tipo_cliente;

    public TipoCliente(int id_tipo_cliente, String desc_tipo_cliente) {
        super();
        this.id_tipo_cliente = id_tipo_cliente;
        this.desc_tipo_cliente = desc_tipo_cliente;
    }
    
    public TipoCliente(String desc_tipo_cliente) {
        this.desc_tipo_cliente = desc_tipo_cliente;
    }

    public int getId_tipo_cliente() {
        return id_tipo_cliente;
    }

    public void setId_tipo_cliente(int id_tipo_cliente) {
        this.id_tipo_cliente = id_tipo_cliente;
    }

    public String getDesc_tipo_cliente() {
        return desc_tipo_cliente;
    }

    public void setDesc_tipo_cliente(String desc_tipo_cliente) {
        this.desc_tipo_cliente = desc_tipo_cliente;
    }

}
