package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSTotais {
    @Element( name="vTotNF")
    private BigDecimal vTotNF;
    @Element( name="gIBS", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS gIBS;
    @Element( name="gCBS", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisCBS gCBS;
    @Element( name="gTribSN", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisTribSN gTribSN;
    @Element( name="gTribRegular", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular gTribRegular;
    @Element( name="gTribCompraGov", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov gTribCompraGov;

    public BigDecimal getvTotNF() {
        return vTotNF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setvTotNF(BigDecimal vTotNF) {
        this.vTotNF = vTotNF;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS getgIBS() {
        return gIBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setgIBS(NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS gIBS) {
        this.gIBS = gIBS;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisCBS getgCBS() {
        return gCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setgCBS(NFSeSefinNacionalInfNFSeIBSCBSTotaisCBS gCBS) {
        this.gCBS = gCBS;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular getgTribRegular() {
        return gTribRegular;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setgTribRegular(NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular gTribRegular) {
        this.gTribRegular = gTribRegular;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov getgTribCompraGov() {
        return gTribCompraGov;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setgTribCompraGov(NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov gTribCompraGov) {
        this.gTribCompraGov = gTribCompraGov;
        return this;
    }

    /**
     * @return Composição do IBS e da CBS para optantes do Simples Nacional (gTribSN, NT SE/CGNFS-e 009, item 2.4)
     */
    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribSN getgTribSN() {
        return gTribSN;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setgTribSN(NFSeSefinNacionalInfNFSeIBSCBSTotaisTribSN gTribSN) {
        this.gTribSN = gTribSN;
        return this;
    }
}
