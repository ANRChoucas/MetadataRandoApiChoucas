package choucas.metadata.rando.process;

import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.ComplexOutput;
import org.n52.javaps.algorithm.annotation.Execute;

import choucas.metadata.rando.dao.FeaturesData;

/**
 * Documentation de l'API des parcs nationaux et régionaux
 * 
 * @author Marie-Dominique Van Damme
 * @version 1.0
 */
@Algorithm(title = "API des itinéraires du Parc naturel régional du Vercors et du parc National des Ecrins",
	abstrakt = "This service returns routes in mountain areas for planning sport activities",
	version = "1.0.0")
public class APItineraireProcess {
	
	// ------------------------------------------------------------------------
	//      EXECUTE
	@Execute
	public void execute() {
	}
				
				
	// ------------------------------------------------------------------------
	// 		OUTPUT
	@ComplexOutput(identifier = "features",
			abstrakt = "Liste des routes retournées dans la réponse",
			title = "Liste des routes",
			binding = FeaturesData.class)
	public Object getFeatures() {
		return null;
	}

}
