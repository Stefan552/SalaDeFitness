package SalaDeFitness;

public class Abonat extends Persoana {
    int progress;

    public Abonat(String name,int age,int progress) {
        super(name,age);
        this.progress = progress;
    }
@Override
    void afiseazaInformatii() {
    System.out.println("Abonatul se numeste " + name + ", are varsta " + age + " si " + progress + " progres");
}

}
