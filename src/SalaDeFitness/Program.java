package SalaDeFitness;

public class Program {
    public static void main(String[] args) {
        Actiune[] actiuni = {Actiune.DESCHIDE, Actiune.AFISEAZA_PERSOANE, Actiune.ADAUGA_ABONAT, Actiune.ADAUGA_ANTRENOR, Actiune.ADAUGA_ABONAT,
                Actiune.ADAUGA_ANTRENOR, Actiune.AFISEAZA_PERSOANE, Actiune.AFISEAZA_ANTRENORI, Actiune.AFISEAZA_ABONAT_MAX, Actiune.ELIMINA_PERSOANA,
                Actiune.AFISEAZA_PERSOANE, Actiune.ADAUGA_ANTRENOR, Actiune.AFISEAZA_PERSOANE, Actiune.INCHIDE};

        SalaFitness salaFitness = new SalaFitness();

        for(Actiune actiune : actiuni) {
            try {
                salaFitness.actiune(actiune);
            } catch (PersoanaNuExista e) {
                e.printStackTrace();
            }
        }
    }
}
