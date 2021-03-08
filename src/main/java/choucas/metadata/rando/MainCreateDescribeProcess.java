package choucas.metadata.rando;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.inject.Provider;

import org.n52.janmayen.http.MediaTypes;
import org.n52.javaps.algorithm.annotation.AnnotatedAlgorithmMetadata;
import org.n52.javaps.service.xml.WPSResponseWriter;
import org.n52.javaps.service.xml.WPSWriter;
import org.n52.shetland.ogc.wps.ProcessOffering;
import org.n52.shetland.ogc.wps.ProcessOfferings;
import org.n52.shetland.ogc.wps.description.ProcessDescription;
import org.n52.shetland.ogc.wps.response.DescribeProcessResponse;
import org.n52.svalbard.encode.exception.EncodingException;
import org.n52.svalbard.encode.stream.StreamWriter;
import org.n52.svalbard.encode.stream.StreamWriterRepository;
import org.n52.svalbard.encode.stream.xml.DocumentXmlStreamWriter;
import org.n52.svalbard.encode.stream.xml.ElementXmlStreamWriter;
import org.n52.svalbard.encode.stream.xml.ElementXmlStreamWriterRepository;

import choucas.metadata.rando.io.IORepo;
import choucas.metadata.rando.io.LiteralDataManagerImpl;
import choucas.metadata.rando.process.APItineraireProcess;
import choucas.metadata.rando.process.APWaypointProcess;
import choucas.metadata.rando.process.C2CRouteProcess;
import choucas.metadata.rando.process.C2CWaypointProcess;
import choucas.metadata.rando.process.RefugesInfoProcess;

/**
 * 
 * 
 * @author Marie-Dominique Van Damme
 * @version 1.0
 */
public class MainCreateDescribeProcess {
	
	private static final List<Provider<ElementXmlStreamWriter>> ELEMENT_WRITERS
		= Arrays.asList(WPSResponseWriter::new, WPSWriter::new);

	
	public ProcessDescription getProcessDescription(Class myProcess) {
		IORepo ioRepo = new IORepo();
		return new AnnotatedAlgorithmMetadata(myProcess, ioRepo, ioRepo, new LiteralDataManagerImpl()).getDescription();
	}


	private StreamWriterRepository createRepository() {
		DocumentXmlStreamWriter writer
	        = new DocumentXmlStreamWriter(new ElementXmlStreamWriterRepository(ELEMENT_WRITERS));
		StreamWriterRepository repository = new StreamWriterRepository();
		repository.set(Optional.of(Arrays.asList(() -> writer)));
		repository.init();
		return repository;
	}

	private <T> void write(StreamWriterRepository repo, T object, OutputStream out) throws EncodingException {
		@SuppressWarnings("unchecked")
		Class<? extends T> aClass = (Class<? extends T>) object.getClass();
		Optional<StreamWriter<? super T>> writer = repo.getWriter(MediaTypes.APPLICATION_XML, aClass);
	
		if (writer.isPresent()) {
			writer.get().write(object, out);
		}
	}


	@SuppressWarnings("rawtypes")
	private void createMetadataFiles(Class myProcess, String filename) throws Exception {
		StreamWriterRepository repo = createRepository();
		
		ProcessOffering processOffering = new ProcessOffering(getProcessDescription(myProcess));
		
		DescribeProcessResponse response = new DescribeProcessResponse();
	
	    response.setService("WPS");
	    response.setVersion("2.0.0");
	    response.setContentType(MediaTypes.APPLICATION_XML);
		
	    response.setOfferings(new ProcessOfferings(Collections.singleton(processOffering)));
	    
	    PrintStream writetoFile = new PrintStream(new FileOutputStream(filename, true)); 
	    write(repo, response, writetoFile);
	    writetoFile.close();
	}


	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainCreateDescribeProcess main = new MainCreateDescribeProcess();
			
			main.createMetadataFiles(RefugesInfoProcess.class, "./data/DescribeService/RefugesInfo_OOR_DescribeService.xml");
			
			System.out.println("-----");
			
			main.createMetadataFiles(C2CWaypointProcess.class, "./data/DescribeService/C2C_OOR_DescribeService.xml");
			main.createMetadataFiles(C2CRouteProcess.class, "./data/DescribeService/C2C_ITINERAIRE_DescribeService.xml");
			
			System.out.println("-----");
			
			main.createMetadataFiles(APWaypointProcess.class, "./data/DescribeService/AP_OOR_DescribeService.xml");
			main.createMetadataFiles(APItineraireProcess.class, "./data/DescribeService/AP_ITINERAIRE_DescribeService.xml");
			
			System.out.println("-----");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
