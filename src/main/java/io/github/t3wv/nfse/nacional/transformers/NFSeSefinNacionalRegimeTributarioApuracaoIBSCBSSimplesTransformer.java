package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimplesTransformer implements Transform<NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples> {
    @Override
    public NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples read(String value) {
        return NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalRegimeTributarioApuracaoIBSCBSSimples value) {
        return value.getCodigo();
    }
}
