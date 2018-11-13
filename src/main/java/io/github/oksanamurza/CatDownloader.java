package io.github.oksanamurza;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class CatDownloader {

    public static void main(String[] args) throws IOException {
        int ChooseNumber;
        int CounterDownloadFile =0;
        final int Enum1 =1;
        final int Enum2 =2;
        final int Enum3 =3;
        final int Enum4 =4;


        String LocalPath = "\"./src/test/\"";
        String URLPath[] = {"\"https://cataas.com/cat\"", "\"https://cataas.com/cat/cute\"",
                "\"https://cataas.com/cat/gif\"", "\"https://cataas.com/cat/says/hello\""};


        System.out.println("Choose what with cat you want and write number");
        System.out.println("1 - random photo");
        System.out.println("2 - random cute photo");
        System.out.println("3 - random gif");
        System.out.println("4 - random cat saying hello");
        System.out.println("0 - Esc");

        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ChooseNumber = Integer.parseInt(br.readLine());
            if (ChooseNumber == 0) break;
            else {
                String NameFile = Integer.toString(CounterDownloadFile);
                CounterDownloadFile++;

                switch (ChooseNumber) {
                    case Enum1:

                        downloadFiles(URLPath[0],  LocalPath + NameFile + ".jpg");
                        break;
                    case Enum2:

                        downloadFiles(URLPath[1], LocalPath + NameFile + ".jpg");

                        break;
                    case Enum3:

                        downloadFiles(URLPath[2], LocalPath + NameFile + ".gif");
                        break;
                    case Enum4:
                        downloadFiles(URLPath[3], LocalPath+ NameFile +".jpg");
                        break;
                    default:
                        System.out.println(" Write correct number between 0 and 4 ");

                }

            }
        }
    }

        private static void downloadFiles(String strURL, String strPath)  {

            try  (OutputStream writer = new FileOutputStream(strPath))
            {
                URL connection = new URL(strURL);
                HttpURLConnection urlconn = (HttpURLConnection) connection.openConnection();
                urlconn.setRequestMethod("GET");
                urlconn.connect();

                try (InputStream in = urlconn.getInputStream())
                {
                    byte buffer[] = new byte[1];
                    int reader = in.read(buffer);
                    do {
                        writer.write(buffer, 0, reader);
                        reader = in.read(buffer);
                    } while (reader > 0);
                    writer.flush();
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Problem with download file");
            }
        }
    }