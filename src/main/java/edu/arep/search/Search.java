package edu.arep.search;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONObject;

/**
 * The Search class provides static methods for performing linear and binary searches on a list of strings.
 * The list is provided as a comma-separated string, and the search methods return the index of the value
 * if found, or -1 if the value is not found.
 */
public class Search {
    /**
     * Performs a linear search on the given list of strings.
     *
     * @param listString A comma-separated string representing the list of strings to search.
     * @param value      The string value to search for in the list.
     * @return A JSON string containing the operation name, input list, value, and the index of the value if found, or -1 if not found.
     */
    public static String linearSearch(String listString, String value) {
        List<String> list = Stream.of(listString.split(",")).collect(Collectors.toList());
        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                index = i;
                break;
            }
        }

        return createJson("linearSearch", listString, value, index);
    }

    /**
     * Performs a binary search on the given list of strings.
     *
     * @param listString A comma-separated string representing the list of strings to search.
     * @param value      The string value to search for in the list.
     * @return A JSON string containing the operation name, input list, value, and the index of the value if found, or -1 if not found.
     */
    public static String binarySearch(String listString, String value) {
        List<String> list = Stream.of(listString.split(",")).collect(Collectors.toList());
        int index = binarySearchRecursive(list, 0, list.size() - 1, value);

        return createJson("binarySearch", listString, value, index);
    }

    /**
     * Recursive helper method for performing a binary search on a list of strings.
     *
     * @param list The list of strings to search.
     * @param start The starting index of the search range.
     * @param end   The ending index of the search range.
     * @param value The string value to search for in the list.
     * @return The index of the value if found, or -1 if the value is not found.
     */
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

    /**
     * Creates a JSON string containing the operation name, input list, value, and the index of the value if found, or -1 if not found.
     *
     * @param operation The operation name.
     * @param listString A comma-separated string representing the list of strings to search.
     * @param value The string value to search for in the list.
     * @param index The index of the value if found, or -1 if the value is not found.
     * @return A JSON string containing the operation name, input list, value, and the index of the value if found, or -1 if not found.
     */
    public static String createJson(String operation, String listString, String value, int index) {
        JSONObject response = new JSONObject();
        response.put("operation", operation);
        response.put("inputlist", listString);
        response.put("value", value);
        response.put("output", index);

        return response.toString();
    }

}
