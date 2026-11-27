
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.math.BigDecimal;

/**
 * Grupo de informações relativas à exportação/importação de serviço prestado
 */

@Root(name = "ComExterior")
public class NFSeSefinNacionalComercioExterior {

    @Element(name = "mdPrestacao")
    protected NFSeSefinNacionalComercioExteriorModoPrestacao modoPrestacao;
    @Element(name = "vincPrest")
    protected NFSeSefinNacionalComercioExteriorVinculoEntrePartes vinculoEntrePartes;
    @Element(name = "tpMoeda")
    protected String moeda;
    // Release 2 da NT 009 (XSD de 24/11/2026): vServMoeda saiu; nFatura e vFatura (opcionais) entraram.
    @Element(name = "nFatura", required = false)
    protected String numeroFatura;
    @Element(name = "vFatura", required = false)
    protected BigDecimal valorFatura;
    @Element(name = "mecAFComexP")
    protected NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador mecanismoApoioComercioExteriorPrestador;
    @Element(name = "mecAFComexT")
    protected NFSeSefinNacionalComercioExteriorMecanismoApoioTomador mecanismoApoioComercioExteriorTomador;
    @Element(name = "movTempBens")
    protected NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens movimentacaoTemporariaBens;
    // Release 2 da NT 009: nDI e nRE deram lugar a nDUIMP (15 caracteres) e nDUE (14 caracteres).
    @Element(name = "nDUIMP", required = false)
    protected String nduimp;
    @Element(name = "nDUE", required = false)
    protected String ndue;
    @Element(name = "mdic")
    protected NFSeSefinNacionalComercioExteriorCompartilharComMDIC compartilharComMDIC;
    @Element(name = "nContCambio", required = false)
    protected String numeroContratoCambio;

    /**
     * @return Modo de prestação do serviço
     */
    public NFSeSefinNacionalComercioExteriorModoPrestacao getModoPrestacao() {
        return modoPrestacao;
    }

    /**
     * Define o modo de prestação do serviço
     *
     * @param modoPrestacao Modo de prestação do serviço
     */
    public NFSeSefinNacionalComercioExterior setModoPrestacao(NFSeSefinNacionalComercioExteriorModoPrestacao modoPrestacao) {
        this.modoPrestacao = modoPrestacao;
        return this;
    }

    /**
     * @return Vínculo entre as partes no negócio
     */
    public NFSeSefinNacionalComercioExteriorVinculoEntrePartes getVinculoEntrePartes() {
        return vinculoEntrePartes;
    }

    /**
     * Define o vínculo entre as partes no negócio
     *
     * @param vinculoEntrePartes Vínculo entre as partes
     */
    public NFSeSefinNacionalComercioExterior setVinculoEntrePartes(NFSeSefinNacionalComercioExteriorVinculoEntrePartes vinculoEntrePartes) {
        this.vinculoEntrePartes = vinculoEntrePartes;
        return this;
    }

    /**
     * @return Moeda utilizada na transação
     */
    public String getMoeda() {
        return moeda;
    }

    /**
     * Define a moeda da transação comercial
     *
     * @param moeda Moeda
     */
    public NFSeSefinNacionalComercioExterior setMoeda(String moeda) {
        this.moeda = moeda;
        return this;
    }

    /**
     * @return Número da fatura de serviços ou do documento que comprove a transação (Decreto 12.955/2026, art. 74, § 1º)
     */
    public String getNFatura() {
        return numeroFatura;
    }

    /**
     * Número da fatura de serviços ou do documento que comprove a transação, até 20 dígitos.
     * Só quando exigido documento fiscal para acobertar a importação do serviço.
     *
     * @param numeroFatura número da fatura
     */
    public NFSeSefinNacionalComercioExterior setNFatura(String numeroFatura) {
        this.numeroFatura = numeroFatura;
        return this;
    }

    /**
     * @return Valor total da fatura de serviços ou do documento que comprove a transação, na moeda de tpMoeda
     */
    public BigDecimal getVFatura() {
        return valorFatura;
    }

    /**
     * Define o valor total da fatura de serviços ou do documento que comprove a transação, na moeda de tpMoeda
     *
     * @param valorFatura valor da fatura na moeda estrangeira
     */
    public NFSeSefinNacionalComercioExterior setVFatura(BigDecimal valorFatura) {
        this.valorFatura = valorFatura;
        return this;
    }

    /**
     * @return Mecanismo de apoio ao comércio exterior do utilizado pelo prestador
     */
    public NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador getMecanismoApoioComercioExteriorPrestador() {
        return mecanismoApoioComercioExteriorPrestador;
    }

    /**
     * @param mecanismoApoioComercioExteriorPrestador Define o mecanismo de apoio ao comércio exterior utilizado pelo prestador
     */
    public NFSeSefinNacionalComercioExterior setMecanismoApoioComercioExteriorPrestador(NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador mecanismoApoioComercioExteriorPrestador) {
        this.mecanismoApoioComercioExteriorPrestador = mecanismoApoioComercioExteriorPrestador;
        return this;
    }

    /**
     * @return Mecanismo de apoio ao comércio exterior do utilizado pelo tomador
     */
    public NFSeSefinNacionalComercioExteriorMecanismoApoioTomador getMecanismoApoioComercioExteriorTomador() {
        return mecanismoApoioComercioExteriorTomador;
    }

    /**
     * @param mecanismoApoioComercioExteriorTomador Define o mecanismo de apoio ao comércio exterior utilizado pelo tomador
     */
    public NFSeSefinNacionalComercioExterior setMecanismoApoioComercioExteriorTomador(NFSeSefinNacionalComercioExteriorMecanismoApoioTomador mecanismoApoioComercioExteriorTomador) {
        this.mecanismoApoioComercioExteriorTomador = mecanismoApoioComercioExteriorTomador;
        return this;
    }

    /**
     * @return Indica se operação está vinculada a movimentação temporária de bens
     */
    public NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens getMovimentacaoTemporariaBens() {
        return movimentacaoTemporariaBens;
    }

    /**
     * @param movimentacaoTemporariaBens Define se operação está vinculada a movimentação temporária de bens
     */
    public NFSeSefinNacionalComercioExterior setMovimentacaoTemporariaBens(NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens movimentacaoTemporariaBens) {
        this.movimentacaoTemporariaBens = movimentacaoTemporariaBens;
        return this;
    }

    /**
     * @return Número da Declaração Única de Importação (DUIMP)
     */
    public String getNDUIMP() {
        return nduimp;
    }

    /**
     * Define o número da Declaração Única de Importação (DUIMP), 15 caracteres. Só para serviço
     * relacionado à importação de um bem material.
     *
     * @param nduimp Número da DUIMP
     */
    public NFSeSefinNacionalComercioExterior setNDUIMP(String nduimp) {
        this.nduimp = nduimp;
        return this;
    }

    /**
     * @return Número da Declaração Única de Exportação (DU-E)
     */
    public String getNDUE() {
        return ndue;
    }

    /**
     * Define o número da Declaração Única de Exportação (DU-E), 14 caracteres. Só para serviço
     * relacionado à exportação de um bem material.
     *
     * @param ndue Número da DU-E
     */
    public NFSeSefinNacionalComercioExterior setNDUE(String ndue) {
        this.ndue = ndue;
        return this;
    }

    /**
     * @return Compartilhamento de informações com o MDIC
     */
    public NFSeSefinNacionalComercioExteriorCompartilharComMDIC getCompartilharComMDIC() {
        return compartilharComMDIC;
    }

    /**
     * Define o compartilhamento de informações com o MDIC
     *
     * @param compartilharComMDIC Compartilhamento de informações com o MDIC
     */
    public NFSeSefinNacionalComercioExterior setCompartilharComMDIC(NFSeSefinNacionalComercioExteriorCompartilharComMDIC compartilharComMDIC) {
        this.compartilharComMDIC = compartilharComMDIC;
        return this;
    }

    /**
     * @return Número do contrato de câmbio ou do documento que comprove o pagamento
     */
    public String getNContCambio() {
        return numeroContratoCambio;
    }

    /**
     * Define o número do contrato de câmbio ou do documento que comprove o pagamento, até 20 dígitos
     * (Decreto 12.955/2026, art. 74, § 1º)
     *
     * @param numeroContratoCambio número do contrato de câmbio
     */
    public NFSeSefinNacionalComercioExterior setNContCambio(String numeroContratoCambio) {
        this.numeroContratoCambio = numeroContratoCambio;
        return this;
    }

}
