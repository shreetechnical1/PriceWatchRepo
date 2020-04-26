package global;
import java.io.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import java.net.URLDecoder;
import java.util.ArrayList;

public class MainURLs {

    public static class Paths {
        public static String getSourcePath() throws UnsupportedEncodingException {
            String path = MainURLs.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            return URLDecoder.decode(path, "UTF-8");
        }

    }

    public static class URLList{

        public static String PriceWatchURL;
        public static String WalmartURL;
        public static String BhpPhotoURL;
        public static String BestBuyURL;
        public static String CostcoURL;
        public static String DriverName;

        static {
            FileInputStream inputStream;

            try {
                String finalPath = Paths.getSourcePath() + "global/testURLs.txt";

                if (!new File(finalPath).exists()) {
                    BufferedWriter w = new BufferedWriter(new FileWriter(finalPath));

                    w.write("http://192.168.1.61/PriceWatch");
                    w.newLine();
                    w.write("http://www.walmart.com");
                    w.newLine();
                    w.write("http://www.bhphotovideo.com");
                    w.newLine();
                    w.write("http://www.bestbuy.com");
                    w.newLine();
                    w.write("http://www.costco.com");
                    w.newLine();
                    w.write("Chrome");
                    w.newLine();
                    w.close();
                }

                inputStream = new FileInputStream(finalPath);

                ArrayList<String> l = new ArrayList<>();

                LineIterator it = IOUtils.lineIterator(inputStream, "UTF-8");
                while (it.hasNext()) {
                    String line = it.nextLine();
                    l.add(line);
                }

                PriceWatchURL = l.get(0);
                WalmartURL = l.get(1);
               BhpPhotoURL = l.get(2);
                BestBuyURL = l.get(3);
                CostcoURL = l.get(4);
                DriverName = l.get(5);

                inputStream.close();
            }

            catch (IOException e) {
                e.printStackTrace();
            }

            }



        }

    }




