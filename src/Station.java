import java.util.ArrayList;
import java.util.List;
public class Station {
    private final String nom;
    private int capacite;
    private final List<Velo> velos = new ArrayList<>();

    public Station(String nom) { this.nom = nom; this.capacite = 1; }

    public boolean fixerCapacite(int c) {
        if (c <= 0 || c < velos.size()) return false;
        capacite = c;
        return true;
    }

    public boolean deposerVelo(Velo v) {                  // rendre un vélo
        if (v == null || velos.size() >= capacite || velos.contains(v)) return false;
        velos.add(v);
        return true;
    }

    public boolean retirerVelo(Velo v) {                  // la station décide si le vélo peut sortir
        if (v == null || v.isEnReparation() || !velos.contains(v)) return false;
        velos.remove(v);
        return true;
    }

    public String getNom()       { return nom; }
    public int getCapacite()     { return capacite; }
    public int getNbVelos()      { return velos.size(); }
}
