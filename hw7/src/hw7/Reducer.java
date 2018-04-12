package hw7;

import java.util.function.Consumer;

public interface Reducer<T,R> extends Consumer<T> {
   R result();
}
