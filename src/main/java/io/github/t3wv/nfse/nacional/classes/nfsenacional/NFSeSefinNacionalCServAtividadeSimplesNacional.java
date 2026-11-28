package io.github.t3wv.nfse.nacional.classes.nfsenacional;


import org.simpleframework.xml.Root;

/**
 * Código da atividade do Simples Nacional (cAtvSN), conforme a LC 123/2006, NT SE/CGNFS-e 009, item 2.4.
 * A NT mantém a numeração ordinal da LC 123/2006 e adota só os códigos que cabem na NFS-e.
 */
@Root(name = "cAtvSN")
public enum NFSeSefinNacionalCServAtividadeSimplesNacional {

    SERVICOS_ISS_ANEXO_III("7", "Prestação de serviços, cessão de direitos, de uso ou de espaço com incidência do ISS, tributados exclusivamente pelo Anexo III"),
    SERVICOS_CONTABEIS_ISS_FIXO_ANEXO_III("8", "Prestação de serviços contábeis autorizados a pagar o ISS em valor fixo em guia do Município - Anexo III"),
    SERVICOS_FATOR_R_ANEXO_III_OU_V("9", "Prestação de serviços - Sujeitos ao Fator \"R\" - Anexo III ou V"),
    TRANSPORTE_MUNICIPAL_PASSAGEIROS_ANEXO_III("10", "Prestação de serviços de transporte municipal rodoviário, metroviário, ferroviário e aquaviário de passageiros relacionados no subitem 16.01 da lista anexa à LC 116/2003 - Anexo III"),
    LOCACAO_BENS_MOVEIS_SEM_ISS_ANEXO_III("11", "Locação de bens móveis e operações com serviços, bens imateriais e direitos, inclusive com bens imóveis, sem incidência de ISS - Anexo III"),
    CONSTRUCAO_CIVIL_ANEXO_III("12", "Prestação de serviços da área da construção civil relacionados nos subitens 7.02 e 7.05 da lista anexa à LC 116/2003 - Anexo III"),
    CONSTRUCAO_CIVIL_ANEXO_IV("13", "Prestação de serviços da área da construção civil relacionados nos subitens 7.02 e 7.05 da lista anexa à LC 116/2003 - Anexo IV"),
    SERVICOS_ANEXO_IV("14", "Prestação de serviços - Anexo IV"),
    OPERACOES_NAO_TRIBUTADAS("90", "Operações não tributadas");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalCServAtividadeSimplesNacional(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalCServAtividadeSimplesNacional valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalCServAtividadeSimplesNacional tipo : NFSeSefinNacionalCServAtividadeSimplesNacional.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
