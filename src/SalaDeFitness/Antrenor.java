package SalaDeFitness;

public class Antrenor extends  Persoana {
    int nrAbonati;

    public Antrenor(String name, int age, int nrAbonati) {
        super(name, age);
        this.nrAbonati = nrAbonati;
    }

    @Override
    void afiseazaInformatii() {
        System.out.println("Antrenorul se numeste " + name + ", are varsta " + age + " si " + nrAbonati + " abonati");
    }

}
