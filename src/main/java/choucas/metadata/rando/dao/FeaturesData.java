package choucas.metadata.rando.dao;

import org.n52.javaps.io.complex.ComplexData;


public class FeaturesData implements ComplexData<Object> {

	private static final long serialVersionUID = 8586931812896959156L;
    
	private final Object objet;

    public FeaturesData(Object o) {
        this.objet = o;
    }

    @Override
    public Object getPayload() {
        return this.objet;
    }

    @Override
    public Class<?> getSupportedClass() {
        return Object.class;
    }
}
