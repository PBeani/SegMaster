/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author pedro
 */
public class CertificadoResult {

    private int cod;
    private String numero;
    private String cliente;
    private String dataValidade;
    String cat;
    int qtd;

    public CertificadoResult(int c, String n, String cli, String d) {
        cod = c;
        numero = n;
        cliente = cli;
        dataValidade = d;
    }
    
    public CertificadoResult(int q, String c) {
        cat = c;
        qtd = q;
    }
    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the dataValidade
     */
    public String getDataValidade() {
        String[] parts = dataValidade.split("-");
        String date = parts[2] + "/" + parts[1] + "/" + parts[0];
        return date;
    }

    /**
     * @param dataValidade the dataValidade to set
     */
    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    public String getCat() {
        return cat;
    }
    
    public int getQtd() {
        return qtd;
    }
}
