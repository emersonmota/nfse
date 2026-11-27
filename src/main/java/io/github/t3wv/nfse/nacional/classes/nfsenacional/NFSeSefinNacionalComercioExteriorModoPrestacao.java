package io.github.t3wv.nfse.nacional.classes.nfsenacional;


public enum NFSeSefinNacionalComercioExteriorModoPrestacao {

    DESCONHECIDO("0", "Desconhecido (tipo não informado na nota de origem)"),
    TRANSFRONTEIRICO("1", "Transfronteiriço"),
    CONSUMO("2", "Consumo no Brasil"),
    // Release 2 da NT 009 (XSD de 24/11/2026): o 3 deixou de ser Presença Comercial no Exterior e o
    // 4 deixou de ser Movimento Temporário de Pessoas Físicas.
    MOVIMENTO("3", "Movimento Temporário de Pessoas Físicas"),
    CONSUMO_EXTERIOR("4", "Consumo no Exterior"),
    CONSUMO_CONCOMITANTE("5", "Consumo concomitante no território nacional e exterior");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalComercioExteriorModoPrestacao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalComercioExteriorModoPrestacao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalComercioExteriorModoPrestacao tipo : NFSeSefinNacionalComercioExteriorModoPrestacao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}