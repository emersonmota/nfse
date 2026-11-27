package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

/**
 * Grupo gTribSN da NFS-e (NT SE/CGNFS-e 009, item 2.4): composição do valor do IBS e da CBS para optante
 * (ou pendente) do Simples Nacional com IBS e/ou CBS apurados por esse regime. Preenchido pela SEFIN.
 */
public class NFSeSefinNacionalInfNFSeIBSCBSTotaisTribSN {
    @Element(name = "pIBSSN", required = false)
    private BigDecimal pIBSSN;
    @Element(name = "vIBSSN", required = false)
    private BigDecimal vIBSSN;
    @Element(name = "pCBSSN")
    private BigDecimal pCBSSN;
    @Element(name = "vCBSSN")
    private BigDecimal vCBSSN;

    /**
     * @return Alíquota do IBS total calculada apenas para os optantes do Simples Nacional
     */
    public BigDecimal getpIBSSN() {
        return pIBSSN;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribSN setpIBSSN(BigDecimal pIBSSN) {
        this.pIBSSN = pIBSSN;
        return this;
    }

    /**
     * @return Valor do IBS para os optantes do Simples Nacional
     */
    public BigDecimal getvIBSSN() {
        return vIBSSN;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribSN setvIBSSN(BigDecimal vIBSSN) {
        this.vIBSSN = vIBSSN;
        return this;
    }

    /**
     * @return Alíquota da CBS apenas para os optantes do Simples Nacional
     */
    public BigDecimal getpCBSSN() {
        return pCBSSN;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribSN setpCBSSN(BigDecimal pCBSSN) {
        this.pCBSSN = pCBSSN;
        return this;
    }

    /**
     * @return Valor da CBS para os optantes do Simples Nacional
     */
    public BigDecimal getvCBSSN() {
        return vCBSSN;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribSN setvCBSSN(BigDecimal vCBSSN) {
        this.vCBSSN = vCBSSN;
        return this;
    }
}
