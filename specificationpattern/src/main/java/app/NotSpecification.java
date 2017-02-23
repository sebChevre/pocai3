package app;

/**
 * Created by sce on 22.02.2017.
 */
public class NotSpecification<T> extends AbstractSpecification<T> {

    private final Specification<T> specification1;

    public NotSpecification(AbstractSpecification<T> sepcification) {
        this.specification1 = sepcification;
    }

    @Override
    public boolean estStaisfaitPar(T candidate) {
        return !specification1.estStaisfaitPar(candidate);
    }
}
