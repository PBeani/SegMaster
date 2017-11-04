package bancoDeDados;

import beans.Certificado;

public interface CertificadoDao {
    
    public void insereCertificado(Certificado c) throws BancoException;
//    public Certificado selecionaCertificado();
}
