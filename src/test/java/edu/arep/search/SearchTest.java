package edu.arep.search;

import edu.arep.search.Search;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void testLinearSearchSuccess() {
        String listString = "1,2,3";
        String value = "2";
        String result = Search.linearSearch(listString, value);
        assertTrue(result.contains("\"output\": \"1\""));
    }

    @Test
    void testLinearSearchFailure() {
        String listString = "1,2,3";
        String value = "4";
        String result = Search.linearSearch(listString, value);
        assertTrue(result.contains("\"output\": \"-1\""));
    }

    @Test
    void testBinarySearchSuccess() {
        String listString = "1,2,3";
        String value = "2";
        String result = Search.binarySearch(listString, value);
        assertTrue(result.contains("\"output\": \"1\""));
    }

    @Test
    void testBinarySearchFailure() {
        String listString = "1,2,3";
        String value = "4";
        String result = Search.binarySearch(listString, value);
        assertTrue(result.contains("\"output\": \"-1\""));
    }

    @Test
    void testLinearSearchEmptyList() {
        String listString = "";
        String value = "1";
        String result = Search.linearSearch(listString, value);
        assertTrue(result.contains("\"output\": \"-1\""));
    }

    @Test
    void testBinarySearchEmptyList() {
        String listString = "";
        String value = "1";
        String result = Search.binarySearch(listString, value);
        assertTrue(result.contains("\"output\": \"-1\""));
    }

    @Test
    void testLinearSearchSingleElementList() {
        String listString = "1";
        String value = "1";
        String result = Search.linearSearch(listString, value);
        assertTrue(result.contains("\"output\": \"0\""));
    }

    @Test
    void testBinarySearchSingleElementList() {
        String listString = "1";
        String value = "1";
        String result = Search.binarySearch(listString, value);
        assertTrue(result.contains("\"output\": \"0\""));
    }

    @Test
    void testLinearSearchMultipleElementsList() {
        String listString = "1,2,3";
        String value = "3";
        String result = Search.linearSearch(listString, value);
        assertTrue(result.contains("\"output\": \"2\""));
    }

    @Test
    void testBinarySearchMultipleElementsList() {
        String listString = "1,2,3";
        String value = "3";
        String result = Search.binarySearch(listString, value);
        assertTrue(result.contains("\"output\": \"2\""));
    }
}

