package hw6;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

public class MergedIterator<T> implements Iterator<T> {
    private Iterator<T> i1, i2;
    private T item1, item2;
    private Comparator<T> comp;

    public MergedIterator(Iterator<T> i1, Iterator<T> i2, Comparator<T> comp){
        this.i1 = i1;
        this.i2 = i2;
        this.comp = comp;

        if (i1.hasNext()){
            item1 = i1.next();
        }
        if (i2.hasNext()){
            item2 = i2.next();
        }
    }

    public T next() {
        T element;
        if (!hasNext()) throw new NoSuchElementException();
        else if (item2 == null) {
            element = item1;
            if (i1.hasNext()){
                item1 = i1.next();
            }

            else{
                item1 = null;
            }
        }
        else if (item1 == null) {
            element = item2;
            if (i2.hasNext()){
                item2 = i2.next();
            }

            else {
                item2 = null;
            }
        }
        else {
            if (comp.compare(item1, item2) <= 0) {
                element = item1;
                if (i1.hasNext()) {
                    item1 = i1.next();
                }
                else {
                    item1 = null;
                }
            }
            else {
                element = item2;
                if (i2.hasNext()) {
                    item2 = i2.next();
                }
                else {
                    item2 = null;
                }
            }
        }

        return element;
    }

    public boolean hasNext(){
        return item1 != null || item2 != null;
    }
}
