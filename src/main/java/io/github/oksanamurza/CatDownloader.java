package io.github.oksanamurza;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class CatDownloader {

    public static void main(String[] args) throws IOException {
        int number;
        int partnamedownloadfile =0;

        System.out.println("Choose what with cat you want and write number");
        System.out.println("1 - random photo");
        System.out.println("2 - random cute photo");
        System.out.println("3 - random gif");
        System.out.println("4 - random cat saying hello");
        System.out.println("0 - Esc");

        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            number = Integer.parseInt(br.readLine());
            if (number == 0) break;
            else {
                String str2 = Integer.toString(partnamedownloadfile);
                partnamedownloadfile++;

                switch (number) {
                    case 1:

                        downloadFiles("https://cataas.com/cat", "./src/test" + str2 + ".jpg", 1);
                        break;
                    case 2:

                        downloadFiles("https://cataas.com/cat/cute", "./src/test" + str2 + ".jpg", 1);

                        break;
                    case 3:

                        downloadFiles("https://cataas.com/cat/gif", "./src/test" + str2 + ".gif", 1);
                        break;
                    case 4:
                        downloadFiles("https://cataas.com/cat/says/hello", "./src/test"+ str2 +".jpg", 1);
                        break;
                    default:
                        System.out.println("Write correct number");

                }

            }
        }
    }

        public static void downloadFiles(String strURL, String strPath, int buffSize)  {

            try  (OutputStream writer = new FileOutputStream(strPath))
            {
                URL connection = new URL(strURL);
                HttpURLConnection urlconn = (HttpURLConnection) connection.openConnection();
                urlconn.setRequestMethod("GET");
                urlconn.connect();

                try (InputStream in = urlconn.getInputStream())
                {
                    byte buffer[] = new byte[buffSize];
                    int c = in.read(buffer);
                    do {
                        writer.write(buffer, 0, c);
                        c = in.read(buffer);
                    } while (c > 0);
                    writer.flush();
                }

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Problem with download file");
            }
        }
    }