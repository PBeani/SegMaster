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
public class PedidoResult {
    int cod;
    String cliente;
    String contador;
    double val;
    
    public PedidoResult(int c, String cli, String con) {
        cod = c;
        cliente = cli;
        contador = con;
    }
    
    public PedidoResult(int c, double v) {
        cod = c;
        val = v;
    }
    
    public void setCliente(String c){
        cliente = c;
    }
    
    public void setContador(String c){
        contador = c;
    }
    
    public void setCod(int c){
        cod = c;
    }
    
    public String getCliente(){
        return cliente;
    }
    
    public String getContador(){
        return contador;
    }
    
    public int getCod(){
        return cod;
    }
    
    public double getVal() {
        return val;
    }
}
