package app.examples;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sce on 22.02.2017.
 */
public class Requerant {

    private LocalDateTime dateNaissance;
    private SalaireAnnuel salaireAnnuel;
    private List<Enfant> enfants = new ArrayList<>();

    public Requerant(LocalDateTime dateNaissance, SalaireAnnuel salaireAnnuel){
        this.dateNaissance = dateNaissance;
        this.salaireAnnuel = salaireAnnuel;
    }

    public LocalDateTime dateNaissance(){
        return dateNaissance;
    }

    public SalaireAnnuel salaireAnnuel(){
        return salaireAnnuel;
    }

    public void addEnfant(Enfant e){
        enfants.add(e);
    }

    public List<Enfant> enfants(){
        return enfants;
    }
}
