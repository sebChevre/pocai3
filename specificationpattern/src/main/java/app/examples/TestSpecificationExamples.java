package app.examples;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by sce on 22.02.2017.
 */
public class TestSpecificationExamples {

    @Test
    public void testDroitALaRenteRegle(){

        //2 valeurs ok
        Requerant r = new Requerant(LocalDateTime.parse("2012-12-03T00:00"),new SalaireAnnuel(2500));
        assertTrue(new ElligiblePourUneRenteSpecification().estStaisfaitPar(r));

        //salaire trop haute
        r = new Requerant(LocalDateTime.parse("2012-12-03T00:00"),new SalaireAnnuel(3500));
        assertFalse(new ElligiblePourUneRenteSpecification().estStaisfaitPar(r));

        //trop vieux
        r = new Requerant(LocalDateTime.parse("1939-12-03T00:00"),new SalaireAnnuel(2500));
        assertFalse(new ElligiblePourUneRenteSpecification().estStaisfaitPar(r));

        //les deux
        r = new Requerant(LocalDateTime.parse("1939-12-03T00:00"),new SalaireAnnuel(3500));
        assertFalse(new ElligiblePourUneRenteSpecification().estStaisfaitPar(r));
    }


    @Test
    public void testEnfantBasAgeSpecification(){

        Requerant r = new Requerant(LocalDateTime.parse("2012-12-03T00:00"),new SalaireAnnuel(2500));
        List<Enfant> enfants = new ArrayList<>();
        enfants.add(new Enfant(4));
        enfants.add(new Enfant(14));
        r.addEnfant(enfants.get(0));
        r.addEnfant(enfants.get(1));
        assertTrue(new EnfantsBasAgeSpecification().estStaisfaitPar(r));

        enfants.clear();

        r = new Requerant(LocalDateTime.parse("2012-12-03T00:00"),new SalaireAnnuel(2500));
        r.addEnfant(new Enfant(19));
        r.addEnfant(new Enfant(21));
        assertFalse(new EnfantsBasAgeSpecification().estStaisfaitPar(r));



    }


    @Test
    public void testCompositeSpecification(){
        Requerant r = new Requerant(LocalDateTime.parse("2012-12-03T00:00"),new SalaireAnnuel(2500));
        new DroitAUneRenteSpecification().estStaisfaitPar(r);
    }




}
