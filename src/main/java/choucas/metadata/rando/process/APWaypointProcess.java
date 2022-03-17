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
@Algorithm(title = "API des points d'intérêt des Aires protégées: parc naturel régional du Vercors, Parc National des Ecrins",
	abstrakt = "This service returns different types of POI in mountain areas for planning sport activities from rando.parc-du-vercors and rando.ecrins-parcnational.fr API",
	version = "1.0.0")
public class APWaypointProcess {
	
	// ------------------------------------------------------------------------
	//      EXECUTE
	@Execute
	public void execute() {
	}
			
			
	// ------------------------------------------------------------------------
	// 		OUTPUT
	@ComplexOutput(identifier = "features",
            abstrakt = "Liste des pois retournés dans la réponse",
            title = "Liste des pois",
            binding = FeaturesData.class)
	public Object getFeatures() {
		return null;
	}
	
}
