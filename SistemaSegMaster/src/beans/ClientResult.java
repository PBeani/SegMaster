package beans;

public class ClientResult {
    int cod;
    String nome;
    String doc;
    String empresa;
    
    
    public ClientResult(int c, String n, String d, String e) {
        cod = c;
        nome = n;
        doc = d;
        empresa = e;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDoc() {
        return doc;
    }
    
    public String getEmpresa() {
        return empresa;
    }
    
    public int getCod() {
        return cod;
    }
}
