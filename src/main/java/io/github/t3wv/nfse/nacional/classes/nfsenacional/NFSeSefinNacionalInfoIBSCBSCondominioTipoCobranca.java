package io.github.t3wv.nfse.nacional.classes.nfsenacional;

/**
 * Tipo da cobrança condominial (TSRTCTpCobranca, release 2 da NT SE/CGNFS-e 009)
 */
public enum NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca {
    CONDOMINIO_ORDINARIO("01", "Condomínio Ordinário"),
    CONDOMINIO_PRIVATIVO("02", "Condomínio Privativo"),
    FUNDO_PROMOCAO_PROPAGANDA("03", "Fundo De Promoção E Propaganda (FPP)"),
    IMPOSTOS_TAXAS("04", "Impostos e Taxas"),
    FUNDO_RESERVA("05", "Fundo de Reserva"),
    OUTRA("99", "Outra Cobrança");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca tipo : NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
