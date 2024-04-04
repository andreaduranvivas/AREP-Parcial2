package edu.arep.search;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Search {
    public static String linearSearch(String listString, String value) {
        List<String> list = Stream.of(listString.split(",")).collect(Collectors.toList());
        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                index = i;
                break;
            }
        }

        return "{ \"operation\": \"linearSearch\", \"inputlist\": \"" + listString + "\", \"value\": \"" + value + "\", \"output\": \"" + index + "\" }";
    }

    public static String binarySearch(String listString, String value) {
        List<String> list = Stream.of(listString.split(",")).collect(Collectors.toList());
        int index = binarySearchRecursive(list, 0, list.size() - 1, value);

        return "{ \"operation\": \"binarySearch\", \"inputlist\": \"" + listString + "\", \"value\": \"" + value + "\", \"output\": \"" + index + "\" }";
    }

    private static int binarySearchRecursive(List<String> list, int start, int end, String value) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (list.get(mid).equals(value)) {
            return mid;
        } else if (list.get(mid).compareTo(value) < 0) {
            return binarySearchRecursive(list, mid + 1, end, value);
        } else {
            return binarySearchRecursive(list, start, mid - 1, value);
        }
    }

}
