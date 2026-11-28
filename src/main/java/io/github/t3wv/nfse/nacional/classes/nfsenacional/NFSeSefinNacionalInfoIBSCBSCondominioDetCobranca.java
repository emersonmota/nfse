package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Detalhamento de uma cobrança condominial (TCRTCDetCobrancaCondominio, release 2 da NT SE/CGNFS-e 009)
 */
@Root(name = "gDetCobranca")
public class NFSeSefinNacionalInfoIBSCBSCondominioDetCobranca {
    @Element(name = "tpDetCobranca")
    protected String tpDetCobranca;
    @Element(name = "xTpDetCobranca", required = false)
    protected String xTpDetCobranca;
    @Element(name = "vDetCobranca")
    protected BigDecimal vDetCobranca;

    /**
     * Tipo de detalhamento da cobrança, código de 3 dígitos de TSRTCTpDetCobranca (001 a 036 ou 999).
     * Deve ter correlação com o tpCobranca do grupo (ver o XSD).
     * @return tpDetCobranca
     */
    public String getTpDetCobranca() {
        return tpDetCobranca;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominioDetCobranca setTpDetCobranca(String tpDetCobranca) {
        this.tpDetCobranca = tpDetCobranca;
        return this;
    }

    /**
     * Descrição do tipo de detalhamento, só quando tpDetCobranca = 999
     * @return xTpDetCobranca
     */
    public String getxTpDetCobranca() {
        return xTpDetCobranca;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominioDetCobranca setxTpDetCobranca(String xTpDetCobranca) {
        this.xTpDetCobranca = xTpDetCobranca;
        return this;
    }

    public BigDecimal getvDetCobranca() {
        return vDetCobranca;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominioDetCobranca setvDetCobranca(BigDecimal vDetCobranca) {
        this.vDetCobranca = vDetCobranca;
        return this;
    }
}
