public class TestVelos {
    public static void main(String[] args) {
        Station s1 = new Station("Centre");  s1.fixerCapacite(2);
        Station s2 = new Station("Gare");    s2.fixerCapacite(1);
        Velo v1 = new Velo(1), v2 = new Velo(2), v3 = new Velo(3);
        s1.deposerVelo(v1); s1.deposerVelo(v2);
        s2.deposerVelo(v3);
        v2.mettreEnReparation();

        Abonne a = new Abonne("Salma");
        a.crediter(20);

        System.out.println("Louer vélo en réparation : " + a.louer(v2, s1));  // false
        System.out.println("Louer v1 : " + a.louer(v1, s1));                  // true
        System.out.println("Second vélo en cours : " + a.louer(v3, s2));      // false
        System.out.println("Rendre en station pleine : " + a.rendre(s2, 3));  // false (s2 contient v3, capacité 1)

        Abonne b = new Abonne("Youssef");   // crédit 0
        System.out.println("Crédit insuffisant : " + b.louer(v3, s2));        // false
    }
}
