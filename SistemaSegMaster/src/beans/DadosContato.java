package beans;

/**
 *
 * @author pedro
 */
public class DadosContato {
    
    int cod;
    int tipo;
    String desc;
    
    public DadosContato(int c, int t, String d) {
        cod = c;
        tipo = t;
        desc = d;
    }
    
    public DadosContato(int t, String d) {
        tipo = t;
        desc = d;
    }
    
    public int getCod() {
        return cod;
    }
    
    public int getTipo() {
        return tipo;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public void setCod(int c) {
        cod = c;
    }
    
    public void setTipo(int t) {
        tipo = t;
    }
    
    public void setDesc(String d) {
        desc = d;
    }
}
