package app.examples;

import app.AbstractSpecification;

import java.util.List;

/**
 * Created by sce on 22.02.2017.
 */
public class EnfantsBasAgeSpecification extends AbstractSpecification<Requerant> {

    @Override
    public boolean estStaisfaitPar(Requerant candidate) {

        //au moins 1 enfant en bas age -18

        for(Enfant e : candidate.enfants()){
            if(e.age() < 18){
                return true;
            }
        }
        return false;


    }
}
