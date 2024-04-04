package edu.arep.search;

import static edu.arep.search.Search.binarySearch;
import static edu.arep.search.Search.linearSearch;
import static spark.Spark.*;

/**
 * Servidor de Funciones de Math Service
 *
 */
public class MathService
{
    public static void main( String[] args )
    {
        port(getPort());
        staticFiles.location("/public");

        get("hello", (req,res) -> "Hello Docker!");

        get("/linearsearch", (req, res) -> linearSearch(req.queryParams("list"), req.queryParams("value")));
        get("/binarysearch", (req, res) -> binarySearch(req.queryParams("list"), req.queryParams("value")));
    }



    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
