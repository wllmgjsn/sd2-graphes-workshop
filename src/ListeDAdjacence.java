import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListeDAdjacence extends Graph{
	
	private Map<Airport,Set<Flight>> outputFlights;

	public ListeDAdjacence(){
		super();
		outputFlights=new HashMap<Airport,Set<Flight>>();

	}

	@Override
	// Complexité: o(1)
	protected void ajouterSommet(Airport a) {	
		this.outputFlights.put(a, new HashSet<>());
	}

	@Override
	// Complexité: o(1)
	protected void ajouterArc(Flight f) {
		Airport source = f.getSource();
		outputFlights.get(source).add(f);
	}

	@Override
	// Complexité: ?
	public Set<Flight> arcsSortants(Airport a) {
		return outputFlights.get(a);
	}

	@Override
	// Complexité: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		Set<Airport> destinations = outputFlights.get(a1).stream().map(Flight::getDestination).collect(
				Collectors.toSet());
		return destinations.contains(a2);
	}

}
