package edu.arep.loadBalancer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Invoker {
    private static final String USER_AGENT = "Mozilla/5.0";

    private static final List<String> MATH_SERVICE_URLS = Arrays.asList("http://ec2-54-167-24-152.compute-1.amazonaws.com:38000",
                                                                        "http://ec2-3-91-71-35.compute-1.amazonaws.com:38000");
    private static int currentLogService = 0;


    public static String invoke(String operation, String list, String number) throws IOException {
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

    private static URL getMathServiceUrl(String operation, String list, String number) throws MalformedURLException {
        String getUrl = MATH_SERVICE_URLS.get(currentLogService);
        currentLogService = (currentLogService + 1) % MATH_SERVICE_URLS.size(); //round robin
        return new URL(getUrl + "/" + operation + "?list=" + list + "&value=" + number);
    }


}
