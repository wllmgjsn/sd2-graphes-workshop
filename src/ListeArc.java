import java.util.ArrayList;

public class ListeArc {
    ArrayList<Arc> arcs;

    public ListeArc(ArrayList<Arc> arcs) {
        this.arcs = arcs;
    }

    public boolean ajouterArc(Arc arc) {
        return this.arcs.add(arc);
    }


}
