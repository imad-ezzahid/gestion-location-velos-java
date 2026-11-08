import java.util.ArrayList;
import java.util.List;
public class Abonne {
    private static final double COUT = 5;
    private final String nom;
    private double credit;
    private Velo veloLoue;      // null si aucune location en cours

    public Abonne(String nom) { this.nom = nom; credit = 0; veloLoue = null; }

    public boolean crediter(double montant) {
        if (montant <= 0) return false;
        credit += montant;
        return true;
    }

    public boolean louer(Velo v, Station depart) {
        if (v == null || depart == null) return false;
        if (veloLoue != null || credit < COUT) return false;
        if (!depart.retirerVelo(v)) return false;       // refus de la station (réparation, absent)
        veloLoue = v;
        return true;
    }

    public boolean rendre(Station arrivee, double kmParcourus) {
        if (veloLoue == null || arrivee == null || kmParcourus < 0) return false;
        if (!arrivee.deposerVelo(veloLoue)) return false;   // station pleine : rien n'est modifié
        veloLoue.ajouterKm(kmParcourus);
        credit -= COUT;
        veloLoue = null;
        return true;
    }

    public String getNom()      { return nom; }
    public double getCredit()   { return credit; }
    public boolean aUneLocation() { return veloLoue != null; }
}
