package hw7;

import java.util.*;

public class SortedCollection<T> extends AbstractCollection<T> {
    private Collection<T> result;

    public SortedCollection(Collection<T> c, Comparator<T> comp){
        result= sort(c, comp);
    }

    private Collection<T> sort(Collection<T> c, Comparator<T> comp) {
        Collection<T> merged = new ArrayList<>();
        int side = 0;
        List<List<T>> lists = new ArrayList<>(Arrays.asList(new ArrayList<T>(), new ArrayList<T>()));
        List<T> run = new ArrayList<>();
        for (T elem : c) {
            if (!run.isEmpty()) {
                if (comp.compare(elem, run.get(run.size() - 1)) <= 0) {
                    lists.get(side).addAll(run);
                    run = new ArrayList<>();
                    side = (side + 1) % 2;
                }
            }
            run.add(elem);
        }
        lists.get(side).addAll(run);
        if (lists.get(1).isEmpty())
            return lists.get(0);
        else {
            MergedIterator<T> me = new MergedIterator<>(lists.get(0).iterator(), lists.get(1).iterator(), comp);
            while (me.hasNext())
                merged.add(me.next());

            return sort(merged, comp);
        }
    }

    @Override
    public Iterator<T> iterator(){
        return result.iterator();
    }

    @Override
    public int size(){
        return result.size();
    }



}