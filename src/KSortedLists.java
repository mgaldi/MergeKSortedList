import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KSortedLists {

    public static void main(String[] args) {
        List<List<Double>> outerList = List.of(
            Arrays.asList(1.1, 4.0, 4.7, 5.0, 5.3),
            Arrays.asList(1.3, 2.0, 5.3),
            Arrays.asList(2.2, 6.6, 5.3, 9.0),
            Arrays.asList(3.2, 3.3, 3.3, 6.5, 12.8),
            Arrays.asList(2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9)
        );
        outerList.forEach(Collections::sort);   // sorts each inner list in case their content is unsorted
        System.out.println(mergeLists(outerList));
    }

    public static <T extends Comparable<T>> List<T> mergeLists(List<List<T>> list) {
        if (list == null || list.isEmpty())
            return null;
        return splitMerge(list, 0, list.size());
    }

    private static <T extends Comparable<T>> List<T> splitMerge(List<List<T>> list, int index, int size) {
        if (size == 1)
            return list.get(index);
        int leftSize, rightSize;
        leftSize = rightSize = size / 2;
        if (size % 2 == 1)
            rightSize += 1;
        int leftIndex = index, rightIndex = index + leftSize;
        List<T> left = splitMerge(list, leftIndex, leftSize), right = splitMerge(list, rightIndex, rightSize);
        return mergeSortedLists(left, right);
    }

    private static <T extends Comparable<T>> List<T> mergeSortedLists(List<T> a, List<T> b) {
        List<T> merged = new LinkedList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size())    // stops either when i reaches the end of a or when j reaches the end of b
            // this loop compares couples a[i] and b[j],
            merged.add(a.get(i).compareTo(b.get(j)) < 0     // then proceeds to add the lesser one to the sorted list
                    ? a.get(i++)                            // and finally increases the counter i or j related to the
                    : b.get(j++));                          // list containing the lesser currently inspected element
        // the following while loops are mutually exclusive, meaning exactly one of them will execute
        while (i < a.size())    // executed when i reaches the end of a before j reaches the end of b
            merged.add(a.get(i++));
        while (j < b.size())    // execude when j reaches the end of b before i reaches the end of a
            merged.add(b.get(j++));
        return merged;
    }

}
