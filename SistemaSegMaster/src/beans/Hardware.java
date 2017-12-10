package beans;

public class Hardware {

    private int id_hardware;
    private String desc_hardware;

    public Hardware(String desc_hardware) {
        super();
        this.desc_hardware = desc_hardware;
    }

    public Hardware(int id_hardware, String desc_hardware) {
        super();
        this.id_hardware = id_hardware;
        this.desc_hardware = desc_hardware;
    }

    public int getId_hardware() {
        return id_hardware;
    }

    public void setId_hardware(int id_hardware) {
        this.id_hardware = id_hardware;
    }

    public String getDesc_hardware() {
        return desc_hardware;
    }

    public void setDesc_hardware(String desc_hardware) {
        this.desc_hardware = desc_hardware;
    }

    @Override
    public String toString() {
        return getDesc_hardware();
    }

}
