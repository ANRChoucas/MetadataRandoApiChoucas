package choucas.metadata.rando.process;

import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.ComplexOutput;
import org.n52.javaps.algorithm.annotation.Execute;
import org.n52.javaps.algorithm.annotation.LiteralInput;
import org.n52.javaps.algorithm.annotation.LiteralOutput;

import choucas.metadata.rando.dao.FeaturesData;


/**
 * Documentation de l'API Refuges.info pour choucas.
 *    exemple: https://www.refuges.info/api/bbox?type_points=refuge
 *    documentation: https://www.refuges.info/api/doc/#/api/bbox
 * 
 * @author Marie-Dominique Van Damme
 * @version 1.0
 */
@Algorithm(title = "API refuges.info par BBOX",
	abstrakt = "This service returns different types of POI in mountain areas for planning sport activities from refuge.info API",
	version = "1.0.0")
public class RefugesInfoProcess {
	
	
	// ------------------------------------------------------------------------
	//     INPUT
	
	@LiteralInput(identifier = "type_points",
            abstrakt = "Les types de point à exporter, parmi la liste suivante : cabane, refuge, gite, pt_eau, sommet, pt_passage, bivouac et lac. La valeur all sélectionne tous les types.",
            title = "Les types de point",
//            minOccurs = 0,
//            maxOccurs = 1,
            defaultValue="all")
	public TypeEnum type_points;
	
	public static enum TypeEnum {
		all,
		cabane,
		refuge,
		gite,
		pt_eau,
		sommet,
		pt_passage
	}
	
	@LiteralInput(identifier = "bbox",
			title = "Les dimensions de la bbox à exporter",
			abstrakt = "Les dimensions de la bbox à exporter dans la projection 4326: ouest, sud, est, nord. Il est possible de sélectionner la planète entière via la valeur world.",
			minOccurs = 1,
		    maxOccurs = 1,
			defaultValue="-13.00,44.05,17.00,49.79"		)
	public void setBbox(String bbox) {
	}
	
	
	@LiteralInput(identifier = "format",
            abstrakt = "Le format de l'export:geojson, kml, gml, gpx, csv, xml. C'est le format geojson par défaut.",
            title = "Le format de l'export",
            minOccurs = 0,
            maxOccurs = 1,
            defaultValue = "geojson")
	public FormatEnum format;
	
	public static enum FormatEnum {
		geojson,
		kml,
		gml,
		gpx,
		csv,
		xml
	}
	
	
	
	
	
	
	// ------------------------------------------------------------------------
	//      EXECUTE
	@Execute
	public void execute() {
	}
	
	
	
	
	// ------------------------------------------------------------------------
	// 		OUTPUT
	
	@LiteralOutput(identifier = "timestamp",
            title = "Timestamp de la requête",
            abstrakt = "Timestamp de la requête")
	public String timestamp;
	
	
	@ComplexOutput(identifier = "output",
             abstrakt = "Liste des poi contenus dans une bbox",
             title = "Liste des poi",
             binding = FeaturesData.class)
	public Object getOutput() {
		return null;
	}

	
}


