package app.examples;

import app.AbstractSpecification;

/**
 * Created by sce on 22.02.2017.
 */
public class ElligiblePourUneRenteSpecification extends AbstractSpecification<Requerant> {

    @Override
    public boolean estStaisfaitPar(Requerant candidate) {

        return candidate.dateNaissance().getYear() > 2000
        && candidate.salaireAnnuel().salaireAnnuel() < 3000;

    }
}
