package bhuwanupadhyay.core.railway;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ensure<TSuccess, TFailure> {
    private Predicate<TSuccess> predicate;
    private TFailure failure;

    public Ensure(Predicate<TSuccess> predicate, TFailure failure) {
        this.predicate = predicate;
        this.failure = failure;
    }

    public Predicate<TSuccess> getPredicate() {
        return predicate;
    }

    public TFailure getFailure() {
        return failure;
    }

    public  static <TSuccess, TFailure> List<Ensure<TSuccess, TFailure>> of(Ensure<TSuccess, TFailure> ensures) {
        List<Ensure<TSuccess, TFailure>> list = new ArrayList<>();
        return list;
    }
}