package beans;

public class ContatoCliente {

    int id;
    int cliente;
    int dados;

    public ContatoCliente(int i, int c, int d) {
        id = i;
        cliente = c;
        dados = d;
    }

    public ContatoCliente(int c, int d) {
        cliente = c;
        dados = d;
    }

    public int getId() {
        return id;
    }

    public int getCliente() {
        return cliente;
    }

    public int getDados() {
        return dados;
    }
    
    public void setId(int i) {
        id = i;
    }
    
    public void setCliente(int c) {
        cliente = c;
    }
    
    public void setDados(int d) {
        dados = d;
    }
}
