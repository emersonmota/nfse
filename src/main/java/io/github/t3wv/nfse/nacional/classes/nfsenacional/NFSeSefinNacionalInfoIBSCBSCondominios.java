package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.time.LocalDate;
import java.util.List;

/**
 * Grupo de informações relativas às operações de condomínios (TCRTCInfoCondominios, release 2 da
 * NT SE/CGNFS-e 009). Só é admitido para as atividades de condomínio, subitem 99.05 do cTribNac.
 */
@Root(name = "condominios")
public class NFSeSefinNacionalInfoIBSCBSCondominios {
    @Element(name = "dVencOrig")
    protected LocalDate dVencOrig;
    @ElementList(name = "gCobranca", entry = "gCobranca", inline = true)
    protected List<NFSeSefinNacionalInfoIBSCBSCondominioCobranca> gCobranca;
    @ElementList(name = "gDesconto", entry = "gDesconto", inline = true, required = false)
    protected List<NFSeSefinNacionalInfoIBSCBSCondominioDesconto> gDesconto;

    /**
     * Data de vencimento original das taxas e demais valores condominiais cobrados do condômino
     * @return dVencOrig
     */
    public LocalDate getdVencOrig() {
        return dVencOrig;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominios setdVencOrig(LocalDate dVencOrig) {
        this.dVencOrig = dVencOrig;
        return this;
    }

    /**
     * Cobranças das taxas e demais valores condominiais (1 a 20). A soma de vCobranca é o vServ da DPS.
     * @return gCobranca
     */
    public List<NFSeSefinNacionalInfoIBSCBSCondominioCobranca> getgCobranca() {
        return gCobranca;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominios setgCobranca(List<NFSeSefinNacionalInfoIBSCBSCondominioCobranca> gCobranca) {
        this.gCobranca = gCobranca;
        return this;
    }

    /**
     * Descontos concedidos nas taxas e demais valores condominiais (até 10)
     * @return gDesconto
     */
    public List<NFSeSefinNacionalInfoIBSCBSCondominioDesconto> getgDesconto() {
        return gDesconto;
    }

    public NFSeSefinNacionalInfoIBSCBSCondominios setgDesconto(List<NFSeSefinNacionalInfoIBSCBSCondominioDesconto> gDesconto) {
        // Lista vazia vira null: o grupo é opcional e não pode sair sem itens.
        this.gDesconto = gDesconto == null || gDesconto.isEmpty() ? null : gDesconto;
        return this;
    }
}
