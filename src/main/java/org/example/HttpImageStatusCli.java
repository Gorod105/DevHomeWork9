package org.example;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        boolean exit = true;
        while (exit) {
            String scanerText;
                scanerText = scanner.nextLine();
                int httpCode = 1;
                if (scanerText.matches("-?\\d+")){
                    httpCode = Integer.parseInt(scanerText);
                    if (HttpStatusChecker.getStatusImage(httpCode).equals("https://http.cat/" + httpCode + ".jpg")) {
                        try {
                            HttpStatusImageDownloader.downloadStatusImage(httpCode);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        exit = false;
                    } else if (httpCode != 0) {
                        System.out.println("There is not image for HTTP status " + httpCode);
                    }
                }else {
                    System.out.println("Please enter valid number");
                }



        }

    }
}
