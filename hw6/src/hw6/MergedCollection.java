package hw6;
import java.util.Comparator;
import java.util.Collection;
import java.util.AbstractCollection;
import java.util.Iterator;

public class MergedCollection<T> extends AbstractCollection<T>{
    private Collection<T> collection1, collection2;
    private Comparator<T> comparator;

    public MergedCollection(Collection<T> i1, Collection<T> i2, Comparator<T> comparator){
        collection1 = i1;
        collection2 = i2;
        this.comparator = comparator;
    }

    @Override
    public Iterator<T> iterator(){
        return new MergedIterator<>(collection1.iterator(), collection2.iterator(), comparator);
    }

    @Override
    public int size(){
        return collection1.size() + collection2.size();
    }

}
