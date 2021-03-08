package choucas.metadata.rando.process;

import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.ComplexOutput;
import org.n52.javaps.algorithm.annotation.Execute;
import org.n52.javaps.algorithm.annotation.LiteralInput;
import org.n52.javaps.algorithm.annotation.LiteralOutput;

import choucas.metadata.rando.dao.FeaturesData;
import choucas.metadata.rando.process.choix.WPointType;


/**
 * Documentation de l'API CamptoCamp pour choucas.
 *    exemple: https://api.camptocamp.org/waypoints?limit=30&wtyp=gite,hut,shelter&bbox=
 *    documentation: 
 * 
 * @author Marie-Dominique Van Damme
 * @version 1.0
 */
@Algorithm(title = "API des waypoints de C2C par BBOX",
	abstrakt = "This service returns different types of POI in mountain areas for planning sport activities from camptocamp API",
	version = "1.0.0")
public class C2CWaypointProcess {
	
	
	// ------------------------------------------------------------------------
	//  
	@LiteralInput(identifier = "bbox",
			title = "Les dimensions de la bbox à exporter",
			abstrakt = "Les dimensions de la bbox à exporter : xmin, ymin, xmax, ymax dans la projection 3857.",
			minOccurs = 1,
		    maxOccurs = 1,
			defaultValue=""		
	)
	public void setBbox(String bbox) {
	}
	
	
	@LiteralInput(identifier = "wtyp",
            abstrakt = "Le type des waypoints à exporter, parmi la liste suivante :  sommet, col, lac, cascade, lieu-dit, bisse / béal, canyon, site d’escalade, SAE, refuge/cabane, gîte, abri, bivouac, camping, camp de base, produits locaux, décollage parapente, atterrissage parapente, grotte, point d’eau/source, station météo, webcam, virtuel, spot de slackline, divers, accès routier / transports en commun.",
            title = "Le type des waypoints à exporter",
            defaultValue="")
	public WPointType wtyp;
	
	
	
	// ------------------------------------------------------------------------
	//      EXECUTE
	@Execute
	public void execute() {
	}
		
		
		
		
	// ------------------------------------------------------------------------
	// 		OUTPUT
		
	@LiteralOutput(identifier = "total",
            title = "Nombre de waypoints trouvés",
            abstrakt = "Nombre de waypoints dans la réponse de la requête")
	public Integer total;
	
	
	
	@ComplexOutput(identifier = "documents",
            abstrakt = "Liste des documents contenant la description courte des waypoints",
            title = "Liste des documents",
            binding = FeaturesData.class)
	public Object getDocuments() {
		return null;
	}

	
	
}
