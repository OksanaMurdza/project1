package io.github.oksanamurza;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class CatDownloader {

    public static void main(String[] args) throws IOException {
        int menuChoice;
        int downloadedFileCounter = 0;
        final int RANDOM = 1;
        final int CUTE = 2;
        final int GIF = 3;
        final int HELLO = 4;

        final String path = "./src/test";
        final String URLPath[] = {"https://cataas.com/cat", "https://cataas.com/cat/cute",
                "https://cataas.com/cat/gif", "https://cataas.com/cat/says/hello"};

        while (true) {
            System.out.println("Choose what with cat you want and write number");
            System.out.println("1 - random photo");
            System.out.println("2 - random cute photo");
            System.out.println("3 - random gif");
            System.out.println("4 - random cat saying hello");
            System.out.println("0 - Esc");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            menuChoice = Integer.parseInt(reader.readLine());
            if (menuChoice == 0)
                break;

            switch (menuChoice) {
                case RANDOM:
                    downloadFiles(URLPath[0], path + downloadedFileCounter + ".jpg");
                    break;
                case CUTE:
                    downloadFiles(URLPath[1], path + downloadedFileCounter + ".jpg");
                    break;
                case GIF:
                    downloadFiles(URLPath[2], path + downloadedFileCounter + ".gif");
                    break;
                case HELLO:
                    downloadFiles(URLPath[3], path + downloadedFileCounter + ".jpg");
                    break;
                default:
                    System.out.println(" Write correct number between 0 and 4 ");
            }
            downloadedFileCounter++;
        }
    }

    private static void downloadFiles(String url, String path) {
        try (OutputStream writer = new FileOutputStream(path)) {
            URL connection = new URL(url);
            HttpURLConnection urlconn = (HttpURLConnection) connection.openConnection();
            urlconn.setRequestMethod("GET");
            urlconn.connect();

            try (InputStream in = urlconn.getInputStream()) {
                byte buffer[] = new byte[1];
                int blockSize = in.read(buffer);
                do {
                    writer.write(buffer, 0, blockSize);
                    blockSize = in.read(buffer);
                } while (blockSize > 0);
                writer.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problem with download file");
        }
    }
}