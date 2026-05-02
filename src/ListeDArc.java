import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListeDArc extends Graph{
	
	private ArrayList<Flight> flights;

	public ListeDArc() {
		super();
		flights=new ArrayList<Flight>();
	}

	@Override
	// Complexit?: o(0)
	protected void ajouterSommet(Airport a) {	
		// Aucune structure d'accueil
	}

	@Override
	// Complexit?: o(1)
	protected void ajouterArc(Flight f) {
		this.flights.add(f);
	}

	@Override
	// Complexit?: o(n)
	public Set<Flight> arcsSortants(Airport a) {
		Set<Flight> result = new HashSet<>();
		for(Flight f: this.flights){
			if(f.getSource().equals(a)){
				result.add(f);
			}
		}
		return result;
	}

	@Override
	// Complexit?: o(n)
	public boolean sontAdjacents(Airport a1, Airport a2) {
		for(Flight f : this.flights){
			if(f.getSource().equals(a1) && f.getDestination().equals(a2)){
				return true;
			}
		}
		return false;
	}

}
