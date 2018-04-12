package hw7;

import java.util.Iterator;

public class LookAheadIterator<T> implements Iterator<T> {
    private Iterator<T> iterator;
    private T next;

    public LookAheadIterator(Iterator<T> iterator){
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext(){
        if (this.next!= null){
            return true;
        }
        else{
            return iterator.hasNext();
        }
    }

    @Override
    public T next(){
        if (this.next != null){
            T result = next;
            next = null;
            return result;
        }
        else{
            return iterator.next();
        }
    }

    public T peek(){
        if (next == null){
            next = iterator.next();
        }
        return next;
    }
}