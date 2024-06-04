package org.example;

import java.io.IOException;
import java.net.*;

public class HttpStatusChecker {

    public static String getStatusImage(int code){
        int responseCode = 0;
        String status = "https://http.cat/%s.jpg";
        try {
            URI catURI = new URI("https://http.cat", "/" + code, null );
            URL catUrl = catURI.toURL();
            HttpURLConnection connection = (HttpURLConnection) catUrl.openConnection();
            connection.setRequestMethod("GET");
            responseCode = connection.getResponseCode();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        if(responseCode == 200) {
            return status.formatted(code);
        }else {
            return status.formatted("404");
        }
    }
}
