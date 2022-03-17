package choucas.metadata.rando.io;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.n52.javaps.io.Data;
import org.n52.javaps.io.InputHandler;
import org.n52.javaps.io.InputHandlerRepository;
import org.n52.javaps.io.OutputHandler;
import org.n52.javaps.io.OutputHandlerRepository;
import org.n52.shetland.ogc.wps.Format;

public class IORepo implements OutputHandlerRepository, InputHandlerRepository {
	
	private static final Set<Format> FORMATS = new HashSet<>(Arrays.asList(
		    new Format("text/xml", "UTF-8", "http://www.opengis.net/gml/3.2"),
		    new Format("text/xml", "UTF-16", "http://www.opengis.net/gml/3.2"),
		    new Format("text/xml", (String)null, "http://www.opengis.net/gml/3.2"),
		    new Format("text/xml", (String)null, null),
		    new Format("text/xml", "UTF-8", null),
		    new Format("text/xml", "UTF-16", null)));

	@Override
    public Set<OutputHandler> getOutputHandlers() {
        return Collections.emptySet();
    }

    @Override
    public Optional<OutputHandler> getOutputHandler(Format format, Class<? extends Data<?>> binding) {
        return Optional.empty();
    }

    @Override
    public Set<Format> getSupportedFormats() {
        return Collections.unmodifiableSet(FORMATS);
    }

    @Override
    public Set<Format> getSupportedFormats(Class<? extends Data<?>> binding) {
        return getSupportedFormats();
    }
    @Override
    public Set<InputHandler> getInputHandlers() {
        return Collections.emptySet();
    }

    @Override
    public Optional<InputHandler> getInputHandler(Format format, Class<? extends Data<?>> binding) {
        return Optional.empty();
    }
  
}
