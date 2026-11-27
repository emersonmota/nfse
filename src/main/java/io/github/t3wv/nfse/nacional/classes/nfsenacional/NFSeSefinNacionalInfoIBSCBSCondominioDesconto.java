package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Desconto concedido pelo condomínio (TCRTCDescontoCondominio, release 2 da NT SE/CGNFS-e 009)
 */
@Root(name = "gDesconto")
public class NFSeSefinNacionalInfoIBSCBSCondominioDesconto {
    @Element(name = "tpDesconto")
    protected NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto tpDesconto;
    @Element(name = "vDesconto")
    protected BigDecimal vDesconto;
    @Element(name = "xTpDesconto")
    protected String xTpDesconto;

    public NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto getTpDesconto() {
        return tpDesconto;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominioDesconto setTpDesconto(NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto tpDesconto) {
        this.tpDesconto = tpDesconto;
        return this;
    }

    /**
     * Valor do desconto em R$; deve bater com vDescIncond ou vDescCond conforme o tipo
     * @return vDesconto
     */
    public BigDecimal getvDesconto() {
        return vDesconto;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominioDesconto setvDesconto(BigDecimal vDesconto) {
        this.vDesconto = vDesconto;
        return this;
    }

    /**
     * Descrição do tipo do desconto aplicado pelo condomínio
     * @return xTpDesconto
     */
    public String getxTpDesconto() {
        return xTpDesconto;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominioDesconto setxTpDesconto(String xTpDesconto) {
        this.xTpDesconto = xTpDesconto;
        return this;
    }
}
