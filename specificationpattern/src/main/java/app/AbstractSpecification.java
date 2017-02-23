package app;

/**
 * Created by sce on 22.02.2017.
 */
public abstract class AbstractSpecification<T> implements Specification<T> {

    public abstract boolean estStaisfaitPar(T candidate);

    @Override
    public Specification or(Specification specification) {
        return new OrSpecification<T>(this, specification);
    }

    @Override
    public Specification and(Specification specification) {
        return new AndSpecification<T>(this, specification);
    }

    @Override
    public Specification not() {
        return new NotSpecification<T>(this);
    }
}
