import java.util.ArrayList;
import java.util.List;

public class Velo {
    private final int numero;
    private double km;
    private boolean enReparation;

    public Velo(int numero) { this.numero = numero; km = 0; enReparation = false; }

    public boolean ajouterKm(double d) {
        if (d < 0) return false;
        km += d;
        return true;
    }
    public void mettreEnReparation() { enReparation = true; }
    public void remettreEnService()  { enReparation = false; }

    public int getNumero()        { return numero; }
    public double getKm()         { return km; }
    public boolean isEnReparation() { return enReparation; }
}
