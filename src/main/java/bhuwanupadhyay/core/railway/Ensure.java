package bhuwanupadhyay.core.railway;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@AllArgsConstructor
@Getter
public class Ensure<TSuccess, TFailure> {
    private Predicate<TSuccess> predicate;
    private TFailure failure;


    public static class Builder<K, V> {
        private List<Ensure<K, V>> ensures = new ArrayList<>();

        public Builder<K, V> put(Ensure<K, V> ensure) {
            this.ensures.add(ensure);
            return this;
        }

        public List<Ensure<K, V>> build() {
            return ensures;
        }
    }
}