package edu.arep.loadBalancer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * The Invoker class is designed to perform HTTP GET requests to a list of predefined URLs,
 * which are intended to be endpoints for mathematical services. The class uses a round-robin
 * strategy to distribute requests across the available URLs, ensuring that each URL is used
 * in turn before cycling back to the first.
 */
public class Invoker {
    private static final String USER_AGENT = "Mozilla/5.0";

    /**
     * A list of URLs representing the endpoints for the mathematical services.
     */
    static final List<String> MATH_SERVICE_URLS = Arrays.asList(//"http://localhost:4567", "http://localhost:4567"
                                                                "http://ec2-54-167-24-152.compute-1.amazonaws.com:4567",
                                                                "http://ec2-3-91-71-35.compute-1.amazonaws.com:4567"
                                                    );
    static int currentMathService = 0;



    /**
     * Performs an HTTP GET request to one of the mathematical service URLs based on the round-robin strategy.
     *
     * @param operation A string representing the operation to be performed by the mathematical service.
     * @param list      A string representing the list of numbers on which the operation is to be performed.
     * @param number    A string representing the number to be used in the operation.
     * @return A string containing the response from the mathematical service.
     * @throws IOException If an error occurs while opening a connection to the URL or reading the response.
     */public static String invoke(String operation, String list, String number) throws IOException {
        URL obj = getMathServiceUrl(operation, list, number);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        StringBuffer response = new StringBuffer();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return response.toString();
    }

    /**
     * Returns the URL for the current request based on the round-robin strategy.
     *
     * @param operation A string representing the operation to be performed by the mathematical service.
     * @param list      A string representing the list of numbers on which the operation is to be performed.
     * @param number    A string representing the number to be used in the operation.
     * @return A URL object representing the URL for the current request.
     * @throws MalformedURLException If the constructed URL is not valid.
     */
    public static URL getMathServiceUrl(String operation, String list, String number) throws MalformedURLException {
        String getUrl = MATH_SERVICE_URLS.get(currentMathService);
        currentMathService = (currentMathService + 1) % MATH_SERVICE_URLS.size(); //round-robin
        return new URL(getUrl + "/" + operation + "?list=" + list + "&value=" + number);
    }


}
