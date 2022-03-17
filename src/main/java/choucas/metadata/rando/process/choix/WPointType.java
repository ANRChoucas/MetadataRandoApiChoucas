package choucas.metadata.rando.process.choix;

public enum WPointType {
	
	SOMMET {
	      public String toString() {
	          return "sommet";
	      }
	},

	COL {
		public String toString() {
			return "col";
		}
	},
	
	LAC {
		public String toString() {
			return "lac";
		}
	},
	
	CASCADE {
		public String toString() {
			return "cascade";
		}
	},
	
	LIEUDIT {
		public String toString() {
			return "lieu-dit";
		}
	},
	
	BISSE {
		public String toString() {
			return "bisse / béal";
		}
	},

	CANYON {
		public String toString() {
			return "canyon";
		}
	},
	 
	ESCALADE {
		public String toString() {
			return "site d’escalade";
		}
	},
	
	SAE {
		public String toString() {
			return "SAE";
		}
	},
	
	REFUGE {
		public String toString() {
			return "refuge/cabane";
		}
	},
	
	GITE {
		public String toString() {
			return "gîte";
		}
	},
	
	ABRI {
		public String toString() {
			return "abri";
		}
	},
	
	BIVOUAC {
		public String toString() {
			return "bivouac";
		}
	},
	
	CAMPING {
		@Override
		public String toString() {
			return "camping";
		}
	},
	
	CAMP {
		@Override
		public String toString() {
			return "camp de base";
		}
	},
	
	PRODUIT {
		@Override
		public String toString() {
			return "produits locaux";
		}
	},
	
	DEPART_PARAPENTE {
		@Override
		public String toString() {
			return "décollage parapente";
		}
	},
	
	ARR_PARAPENTE {
		@Override
		public String toString() {
			return "atterrissage parapente";
		}
	},
	
	GROTTE {
		@Override
		public String toString() {
			return "grotte";
		}
	},
	
	EAU {
		@Override
		public String toString() {
			return "point d’eau/source";
		}
	},
	
	METEO {
		@Override
		public String toString() {
			return "station météo";
		}
	},
	
	WEBCAM {
		@Override
		public String toString() {
			return "webcam";
		}
	},
	
	VIRTUEL {
		@Override
		public String toString() {
			return "virtuel";
		}
	},
	
	SPOT {
		@Override
		public String toString() {
			return "spot de slackline";
		}
	},
	
	DIVERS {
		@Override
		public String toString() {
			return "divers";
		}
	},
	
	ACCES {
		@Override
		public String toString() {
			return "accès routier / transports en commun";
		}
	}
	
}
