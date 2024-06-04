package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HttpStatusImageDownloader {
        public static void downloadStatusImage(int code) throws IOException {

        String catImagetUrl = HttpStatusChecker.getStatusImage(code);
        URL requstUrl = URI.create(catImagetUrl).toURL();
        HttpURLConnection connection = (HttpURLConnection) requstUrl.openConnection();
        connection.setRequestMethod("GET");
        BufferedImage image = ImageIO.read(connection.getInputStream());
        ImageIO.write(image, "jpeg", new File("src/main/resources/" + code + ".jpeg"));
    }
}
