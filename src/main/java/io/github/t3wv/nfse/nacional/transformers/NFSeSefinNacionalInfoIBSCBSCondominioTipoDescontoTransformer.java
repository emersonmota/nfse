package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalInfoIBSCBSCondominioTipoDescontoTransformer implements Transform<NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto> {
    @Override
    public NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto read(String value) {
        return NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfoIBSCBSCondominioTipoDesconto value) {
        return value.getCodigo();
    }
}
