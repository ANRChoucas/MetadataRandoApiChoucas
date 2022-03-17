package choucas.metadata.rando.process.choix;

public enum MergeStrategy {
	
	naive {
	      public String toString() {
	          return "Stratégie naïve";
	      }
	},
	
	polygonal {
	      public String toString() {
	          return "Enveloppe convexe";
	      }
	},
	
	detailed {
	      public String toString() {
	          return "Détaillée, unicité mixte";
	      }
	},

}
