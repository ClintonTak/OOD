package hw6;

import java.util.*;
import java.util.function.Predicate;

public class HW6Test {
   public static void main(String[] args) {
      Comparator<String> comp = (s1, s2) -> s1.compareTo(s2);
      Collection<String> c1 = new TreeSet<>(comp);
      c1.addAll(Arrays.asList("a", "c", "d", "e", "g", "h", "j"));
      Collection<String> c2 = new TreeSet<>(comp);
      c2.addAll(Arrays.asList("b", "f", "m", "n", "p"));
      Collection<String> c3 = new MergedCollection<>(c1, c2, comp);
      c3.forEach(s -> System.out.print(s + " "));
      System.out.println();
      Comparator<Integer> comparitor = (i1, i2) -> Integer.compare(i2, i1);
      Collection<Integer> collection1  = new TreeSet<>(comparitor);
      Collection<Integer> collection2 = new TreeSet<>(comparitor);
      Random rand = new Random();
      for (int i = 0; i < 10; i++) {
         collection1.add(rand.nextInt(101));
         collection2.add(rand.nextInt(101));
      }
      Collection<Integer> collection3 = new MergedCollection<>(collection1, collection2, comparitor);
      for (Integer i : collection3)
         System.out.print(i + " ");
      System.out.println();
       collection3.forEach(i -> System.out.print(i + " "));
      System.out.println();
      System.out.println("There are " + howMany(collection3, (i -> i % 2 == 0)) + " even values.");
      CountReducer<Integer> countReducer = new CountReducer<>((i -> i % 2 == 0));
      collection3.forEach(i -> countReducer.accept(i));
      System.out.println("There are " + countReducer.result() + " even values.");
   }

   public static <T> int howMany(Iterable<T> c, Predicate<T> predicate) {
      int count = 0;
      for (T t : c)
         if (predicate.test(t)){
          count++;
         }
      return count;
   }
}
