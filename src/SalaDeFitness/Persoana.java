package SalaDeFitness;

public abstract class Persoana {
    String name;
    int age;
    int id;
   static int nrPersoane=0;

    public Persoana(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nrPersoane++;
    }

    void afiseazaInformatii() {
        System.out.println("Persoana se numeste " + name + " si are varsta " + age);
    }

}
