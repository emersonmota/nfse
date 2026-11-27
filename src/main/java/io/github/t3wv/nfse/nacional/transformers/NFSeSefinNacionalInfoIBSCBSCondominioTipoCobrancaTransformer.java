package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalInfoIBSCBSCondominioTipoCobrancaTransformer implements Transform<NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca> {
    @Override
    public NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca read(String value) {
        return NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfoIBSCBSCondominioTipoCobranca value) {
        return value.getCodigo();
    }
}
