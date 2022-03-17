package choucas.metadata.rando.process;

import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.ComplexOutput;
import org.n52.javaps.algorithm.annotation.Execute;
import org.n52.javaps.algorithm.annotation.LiteralInput;
import org.n52.javaps.algorithm.annotation.LiteralOutput;

import choucas.metadata.rando.dao.FeaturesData;
import choucas.metadata.rando.process.choix.DatasetSource;
import choucas.metadata.rando.process.choix.MergeStrategy;

/**
 * Request the landmarks data warehouse. 3 strategy are defined to get the merged information:
 *     - naive
 *     - polygonal
 *     - detailed
 * 
 * @author Marie-Dominique Van Damme
 * @version 1.0
 */
@Algorithm(title = "Extraction of landmarks from the data warehouse per bounding box and merge strategy.",
	abstrakt = "This service returns different types of landmarks in mountain areas from the choucas data warehouse. The strategy defines the merging mode.",
	version = "1.0.0")
public class LandmarkIntegratedProcess {

	// ------------------------------------------------------------------------
	//  	DATA INPUT
	
	@LiteralInput(identifier = "bbox",
			title = "Les dimensions de la bbox contenant les objets de repères à exporter.",
			abstrakt = "Les dimensions de la bbox qui permettent de filtrer spatialement les objets de repères: "
				+ "xmin, ymin, xmax, ymax dans la projection 2154.",
			minOccurs = 1,
			maxOccurs = 1,
			defaultValue=""		
			)
	public void setBbox(String bbox) {
	}
	
	@LiteralInput(identifier = "landmarkType",
			title = "Le type des landmarks à exporter.",
			abstrakt = "Définir le type des objets de repère à exporter (lac, refuge, etc.). Les types correspondent aux classes de l'ontologie de repères (OOR).",
			minOccurs = 1,
			maxOccurs = 1,
			defaultValue=""		
			)
	public void setLandmarkType(String landmarkType) {
	}
	
	@LiteralInput(identifier = "landmarkName",
			title = "Le nom de l'objet de repère.",
			abstrakt = "Filtrer les objets de repères portant uniquement ce nom. Ce paramètre est optionnel",
			minOccurs = 0,
			maxOccurs = 1,
			defaultValue=""		
			)
	public void setLandmarkName(String landmarkName) {
	}
	
	@LiteralInput(identifier = "strategy",
            abstrakt = "La stratégie de fusion permet de définir sous quelle forme les données fusionnées vont sortir du service. "
            + "La fusion porte aussi bien sur la géométrie que sur les attributs. La fusion 'detailed' nécessite obligatoirement la saisie du paramètre source.",
            title = "La stratégie de fusion",
            minOccurs = 1,
            maxOccurs = 1,
            defaultValue="naive")
	public MergeStrategy strategy;
	
	
	@LiteralInput(identifier = "datasetsource",
            abstrakt = "Le nom de la source de données fusionnée avec la BDTopo. Si la stratégie de fusion 'detailed' est choisie.",
            title = "Le nom de la source de données fusionnée avec la BDTopo. Si la stratégie de fusion 'detailed' est choisie.",
            minOccurs = 0,
            maxOccurs = 1)
	public DatasetSource datasetSource;
	
	
	// ------------------------------------------------------------------------
	//      EXECUTE
	@Execute
	public void execute() {
	}
		
	
	// ------------------------------------------------------------------------
	// 		OUTPUT
	@LiteralOutput(identifier = "total",
			title = "Nombre de landmarks trouvés",
			abstrakt = "Nombre de landmarks dans la réponse de la requête")
	public Integer total;
		
		
	@ComplexOutput(identifier = "documents",
			abstrakt = "Liste des objets de repères fusionnés",
			title = "Liste des landmarks avec attributs et géométries fusionnées suivant la stratégie choisie.",
			binding = FeaturesData.class)
	public Object getDocuments() {
		return null;
	}

}
