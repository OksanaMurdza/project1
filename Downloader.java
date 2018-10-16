import java.io.*;
import java.net.*;


public class Downloader {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int a;
        int n =0;

        System.out.println("Choose what with cat you want and write number");
        System.out.println("1 - random photo");
        System.out.println("2 - random cute photo");
        System.out.println("3 - random gif");
        System.out.println("4 - random cat saying hello");
        System.out.println("0 - Esc");

        for (; ; ) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            a = Integer.parseInt(br.readLine());
            if (a== 0) break;
            else {
                String str2 = Integer.toString(n);
                n++;
                Downloader dowloader = new Downloader();
                switch (a) {
                    case 1:

                        dowloader.downloadFiles("https://cataas.com/cat", "C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\test" + str2 + ".jpg", 1);
                        break;
                    case 2:

                        dowloader.downloadFiles("https://cataas.com/cat/cute", "C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\test" + str2 + ".jpg", 1);

                        break;
                    case 3:

                        dowloader.downloadFiles("https://cataas.com/cat/gif", "C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\test" + str2 + ".gif", 1);
                        break;
                    case 4:
                        dowloader.downloadFiles("https://cataas.com/cat/says/hello", "C:\\Users\\Admin\\IdeaProjects\\untitled\\src\\test"+ str2 +".jpg", 1);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Write correct number");


                }

            }
        }
    }

        public static void downloadFiles(String strURL, String strPath, int buffSize)  {

            try {


                URL connection = new URL(strURL);
                HttpURLConnection urlconn;
                urlconn = (HttpURLConnection) connection.openConnection();
                urlconn.setRequestMethod("GET");
                urlconn.connect();
                InputStream in = null;
                in = urlconn.getInputStream();

                OutputStream writer = new FileOutputStream(strPath);

                byte buffer[] = new byte[buffSize];
                int c = in.read(buffer);
                while (c > 0) {
                    writer.write(buffer, 0, c);
                    c = in.read(buffer);
                }
                writer.flush();
                writer.close();
                in.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }