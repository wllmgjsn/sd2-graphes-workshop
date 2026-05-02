import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatriceDAdjacence extends Graph{
	
	private Map<Integer, Airport>  correspondanceIndiceAirport;
	private Map<Airport, Integer>  correspondanceAirportIndice;
	private Flight[][] matrice= new Flight[0][0];
	private int nbAirport=0;

	public MatriceDAdjacence() {
		super();
		correspondanceAirportIndice= new HashMap<Airport,Integer>();
		correspondanceIndiceAirport= new HashMap<Integer,Airport>();
	}

	@Override
	// Complexit?: o(n²)
	protected void ajouterSommet(Airport a) {	
		Flight[][] newMatrice = new Flight[nbAirport+1][nbAirport+1];
		if(matrice.length != 0) {
			for(int i = 0; i < nbAirport; i++){
				for(int j = 0; j < nbAirport ; j++){
					newMatrice[i][j] = matrice[i][j];
				}
			}
		}
		correspondanceIndiceAirport.put(nbAirport, a);
		correspondanceAirportIndice.put(a, nbAirport);
		nbAirport++;
	}

	@Override
	// Complexit?: o(1)
	protected void ajouterArc(Flight f) {
		Integer source = correspondanceAirportIndice.get(f.getSource());
		Integer destination = correspondanceAirportIndice.get(f.getDestination());
		if(matrice[source][destination] == null){
			matrice[source][destination] = f;
		} else {
			throw new IllegalArgumentException("Flight with same origin and destination already registered");
		}
	}

	@Override
	// Complexit?: ?
	public Set<Flight> arcsSortants(Airport a) {
		Integer source = correspondanceAirportIndice.get(a);
		Set<Flight> result = new HashSet();
		for(int i = 0; i < nbAirport; i++){
			if(matrice[source][i] != null){
				result.add(matrice[source][i]);
			}
		}
		return result;
	}

	@Override
	// Complexit?: o(1)
	public boolean sontAdjacents(Airport a1, Airport a2) {
		Integer source = correspondanceAirportIndice.get(a1);
		Integer destination = correspondanceAirportIndice.get(a2);
    return matrice[source][destination] != null;
  }
	
	

}
