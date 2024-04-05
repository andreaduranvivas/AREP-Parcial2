package edu.arep.search;

import edu.arep.search.Search;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void testLinearSearchSuccess() {
        String listString = "1,2,3";
        String value = "2";
        String result = Search.linearSearch(listString, value);
        JSONObject jsonResult = new JSONObject(result);
        assertEquals(1, jsonResult.getInt("output"));
    }

    @Test
    void testLinearSearchFailure() {
        String listString = "1,2,3";
        String value = "4";
        String result = Search.linearSearch(listString, value);
        JSONObject jsonResult = new JSONObject(result);
        assertEquals(-1, jsonResult.getInt("output"));
    }

    @Test
    void testBinarySearchSuccess() {
        String listString = "1,2,3";
        String value = "2";
        String result = Search.binarySearch(listString, value);
        JSONObject jsonResult = new JSONObject(result);
        assertEquals(1, jsonResult.getInt("output"));
    }

    @Test
    void testBinarySearchFailure() {
        String listString = "1,2,3";
        String value = "4";
        String result = Search.binarySearch(listString, value);
        JSONObject jsonResult = new JSONObject(result);
        assertEquals(-1, jsonResult.getInt("output"));
    }

    @Test
    void testLinearSearchEmptyList() {
        String listString = "";
        String value = "1";
        String result = Search.linearSearch(listString, value);
        JSONObject jsonResult = new JSONObject(result);
        assertEquals(-1, jsonResult.getInt("output"));
    }

    @Test
    void testBinarySearchEmptyList() {
        String listString = "";
        String value = "1";
        String result = Search.binarySearch(listString, value);
        JSONObject jsonResult = new JSONObject(result);
        assertEquals(-1, jsonResult.getInt("output"));
    }

    @Test
    void testLinearSearchSingleElementList() {
        String listString = "1";
        String value = "1";
        String result = Search.linearSearch(listString, value);
        JSONObject jsonResult = new JSONObject(result);
        assertEquals(0, jsonResult.getInt("output"));
    }

    @Test
    void testBinarySearchSingleElementList() {
        String listString = "1";
        String value = "1";
        String result = Search.binarySearch(listString, value);
        JSONObject jsonResult = new JSONObject(result);
        assertEquals(0, jsonResult.getInt("output"));
    }

    @Test
    void testLinearSearchMultipleElementsList() {
        String listString = "1,2,3";
        String value = "3";
        String result = Search.linearSearch(listString, value);
        JSONObject jsonResult = new JSONObject(result);
        assertEquals(2, jsonResult.getInt("output"));
    }

    @Test
    void testBinarySearchMultipleElementsList() {
        String listString = "1,2,3";
        String value = "3";
        String result = Search.binarySearch(listString, value);
        JSONObject jsonResult = new JSONObject(result);
        assertEquals(2, jsonResult.getInt("output"));
    }
}

