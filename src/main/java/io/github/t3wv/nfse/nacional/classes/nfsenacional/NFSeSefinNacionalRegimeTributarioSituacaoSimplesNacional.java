package io.github.t3wv.nfse.nacional.classes.nfsenacional;


import org.simpleframework.xml.Root;

@Root(name = "opSimpNac")
public enum NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional {

    NAO_OPTANTE("1", "Não Optante"),
    MEI("2", "Optante - Microempreendedor Individual (MEI)"),
    ME_EPP("3", "Optante - Microempresa ou Empresa de Pequeno Porte (ME/EPP)"),
    /**
     * Opção pelo Simples Nacional pendente de regularização/julgamento (NT SE/CGNFS-e 009, item 2.4). Fica fora do XSD
     * de produção restrita de 20/10/2026: só vale a partir do release 4 da plataforma.
     */
    OPTANTE_PENDENTE("4", "Optante Pendente");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional tipo : NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}