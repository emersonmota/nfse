
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Regime de tributação do prestador de serviço
 */

@Root(name = "regTrib")
public class NFSeSefinNacionalRegTrib {

    @Element(name = "opSimpNac")
    protected NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional opSimplesNacional;
    @Element(name = "regApTribSN", required = false)
    protected NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples regimeApuracaoAposLimiteSimplesNacional;
    @Element(name = "regApIBSCBSSN", required = false)
    protected NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples regimeApuracaoIBSCBSSimplesNacional;
    @Element(name = "regEspTrib")
    protected NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao regimeEspecialTributacao;

    /**
     * @return Opção no Simples Nacional
     */
    public NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional getOpSimplesNacional() {
        return opSimplesNacional;
    }

    /**
     * @param opSimplesNacional Opção no Simples Nacional
     */
    public NFSeSefinNacionalRegTrib setOpSimplesNacional(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional opSimplesNacional) {
        this.opSimplesNacional = opSimplesNacional;
        return this;
    }

    /**
     * @return Regime de apuração após limite do Simples Nacional
     */
    public NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples getRegimeApuracaoAposLimiteSimplesNacional() {
        return regimeApuracaoAposLimiteSimplesNacional;
    }

    /**
     * @param regimeApuracaoAposLimiteSimplesNacional Regime de apuração após limite do Simples Nacional
     */
    public NFSeSefinNacionalRegTrib setRegimeApuracaoAposLimiteSimplesNacional(NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples regimeApuracaoAposLimiteSimplesNacional) {
        this.regimeApuracaoAposLimiteSimplesNacional = regimeApuracaoAposLimiteSimplesNacional;
        return this;
    }

    /**
     * @return Regime de apuração do IBS e da CBS para optante (ou pendente) do Simples Nacional
     */
    public NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples getRegimeApuracaoIBSCBSSimplesNacional() {
        return regimeApuracaoIBSCBSSimplesNacional;
    }

    /**
     * Regime de apuração do IBS e da CBS (regApIBSCBSSN, NT SE/CGNFS-e 009, item 2.4), para prestador optante
     * pelo Simples Nacional ou com opção pendente. Fica fora do XSD de produção restrita de 20/10/2026.
     *
     * @param regimeApuracaoIBSCBSSimplesNacional Regime de apuração do IBS e da CBS pelo Simples Nacional
     */
    public NFSeSefinNacionalRegTrib setRegimeApuracaoIBSCBSSimplesNacional(NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples regimeApuracaoIBSCBSSimplesNacional) {
        this.regimeApuracaoIBSCBSSimplesNacional = regimeApuracaoIBSCBSSimplesNacional;
        return this;
    }

    /**
     * @return Regime especial de tributação
     */
    public NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao getRegimeEspecialTributacao() {
        return regimeEspecialTributacao;
    }

    /**
     * @param regimeEspecialTributacao Regime especial de tributação
     */
    public NFSeSefinNacionalRegTrib setRegimeEspecialTributacao(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao regimeEspecialTributacao) {
        this.regimeEspecialTributacao = regimeEspecialTributacao;
        return this;
    }

}
