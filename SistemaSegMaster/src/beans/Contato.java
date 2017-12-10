/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author cliente
 */
public class Contato {
    
    private int id_contabilidade;
    private String email;
    private String telefone;

    public Contato(int id_contabilidade, String email, String telefone) {
        this.id_contabilidade = id_contabilidade;
        this.email = email;
        this.telefone = telefone;
    }

    public Contato(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public int getId_contabilidade() {
        return id_contabilidade;
    }

    public void setId_contabilidade(int id_contabilidade) {
        this.id_contabilidade = id_contabilidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
    
}
