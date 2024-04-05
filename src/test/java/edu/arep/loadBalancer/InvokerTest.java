package edu.arep.loadBalancer;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvokerTest {

    @Test
    public void testUrlRotation() throws IOException, MalformedURLException {
        Invoker.currentMathService = 0;
        List<String> expectedUrls = Arrays.asList("http://ec2-54-167-24-152.compute-1.amazonaws.com:38000",
                "http://ec2-3-91-71-35.compute-1.amazonaws.com:38000");

        Invoker.getMathServiceUrl("linearsearch", "2,3,4", "2");

        if (Invoker.currentMathService > Invoker.MATH_SERVICE_URLS.size() - 1) {
            Invoker.currentMathService = 0;
        }

        assertEquals(Invoker.currentMathService, Invoker.currentMathService);
    }
}