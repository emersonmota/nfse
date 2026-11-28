package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.util.List;

/**
 * Cobrança de taxa ou demais valores condominiais (TCRTCCobrancaCondominio, release 2 da NT SE/CGNFS-e 009)
 */
@Root(name = "gCobranca")
public class NFSeSefinNacionalInfoIBSCBSCondominioCobranca {
    @Element(name = "tpCobranca")
    protected NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca tpCobranca;
    @Element(name = "xTpCobranca", required = false)
    protected String xTpCobranca;
    @Element(name = "vCobranca")
    protected BigDecimal vCobranca;
    @ElementList(name = "gDetCobranca", entry = "gDetCobranca", inline = true, required = false)
    protected List<NFSeSefinNacionalInfoIBSCBSCondominioDetCobranca> gDetCobranca;

    public NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca getTpCobranca() {
        return tpCobranca;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominioCobranca setTpCobranca(NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca tpCobranca) {
        this.tpCobranca = tpCobranca;
        return this;
    }

    /**
     * Descrição do tipo da cobrança, só quando tpCobranca = 99 (outra cobrança)
     * @return xTpCobranca
     */
    public String getxTpCobranca() {
        return xTpCobranca;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominioCobranca setxTpCobranca(String xTpCobranca) {
        this.xTpCobranca = xTpCobranca;
        return this;
    }

    /**
     * Valor da cobrança em R$ (igual à soma de vDetCobranca, quando informado)
     * @return vCobranca
     */
    public BigDecimal getvCobranca() {
        return vCobranca;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominioCobranca setvCobranca(BigDecimal vCobranca) {
        this.vCobranca = vCobranca;
        return this;
    }

    /**
     * Detalhamento da cobrança (opcional, até 20)
     * @return gDetCobranca
     */
    public List<NFSeSefinNacionalInfoIBSCBSCondominioDetCobranca> getgDetCobranca() {
        return gDetCobranca;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominioCobranca setgDetCobranca(List<NFSeSefinNacionalInfoIBSCBSCondominioDetCobranca> gDetCobranca) {
        this.gDetCobranca = gDetCobranca == null || gDetCobranca.isEmpty() ? null : gDetCobranca;
        return this;
    }
}
