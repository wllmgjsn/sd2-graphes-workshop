public class Arc {
    private Noeud from;
    private Noeud to;

    public Arc(Noeud from, Noeud to) {
        this.from = from;
        this.to = to;
    }

    public Noeud getFrom() {
        return from;
    }

    public void setFrom(Noeud from) {
        this.from = from;
    }

    public Noeud getTo() {
        return to;
    }

    public void setTo(Noeud to) {
        this.to = to;
    }
}
