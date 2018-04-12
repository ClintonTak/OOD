package hw7;

import java.util.*;
import java.io.*;
import java.util.function.Predicate;

public class HW7Test {
public static void main(String[] args) throws IOException {
        Collection<String> dict = readFromFile("src/text/dictionary.txt");
        Collection<String> reversedict = reverse(dict);

        // predicate p1 denotes words longer than 20 characters
        Predicate<String> p1 = s -> s.length() > 20;
        printWords(reversedict, p1);
        System.out.println();

        // predicate p2 denotes words beginning with "chori".
        Predicate<String> p2 = s -> s.startsWith("chori");
        printWords(reversedict, p2);
    }

    public static Collection<String> readFromFile (String filename) throws IOException {
        Collection<String> dictionaryCollection = new ArrayList<>();
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            dictionaryCollection.add(sc.nextLine());
        }
        return dictionaryCollection;
    }

    public static Collection<String> reverse( Collection<String> words){
        Collection<String> reversedList = new SortedCollection<>(words, Comparator.reverseOrder());
        return reversedList;
    }

    public static void printWords(Collection<String> words, Predicate<String> predicate){
        words.stream()
            .filter(predicate)
            .forEach(s -> System.out.println(s));
    }
}
