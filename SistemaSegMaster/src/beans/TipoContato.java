package beans;

public class TipoContato {

    private int id_tipo_contato;
    private String desc_tipo_contato;

    public TipoContato(int id_tipo_contato, String desc_tipo_contato) {
        super();
        this.id_tipo_contato = id_tipo_contato;
        this.desc_tipo_contato = desc_tipo_contato;
    }

    public int getId_tipo_contato() {
        return id_tipo_contato;
    }

    public void setId_tipo_contato(int id_tipo_contato) {
        this.id_tipo_contato = id_tipo_contato;
    }

    public String getDesc_tipo_contato() {
        return desc_tipo_contato;
    }

    public void setDesc_tipo_contato(String desc_tipo_contato) {
        this.desc_tipo_contato = desc_tipo_contato;
    }

}
