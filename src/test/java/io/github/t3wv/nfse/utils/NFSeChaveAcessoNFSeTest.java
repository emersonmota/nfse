package io.github.t3wv.nfse.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Chave de acesso da NFS-e: 50 posições que podem ter letras (CNPJ alfanumérico e, a partir do
 * release 3 da NT SE/CGNFS-e 009, série da DPS mais código alfanumérico de 4 posições).
 */
public class NFSeChaveAcessoNFSeTest {

    private static final String CHAVE_NUMERICA = "26125051226063877000115250000000685425085159913279";
    //cMun(7) + amb(1) + tpInsc(1) + CNPJ(14) + nNFSe(13) + AAMM(4) + série(5) + código(4) + DV(1)
    private static final String CHAVE_RELEASE_3 = "2612505" + "1" + "2" + "26063877000115" + "0000000006854" + "2512" + "00001" + "AB7X" + "9";
    private static final String CHAVE_CNPJ_ALFANUMERICO = "2612505" + "1" + "2" + "12ABC34501DE35" + "0000000006854" + "2512" + "000012345" + "9";

    @Test
    public void aceitaChaveNumerica() {
        Assertions.assertEquals(CHAVE_NUMERICA, NFSeUtils.normalizarChaveAcessoNFSe(CHAVE_NUMERICA));
    }

    @Test
    public void aceitaChaveComLetras() {
        Assertions.assertEquals(50, CHAVE_RELEASE_3.length());
        Assertions.assertEquals(CHAVE_RELEASE_3, NFSeUtils.normalizarChaveAcessoNFSe(CHAVE_RELEASE_3));
    }

    @Test
    public void aceitaCnpjAlfanumericoNaChave() {
        Assertions.assertEquals(50, CHAVE_CNPJ_ALFANUMERICO.length());
        Assertions.assertEquals(CHAVE_CNPJ_ALFANUMERICO, NFSeUtils.normalizarChaveAcessoNFSe(CHAVE_CNPJ_ALFANUMERICO));
    }

    @Test
    public void tiraSeparadoresPrefixoEPassaParaMaiusculas() {
        final var chave = CHAVE_RELEASE_3;
        Assertions.assertEquals(chave, NFSeUtils.normalizarChaveAcessoNFSe("NFS" + chave));
        Assertions.assertEquals(chave, NFSeUtils.normalizarChaveAcessoNFSe("NFSe " + chave));
        Assertions.assertEquals(chave, NFSeUtils.normalizarChaveAcessoNFSe(chave.substring(0, 25) + "\u00a0" + chave.substring(25)));
        Assertions.assertEquals(chave, NFSeUtils.normalizarChaveAcessoNFSe(chave.substring(0, 10) + "." + chave.substring(10, 20) + "/" + chave.substring(20)));
        Assertions.assertEquals(chave, NFSeUtils.normalizarChaveAcessoNFSe(" " + chave.substring(0, 25) + "-" + chave.substring(25).toLowerCase() + " "));
    }

    @Test
    public void naoTiraLetrasDaChave() {
        //antes a normalização tirava tudo que não era dígito: a chave com letras virava 46 dígitos
        Assertions.assertEquals(50, NFSeUtils.normalizarChaveAcessoNFSe(CHAVE_RELEASE_3).length());
    }

    @Test
    public void rejeitaChaveInvalida() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFSeUtils.normalizarChaveAcessoNFSe(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFSeUtils.normalizarChaveAcessoNFSe(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFSeUtils.normalizarChaveAcessoNFSe("123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFSeUtils.normalizarChaveAcessoNFSe(CHAVE_NUMERICA + "1"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFSeUtils.normalizarChaveAcessoNFSe("ABC" + CHAVE_NUMERICA));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFSeUtils.normalizarChaveAcessoNFSe(CHAVE_NUMERICA.substring(1) + "Ç"));
        //caractere que vira letra ao passar para maiúsculas também é recusado
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFSeUtils.normalizarChaveAcessoNFSe(CHAVE_NUMERICA.substring(0, 48) + "ß"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFSeUtils.normalizarChaveAcessoNFSe(CHAVE_NUMERICA.substring(0, 49) + "ı"));
        //caractere inválido no meio é recusado, não apagado
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFSeUtils.normalizarChaveAcessoNFSe(CHAVE_NUMERICA + "Ç"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NFSeUtils.normalizarChaveAcessoNFSe(CHAVE_NUMERICA.substring(0, 20) + "_" + CHAVE_NUMERICA.substring(20)));
    }
}
