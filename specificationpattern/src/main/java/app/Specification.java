package app;

/**
 * Created by sce on 22.02.2017.
 */
public interface Specification<T> {

    public boolean estStaisfaitPar(T candidate);

    public Specification or(Specification specification);
    public Specification and(Specification specification);
    public Specification not();
}
