package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalCServAtividadeSimplesNacional;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalCServAtividadeSimplesNacionalTransformer implements Transform<NFSeSefinNacionalCServAtividadeSimplesNacional> {
    @Override
    public NFSeSefinNacionalCServAtividadeSimplesNacional read(String value) {
        return NFSeSefinNacionalCServAtividadeSimplesNacional.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalCServAtividadeSimplesNacional value) {
        return value.getCodigo();
    }
}
