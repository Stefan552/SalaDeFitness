package SalaDeFitness;

public class SalaFitness {
    Persoana[] persoane = new Persoana[3];
    int nrPersoane;
    boolean esteDeschisa;

    void actiune(Actiune actiune) throws PersoanaNuExista {
        if (!esteDeschisa && actiune != Actiune.DESCHIDE) {
            throw new SalaInchisa();
        }

        switch (actiune) {
            case DESCHIDE: {
                deschide();
                break;
            }
            case ADAUGA_ANTRENOR: {
                adaugaAntrenor(ClasaUtilitara.genereazaNume(), ClasaUtilitara.genereazaVarsta(), ClasaUtilitara.genereazaNrAbonati());
                break;
            }
            case ADAUGA_ABONAT: {
                adaugaAbonat(ClasaUtilitara.genereazaNume(), ClasaUtilitara.genereazaVarsta(), ClasaUtilitara.genereazaProgres());
                break;
            }
            case AFISEAZA_PERSOANE: {
                afiseazaPersoane();
                break;
            }
            case AFISEAZA_ANTRENORI: {
                afiseazaAntrenori();
                break;
            }
            case AFISEAZA_ABONAT_MAX: {
                afiseazaAbonatCuProgresMax();
                break;
            }
            case ELIMINA_PERSOANA: {
                eliminaPersoana(ClasaUtilitara.genereazaId());
                break;
            }
            case INCHIDE: {
                inchide();
                break;
            }
            default: {
                System.out.println("Actiunea nu este valida");
            }
        }
    }

    private void deschide() {
        esteDeschisa = true;
        System.out.println("Sala s-a deschis");
    }

    private void adaugaAntrenor(String name, int age, int nrAbonati) {
        Antrenor antrenor = new Antrenor(name, age, nrAbonati);

        if (nrPersoane < 3) {
            for (int i = 0; i < persoane.length; i++) {
                if (persoane[i] == null ) {
                    persoane[i] = antrenor;
                    break;
                }
            }
            nrPersoane++;
            System.out.println("A intrat in sala antrenorul " + name );
        } else {
            System.out.println("Din pacate sala este plina si " +name + " nu mai poate intra!");
        }
    }

    private void adaugaAbonat(String nume, int varsta, int progres) {
        Abonat abonat = new Abonat(nume, varsta, progres);

        if (nrPersoane < 3) {
            for (int i = 0; i < persoane.length; i++) {
                if (persoane[i] == null ) {
                    persoane[i] = abonat;
                    break;
                }
            }
            nrPersoane++;
            System.out.println("A intrat in sala abonatul " + nume);
        } else {
            System.out.println("Din pacate sala este plina si " + nume + " nu mai poate intra!");
        }
    }

    private void afiseazaPersoane() {
        if (nrPersoane > 0) {
            System.out.println("Persoanele din sala sunt:");
            for (Persoana persoana : persoane) {
                if (persoana != null) {
                    persoana.afiseazaInformatii();
                }
            }
        } else {
            System.out.println("Sala este libera!");
        }
    }

    private void afiseazaAntrenori() {
        boolean existaAntrenori = false;

        for (Persoana persoana : persoane) {
            if (persoana instanceof Antrenor) {
                existaAntrenori = true;
                persoana.afiseazaInformatii();
            }
        }

        if (!existaAntrenori) {
            System.out.println("Nu există niciun antrenor în sală!");
        }
    }

    private void afiseazaAbonatCuProgresMax() {
        int max = -1;
        Persoana persoanaCuProgresMax = null;
        for (Persoana persoana : persoane) {
            if (persoana instanceof Abonat) {
                if (max < ((Abonat) persoana).progress) {
                    max = ((Abonat) persoana).progress;
                    persoanaCuProgresMax = persoana;
                }
            }
        }

        if (max == -1) {
            System.out.println("Nu există niciun abonat în sală!");
        } else {
            persoanaCuProgresMax.afiseazaInformatii();
        }
    }

    private void eliminaPersoana(int id) throws PersoanaNuExista {
        boolean persoanaGasita = false;
        for (int i = 0; i < persoane.length; i++) {
            if (persoane[i] != null && persoane[i].id == id) {
                System.out.println("Persoana " + persoane[i].name + " iese din sala");
                persoane[i] = null;
                nrPersoane--;
                persoanaGasita = true;
            }
        }

        if (!persoanaGasita) {
            throw new PersoanaNuExista();
        }
    }

    private void inchide() {
        esteDeschisa = false;
        System.out.println("Sala s-a inchis");
    }
}
