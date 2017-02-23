package app.examples;

import app.AbstractSpecification;

/**
 * Created by sce on 22.02.2017.
 */
public class DroitAUneRenteSpecification extends AbstractSpecification<Requerant>{

    ElligiblePourUneRenteSpecification elSpecification = new ElligiblePourUneRenteSpecification();
    EnfantsBasAgeSpecification ebSpecification = new EnfantsBasAgeSpecification();

    @Override
    public boolean estStaisfaitPar(Requerant candidate) {
        return elSpecification.and(ebSpecification).estStaisfaitPar(candidate);
    }
}
