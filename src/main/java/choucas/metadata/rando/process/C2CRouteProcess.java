package choucas.metadata.rando.process;

import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.ComplexOutput;
import org.n52.javaps.algorithm.annotation.Execute;
import org.n52.javaps.algorithm.annotation.LiteralInput;
import org.n52.javaps.algorithm.annotation.LiteralOutput;

import choucas.metadata.rando.dao.FeaturesData;
import choucas.metadata.rando.process.choix.ActEnum;


/**
 * Documentation de l'API Refuges.info pour choucas.
 *    exemple: https://api.camptocamp.org/outings?limit=30&act=hiking&bbox=
 *    documentation: 
 * 
 * @author Marie-Dominique Van Damme
 * @version 1.0
 */
@Algorithm(title = "API des sorties de C2C par BBOX",
	abstrakt = "This service returns routes in mountain areas for planning sport activities from camptocamp API",
	version = "1.0.0")
public class C2CRouteProcess {
	
	
	// ------------------------------------------------------------------------
	//		INPUT  
	@LiteralInput(identifier = "bbox",
			title = "Les dimensions de la bbox à exporter",
			abstrakt = "Les dimensions de la bbox à exporter : xmin, ymin, xmax, ymax dans la projection 3857.",
			minOccurs = 1,
		    maxOccurs = 1,
			defaultValue=""		
	)
	public void setBbox(String bbox) {
	}
	
	
	@LiteralInput(identifier = "act",
            abstrakt = "L'activité pratiquée par le contributeur sur l'itinéraire, parmi la liste suivante :  skitouring, snow_ice_mixed, mountain_climbing, rock_climbing, ice_climbing, hingiking, snowshoeing, paragliding, mountain_biking, via_ferrata, slacklining.",
            title = "L'activité de la randonnée",
            defaultValue="")
	public ActEnum act;
	
	
	
	// ------------------------------------------------------------------------
	//      EXECUTE
	@Execute
	public void execute() {
	}
			
			
			
			
	// ------------------------------------------------------------------------
	// 		OUTPUT
			
	@LiteralOutput(identifier = "total",
            title = "Nombre de routes trouvées",
            abstrakt = "Nombre de routes dans la réponse de la requête")
	public Integer total;
	
	
	
	@ComplexOutput(identifier = "documents",
            abstrakt = "Liste des documents contenant la description courte des waypoints",
            title = "Liste des documents",
            binding = FeaturesData.class)
	public Object getDocuments() {
		return null;
	}

}
