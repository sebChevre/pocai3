package app;

/**
 * Created by sce on 22.02.2017.
 */
public class AndSpecification<T> extends AbstractSpecification<T> {

    private final Specification<T> specification1;
    private final Specification<T> specification2;


    public AndSpecification(Specification<T> specification1, Specification specification2) {
       this.specification1 = specification1;
        this.specification2 = specification2;

    }


    @Override
    public boolean estStaisfaitPar(T candidate) {
        return specification1.estStaisfaitPar(candidate) && specification2.estStaisfaitPar(candidate);
    }
}
