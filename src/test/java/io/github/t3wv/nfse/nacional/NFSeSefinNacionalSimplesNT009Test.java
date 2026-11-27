package io.github.t3wv.nfse.nacional;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.*;
import io.github.t3wv.nfse.utils.NFSePersister;
import io.github.t3wv.nfse.utils.NFSeUtils;
import io.github.t3wv.nfse.utils.NFSeXmlValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.transform.stream.StreamSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Campos do Simples Nacional da NT SE/CGNFS-e 009 v1.01, item 2.4 (release 4 da plataforma, produção em 24/12/2026).
 * <p>
 * O XSD de produção restrita de 20/10/2026 ainda não tem esses campos. A posição de cada um segue a NT
 * (regApIBSCBSSN em prest/regTrib, cAtvSN em serv/cServ) e deve ser conferida quando o XSD do release 4 sair.
 */
public class NFSeSefinNacionalSimplesNT009Test {

    @Test
    public void dpsSemOsCamposDoSimplesContinuaValidaNoXsdAtual() throws Exception {
        Assertions.assertEquals(List.of(), errosExcetoAssinatura(dpsSimples().toXml()));
    }

    @Test
    public void regApIBSCBSSNFicaNoRegTribDepoisDoRegApTribSNEAntesDoRegEspTrib() throws Exception {
        final var dps = dpsSimples();
        dps.getInfDPS().getPrestador().getRegimeTributario()
                .setRegimeApuracaoAposLimiteSimplesNacional(NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples.SN)
                .setRegimeApuracaoIBSCBSSimplesNacional(NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples.IBS_CBS_PELO_SN);
        final var xml = dps.toXml();

        Assertions.assertTrue(xml.contains("<regTrib><opSimpNac>3</opSimpNac><regApTribSN>1</regApTribSN>"
                + "<regApIBSCBSSN>1</regApIBSCBSSN><regEspTrib>0</regEspTrib></regTrib>"), xml);
    }

    @Test
    public void cAtvSNFicaNoCServDepoisDoCNBS() throws Exception {
        final var dps = dpsSimples();
        dps.getInfDPS().getServicoPrestado().getCServ()
                .setCodigoInternoContribuinte("VET01")
                .setCodigoAtividadeSimplesNacional(NFSeSefinNacionalCServAtividadeSimplesNacional.SERVICOS_ISS_ANEXO_III);
        final var xml = dps.toXml();

        Assertions.assertTrue(xml.contains("<cNBS>114061100</cNBS><cAtvSN>7</cAtvSN><cIntContrib>VET01</cIntContrib>"
                + "<xDescServ>Servico de teste</xDescServ>"), xml);
    }

    @Test
    public void camposDoSimplesSaoOsUnicosErrosNoXsdAtual() throws Exception {
        final var dps = dpsSimples();
        dps.getInfDPS().getPrestador().getRegimeTributario()
                .setRegimeApuracaoIBSCBSSimplesNacional(NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples.CBS_PELO_SN_IBS_REGULAR);
        dps.getInfDPS().getServicoPrestado().getCServ()
                .setCodigoAtividadeSimplesNacional(NFSeSefinNacionalCServAtividadeSimplesNacional.SERVICOS_FATOR_R_ANEXO_III_OU_V);

        final var erros = errosExcetoAssinatura(dps.toXml());

        Assertions.assertFalse(erros.isEmpty());
        Assertions.assertTrue(erros.stream().allMatch(e -> e.contains("regApIBSCBSSN") || e.contains("cAtvSN")), String.join("\n", erros));
    }

    @Test
    public void camposDoSimplesFazemIdaEVoltaPeloXml() throws Exception {
        final var dps = dpsSimples();
        dps.getInfDPS().getPrestador().getRegimeTributario()
                .setOpSimplesNacional(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.OPTANTE_PENDENTE)
                .setRegimeApuracaoIBSCBSSimplesNacional(NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples.IBS_CBS_REGULAR);
        dps.getInfDPS().getServicoPrestado().getCServ()
                .setCodigoAtividadeSimplesNacional(NFSeSefinNacionalCServAtividadeSimplesNacional.OPERACOES_NAO_TRIBUTADAS);
        final var xml = dps.toXml();
        Assertions.assertTrue(xml.contains("<opSimpNac>4</opSimpNac>"), xml);
        Assertions.assertTrue(xml.contains("<cAtvSN>90</cAtvSN>"), xml);

        final var lida = new NFSePersister().read(NFSeSefinNacionalDPS.class, xml);

        final var regTrib = lida.getInfDPS().getPrestador().getRegimeTributario();
        Assertions.assertEquals(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.OPTANTE_PENDENTE, regTrib.getOpSimplesNacional());
        Assertions.assertEquals(NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples.IBS_CBS_REGULAR, regTrib.getRegimeApuracaoIBSCBSSimplesNacional());
        Assertions.assertEquals(NFSeSefinNacionalCServAtividadeSimplesNacional.OPERACOES_NAO_TRIBUTADAS,
                lida.getInfDPS().getServicoPrestado().getCServ().getCodigoAtividadeSimplesNacional());
    }

    @Test
    public void todosOsCodigosDaNtSaoReconhecidos() {
        Assertions.assertEquals(List.of("7", "8", "9", "10", "11", "12", "13", "14", "90"),
                java.util.Arrays.stream(NFSeSefinNacionalCServAtividadeSimplesNacional.values()).map(NFSeSefinNacionalCServAtividadeSimplesNacional::getCodigo).toList());
        Assertions.assertEquals(List.of("1", "2", "3"),
                java.util.Arrays.stream(NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples.values()).map(NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples::getCodigo).toList());
        Assertions.assertNull(NFSeSefinNacionalCServAtividadeSimplesNacional.valueOfCodigo("1"));
        Assertions.assertEquals(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.OPTANTE_PENDENTE,
                NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.valueOfCodigo("4"));
    }

    @Test
    public void nfseComGTribSNEReceitaBrutaSNELida() throws Exception {
        // Optante com IBS e CBS pelo Simples: a SEFIN manda gTribSN e omite vIBSTot, gIBSUFTot, gIBSMunTot e vCBS.
        final var ibscbs = new NFSePersister().read(NFSeSefinNacionalInfNFSeIBSCBS.class,
                "<IBSCBS><cLocalidadeIncid>2910800</cLocalidadeIncid><xLocalidadeIncid>Feira de Santana</xLocalidadeIncid>"
                        + "<valores><vBC>100.00</vBC><vReceitaBrutaSN>100.00</vReceitaBrutaSN>"
                        + "<uf><pIBSUF>0.10</pIBSUF><pAliqEfetUF>0.10</pAliqEfetUF></uf>"
                        + "<mun><pIBSMun>0.00</pIBSMun><pAliqEfetMun>0.00</pAliqEfetMun></mun>"
                        + "<fed><pCBS>0.90</pCBS><pAliqEfetCBS>0.90</pAliqEfetCBS></fed></valores>"
                        + "<totCIBS><vTotNF>100.00</vTotNF><gIBS></gIBS><gCBS></gCBS>"
                        + "<gTribSN><pIBSSN>0.10</pIBSSN><vIBSSN>0.10</vIBSSN><pCBSSN>0.90</pCBSSN><vCBSSN>0.90</vCBSSN></gTribSN>"
                        + "</totCIBS></IBSCBS>");

        Assertions.assertEquals(new BigDecimal("100.00"), ibscbs.getValores().getvReceitaBrutaSN());
        final var tribSN = ibscbs.getTotCIBS().getgTribSN();
        Assertions.assertEquals(new BigDecimal("0.10"), tribSN.getpIBSSN());
        Assertions.assertEquals(new BigDecimal("0.10"), tribSN.getvIBSSN());
        Assertions.assertEquals(new BigDecimal("0.90"), tribSN.getpCBSSN());
        Assertions.assertEquals(new BigDecimal("0.90"), tribSN.getvCBSSN());
        Assertions.assertNull(ibscbs.getTotCIBS().getgIBS().getvIBSTot());
        Assertions.assertNull(ibscbs.getTotCIBS().getgCBS().getvCBS());
    }

    private static NFSeSefinNacionalDPS dpsSimples() {
        final var tomador = new NFSeSefinNacionalInfoPessoa().setCPF("12345678909");
        tomador.setNome("TOMADOR HOMOLOGACAO");
        tomador.setEndereco(new NFSeSefinNacionalEndereco()
                .setEnderecoNacional(new NFSeSefinNacionalEnderNac().setCodigoMunicipio("2910800").setCEP("44001000"))
                .setLogradouro("RUA TESTE").setNumero("100").setBairro("CENTRO"));
        final var prestador = new NFSeSefinNacionalInfoPrestador()
                .setCNPJ("59252217000131")
                .setRegimeTributario(new NFSeSefinNacionalRegTrib()
                        .setOpSimplesNacional(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.ME_EPP)
                        .setRegimeEspecialTributacao(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.NENHUM));
        final var dps = new NFSeSefinNacionalDPS().setInfDPS(new NFSeSefinNacionalInfDPS()
                .setTipoAmbiente(NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO)
                .setDataHoraEmissao(ZonedDateTime.of(2026, 12, 24, 10, 0, 0, 0, ZoneId.of("-03:00")))
                .setVersaoApp("teste-nt009-sn")
                .setSerie("1")
                .setNumeroDPS(90011)
                .setDataInicioPrestacaoServico(LocalDate.of(2026, 12, 24))
                .setTipoEmitente(NFSeSefinNacionalInfDPSTipoEmitente.PRESTADOR)
                .setCodigoMunicipioEmissao("2910800")
                .setPrestador(prestador)
                .setTomador(tomador)
                .setServicoPrestado(new NFSeSefinNacionalServ()
                        .setLocalPrestacao(new NFSeSefinNacionalLocPrest().setCodigoMunicipio("2910800"))
                        .setCServ(new NFSeSefinNacionalCServ()
                                .setCodigoNacionalTributacaoISSQN("010701")
                                .setDescricaoServico("Servico de teste")
                                .setCodigoNBS("114061100")))
                .setValores(new NFSeSefinNacionalInfoValores()
                        .setValoresServicoPrestado(new NFSeSefinNacionalVServPrest().setValorServicos(new BigDecimal("100.00")))
                        .setTributos(new NFSeSefinNacionalInfoTributacao()
                                .setTributosMunicipais(new NFSeSefinNacionalTribMunicipal()
                                        .setTributacaoISSQN(NFSeSefinNacionalTribMunicipalTributacaoISSQN.OPERACAO_TRIBUTAVEL)
                                        .setTipoRetencaoISSQN(NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN.NAO_RETIDO))
                                .setTotalTributos(new NFSeSefinNacionalTribTotal().setIndicadorValorTotalTributos("0"))))
                .setInfoIBSCBS(new NFSeSefinNacionalInfoIBSCBS()
                        .setIndFinal(false)
                        .setcIndOp("100301")
                        .setIndDest(NFSeSefinNacionalInfoIBSCBSIndDest.TOMADOR)
                        .setValores(new NFSeSefinNacionalInfoIBSCBSInfoValoresIBSCBS()
                                .setTrib(new NFSeSefinNacionalInfoIBSCBSInfoTributos()
                                        .setCST("000")
                                        .setcClassTrib("000001")))));
        dps.getInfDPS().setId(NFSeUtils.gerarDPSId(dps));
        return dps;
    }

    private static List<String> errosExcetoAssinatura(final String xml) throws Exception {
        final var xsd = NFSeSefinNacionalSimplesNT009Test.class.getClassLoader().getResource(WSSefinNFSe.XSD_DPS).toURI().toString();
        final var erros = new NFSeXmlValidator(new StreamSource(xsd)).validateAndGetErrors(xml).getLeft();
        return erros.stream().filter(erro -> !erro.contains("Signature")).toList();
    }
}
