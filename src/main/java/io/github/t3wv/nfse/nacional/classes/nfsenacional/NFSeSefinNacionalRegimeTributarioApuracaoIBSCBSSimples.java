package io.github.t3wv.nfse.nacional.classes.nfsenacional;


import org.simpleframework.xml.Root;

/**
 * Regime de apuração tributária pelo Simples Nacional para IBS e CBS (regApIBSCBSSN), NT SE/CGNFS-e 009, item 2.4.
 * Informado pelo prestador optante pelo Simples Nacional ou cuja opção esteja pendente.
 */
@Root(name = "regApIBSCBSSN")
public enum NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples {

    IBS_CBS_PELO_SN("1", "IBS e CBS apurados pelo SN"),
    CBS_PELO_SN_IBS_REGULAR("2", "CBS apurada pelo SN e IBS apurado pelo regime regular"),
    IBS_CBS_REGULAR("3", "IBS e CBS apurados pelo regime regular");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples tipo : NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
