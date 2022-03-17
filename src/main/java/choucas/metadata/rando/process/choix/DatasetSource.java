package choucas.metadata.rando.process.choix;

public enum DatasetSource {

	c2c {
		public String toString() {
			return "camptocamp.org";
		}
	},
	
	parcs {
		public String toString() {
			return "rando.ecrins-parcnational.fr et rando.parc-du-vercors.fr";
		}
	},
	
	refinfo {
		public String toString() {
			return "www.refuges.info";
		}
	},
	
	osm {
		public String toString() {
			return "openstreetmap.org";
		}
	}
}
