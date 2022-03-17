package choucas.metadata.rando.io;

import java.net.URI;
import java.util.Optional;

import org.n52.javaps.io.literal.LiteralType;
import org.n52.javaps.io.literal.LiteralTypeRepository;
import org.n52.javaps.io.literal.xsd.LiteralIntType;
import org.n52.javaps.io.literal.xsd.LiteralStringType;


public class LiteralDataManagerImpl implements LiteralTypeRepository {
	
	@Override
    @SuppressWarnings("unchecked")
    public <T> LiteralType<T> getLiteralType(
            Class<? extends LiteralType<?>> literalType, Class<?> payloadType) {

        if (literalType == null || literalType.equals(LiteralType.class)) {
            if (payloadType != null) {
                if (payloadType.equals(String.class)) {
                    return (LiteralType<T>) new LiteralStringType();
                } else if (payloadType.equals(Integer.class)) {
                    return (LiteralType<T>) new LiteralIntType();
                } else {
                    throw new Error("Unsupported payload type");
                }
            } else {
                throw new Error("Neither payload type nro literal type given");
            }
        } else {
            try {
                return (LiteralType<T>) literalType.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                throw new Error(ex);
            }
        }
    }

    @Override
    public Optional<LiteralType<?>> getLiteralType(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<LiteralType<?>> getLiteralType(URI uri) {
        return Optional.empty();
    }

}
