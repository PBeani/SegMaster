package beans;

public class CategoriaCertificado {

    private int id_tipo_certificado;
    private String desc_categoria_certificado;

    public CategoriaCertificado(String desc_categoria_certificado){
    super();
    this.desc_categoria_certificado=desc_categoria_certificado;
    }
    
    public CategoriaCertificado(int id_tipo_certificado, String desc_categoria_certificado) {
        super();
        this.id_tipo_certificado = id_tipo_certificado;
        this.desc_categoria_certificado = desc_categoria_certificado;
    }

    public int getId_tipo_certificado() {
        return id_tipo_certificado;
    }

    public void setId_tipo_certificado(int id_tipo_certificado) {
        this.id_tipo_certificado = id_tipo_certificado;
    }

    public String getDesc_categoria_certificado() {
        return desc_categoria_certificado;
    }

    public void setDesc_categoria_certificado(String desc_categoria_certificado) {
        this.desc_categoria_certificado = desc_categoria_certificado;
    }

}
