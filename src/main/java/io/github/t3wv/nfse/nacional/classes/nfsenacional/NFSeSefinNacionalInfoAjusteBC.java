package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Valores para ajuste da base de cálculo (TCInfoAjusteBC, NT SE/CGNFS-e 009): unificação dos antigos
 * vDedRed e gReeRepRes. Informe no máximo um entre pAjusteBCISSQN e vAjusteBCISSQN.
 */
@Root(name = "vAjusteBC")
public class NFSeSefinNacionalInfoAjusteBC {
    @Element(name = "pAjusteBCISSQN", required = false)
    protected BigDecimal pAjusteBCISSQN;
    @Element(name = "vAjusteBCISSQN", required = false)
    protected BigDecimal vAjusteBCISSQN;
    // ArrayList, não List: com o tipo da interface o simple-xml grava o atributo class no
    // elemento documentos, e o XSD o recusa.
    @ElementList(name = "documentos", entry = "docAjusteBC", required = false)
    protected ArrayList<NFSeSefinNacionalDocAjusteBC> documentos;
    @Element(name = "vAjusteBCIBSCBSComExt", required = false)
    protected BigDecimal vAjusteBCIBSCBSComExt;

    /**
     * Percentual padrão para ajuste da base de cálculo do ISSQN
     * @return pAjusteBCISSQN
     */
    public BigDecimal getpAjusteBCISSQN() {
        return pAjusteBCISSQN;
    }

    public NFSeSefinNacionalInfoAjusteBC setpAjusteBCISSQN(BigDecimal pAjusteBCISSQN) {
        this.pAjusteBCISSQN = pAjusteBCISSQN;
        return this;
    }

    /**
     * Valor monetário padrão para ajuste da base de cálculo do ISSQN
     * @return vAjusteBCISSQN
     */
    public BigDecimal getvAjusteBCISSQN() {
        return vAjusteBCISSQN;
    }

    public NFSeSefinNacionalInfoAjusteBC setvAjusteBCISSQN(BigDecimal vAjusteBCISSQN) {
        this.vAjusteBCISSQN = vAjusteBCISSQN;
        return this;
    }

    /**
     * Documentos utilizados para ajuste das bases de cálculo do ISSQN e/ou do IBS/CBS (até 1.000)
     * @return documentos
     */
    public List<NFSeSefinNacionalDocAjusteBC> getDocumentos() {
        return documentos;
    }

    public NFSeSefinNacionalInfoAjusteBC setDocumentos(List<NFSeSefinNacionalDocAjusteBC> documentos) {
        // Lista vazia vira null: TCListaDocAjusteBC exige ao menos um docAjusteBC
        this.documentos = documentos == null || documentos.isEmpty() ? null : new ArrayList<>(documentos);
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoAjusteBC{" +
                "pAjusteBCISSQN=" + pAjusteBCISSQN +
                ", vAjusteBCISSQN=" + vAjusteBCISSQN +
                ", documentos=" + documentos +
                '}';
    }

    /**
     * Valor para ajuste da base de cálculo do IBS/CBS nos casos de comércio exterior (release 2 da
     * NT 009). Pode ser negativo; entra somado na vBC do IBS/CBS.
     * @return vAjusteBCIBSCBSComExt
     */
    public BigDecimal getvAjusteBCIBSCBSComExt() {
        return vAjusteBCIBSCBSComExt;
    }

    public NFSeSefinNacionalInfoAjusteBC setvAjusteBCIBSCBSComExt(BigDecimal vAjusteBCIBSCBSComExt) {
        this.vAjusteBCIBSCBSComExt = vAjusteBCIBSCBSComExt;
        return this;
    }
}
