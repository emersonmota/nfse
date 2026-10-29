package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS {
    // Só leitura de NFS-e anteriores à NT SE/CGNFS-e 009, em que CST e cClassTrib ficavam neste grupo.
    // Sem setter: na DPS nova eles vão em trib (NFSeSefinNacionalInfoIBSCBSInfoTributos).
    @Element(name = "CST", required = false)
    protected String cstLeiauteAnterior;
    @Element(name = "cClassTrib", required = false)
    protected String cClassTribLeiauteAnterior;
    @Element(name = "cCredPres", required = false)
    protected String cCredPres;
    @Element(name = "gTribRegular", required = false)
    protected NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGTribRegular gTribRegular;
    @Element(name = "gDif", required = false)
    protected NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGDif gDif;

    /**
     * CST de uma NFS-e anterior à NT SE/CGNFS-e 009; nas novas, use NFSeSefinNacionalInfoIBSCBSInfoTributos#getCST
     */
    @Deprecated
    public String getCstLeiauteAnterior() {
        return cstLeiauteAnterior;
    }

    /**
     * cClassTrib de uma NFS-e anterior à NT SE/CGNFS-e 009; nas novas, use NFSeSefinNacionalInfoIBSCBSInfoTributos#getcClassTrib
     */
    @Deprecated
    public String getcClassTribLeiauteAnterior() {
        return cClassTribLeiauteAnterior;
    }

    public String getcCredPres() {
        return cCredPres;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS setcCredPres(String cCredPres) {
        this.cCredPres = cCredPres;
        return this;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGTribRegular getgTribRegular() {
        return gTribRegular;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS setgTribRegular(NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGTribRegular gTribRegular) {
        this.gTribRegular = gTribRegular;
        return this;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGDif getgDif() {
        return gDif;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS setgDif(NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGDif gDif) {
        this.gDif = gDif;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS{" +
                "cCredPres='" + cCredPres + '\'' +
                ", gTribRegular=" + gTribRegular +
                ", gDif=" + gDif +
                '}';
    }
}
