package hw6;
import java.util.function.Predicate;

public class CountReducer<T> implements Reducer<T,Integer>{
    private Predicate<T> predicate;
    private int count;

    public CountReducer(Predicate<T> predicate){
        this.predicate = predicate;
        count = 0;
    }

    @Override
    public void accept(T t){
        if (predicate.test(t)){
            count++;
        }
    }

    @Override
    public Integer result(){
        return count;
    }
}