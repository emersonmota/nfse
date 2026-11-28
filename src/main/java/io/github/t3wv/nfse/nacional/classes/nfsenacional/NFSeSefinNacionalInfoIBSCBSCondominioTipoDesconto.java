package io.github.t3wv.nfse.nacional.classes.nfsenacional;

/**
 * Tipo do desconto condominial (TSRTCTpDesconto, release 2 da NT SE/CGNFS-e 009)
 */
public enum NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto {
    INCONDICIONADO("1", "Desconto Incondicionado"),
    CONDICIONADO("2", "Desconto Condicionado");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto tipo : NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
