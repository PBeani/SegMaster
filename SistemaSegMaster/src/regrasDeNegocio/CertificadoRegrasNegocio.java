/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocio;

import bancoDeDados.BancoException;
import bancoDeDados.jdbc.CertificadoDaoImpl;
import beans.Certificado;
import java.util.LinkedList;
import javax.swing.JOptionPane;
/**
 *
 * @author amand_000
 */
public class CertificadoRegrasNegocio {
    
    private CertificadoDaoImpl certificadoDaoImpl;

    public CertificadoRegrasNegocio() throws BancoException {
        this.certificadoDaoImpl = new CertificadoDaoImpl();
    }

    public boolean cadastroCertificado(Certificado certificado) throws Exception {
        try {
            //fazer funcao para listar Municipio
            boolean existeCertificado = certificadoDaoImpl.existeCertificado(certificado.getNum_certificado());
            if (existeCertificado) {
                JOptionPane.showMessageDialog(null, "Certificado ja cadastrado");
                return false;
            }

            //alterar a funcao para ser INSEREMUNICIPIO
            certificadoDaoImpl.insereCertificado(certificado);
            return true;
        } catch (BancoException e) {
            throw new Exception("Erro ao cadastrar certificado");
        }
    }

    public Certificado seleciona(int cod) throws Exception {
        try {
            return certificadoDaoImpl.selecionaCertificado(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public boolean altera(Certificado certificado) throws Exception {
        try {
            certificadoDaoImpl.alteraCertificado(certificado);
            return true;
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public LinkedList<Certificado> listaCertificado() throws Exception {
        try {

            return certificadoDaoImpl.listaCertificado();
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }

    public void remove(int cod) throws Exception {
        try {
            certificadoDaoImpl.removeCertificado(cod);
        } catch (BancoException e) {
            throw new Exception("Nao foi possivel acessar o banco de dados.");
        }
    }
    
}
