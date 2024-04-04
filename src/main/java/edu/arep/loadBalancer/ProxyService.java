package edu.arep.loadBalancer;

import static edu.arep.search.Search.binarySearch;
import static edu.arep.search.Search.linearSearch;
import static spark.Spark.*;
import static spark.Spark.get;

public class ProxyService {

    public static void main( String[] args )
    {
        port(getPort());
        staticFiles.location("/public");

        get("/proxy", (req, res) -> {
            String operation = req.queryParams("operation");
            String list = req.queryParams("list");
            String value = req.queryParams("value");

            return Invoker.invoke(operation, list, value);
        });


    }



    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080;
    }
}
