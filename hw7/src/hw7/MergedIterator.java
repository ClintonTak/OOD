package hw7;

import java.util.*;

public class MergedIterator<T> implements Iterator<T> {
    private LookAheadIterator<T> i1, i2;
    private Comparator<T> comp;
    private T cache;

    public MergedIterator(Iterator<T> iter1, Iterator<T> iter2, Comparator<T> comp) {
        i1 = new LookAheadIterator<>(iter1);
        i2 = new LookAheadIterator<>(iter2);
        this.comp = comp;
        cache = (comp.compare(i1.peek(), i2.peek()) < 0) ? i1.peek() : i2.peek();
    }

    public boolean hasNext() {
        return i1.hasNext() || i2.hasNext();
    }

    public T next() {
        T result;
        if (!i1.hasNext()) {
            result = i2.next();
        }
        else if (!i2.hasNext()) {
            result = i1.next();
        }
        else if (comp.compare(cache, i1.peek()) <= 0 && comp.compare(cache, i2.peek()) <= 0) {
            if (comp.compare(i1.peek(), i2.peek()) < 0) {
                result = i1.next();
                cache = result;
            }
            else {
                result = i2.next();
                cache = result;
            }
        } else if (comp.compare(cache, i1.peek()) <= 0) {
            result = i1.next();
            cache = result;
        }
        else if (comp.compare(cache, i2.peek()) <= 0) {
            result = i2.next();
            cache = result;
        }
        else {
            if (comp.compare(i1.peek(), i2.peek()) < 0) {
                result = i1.next();
                cache = result;
            }
            else {
                result = i2.next();
                cache = result;
            }
        }
        return result;
    }
}