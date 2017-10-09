import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPuzzles {
    public static List<String> urlRegex(String[] urls) {
        Pattern urlPattern =
                Pattern.compile("\\(.*?(http://||https://)\\w+\\.[a-z]{2,3}/\\w+\\.html.*?\\)");
        ArrayList<String> list = new ArrayList<>();

        for (String s : urls) {
            Matcher matched = urlPattern.matcher(s);
            if(matched.matches()){
                list.add(s);
            }
        }
        return list;
    }

    public static List<String> findStartupName(String[] names) {
        String s = "^(Data|App|my|on|un)[0-9A-HJ-Za-hj-z]+(ly|sy|ify|.io|.fm|.tv)$";
        Pattern startupPattern = Pattern.compile(s);
        Matcher startupMatcher;
        List<String> result = new ArrayList<>();

        for (int i=0; i < names.length; i++) {
            startupMatcher = startupPattern.matcher(names[i]);
            if (startupMatcher.matches()) {
                result.add(names[i]);
            }
        }

        return result;
    }

    public static BufferedImage imageRegex(String filename, int width, int height) {
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file found: " + filename);
        }


        int[][][] result = new int[width][height][3];
        String coordinate = "\\([0-9]{1,3}, [0-9]{1,3}\\)";
        String rgb = "\\[[0-9]{1,3}, [0-9]{1,3}, [0-9]{1,3}\\]";
        Pattern coordinatePattern = Pattern.compile(coordinate);
        Pattern rgbPattern = Pattern.compile(rgb);
        int r, g, b, w, h;
        String rgbs, whs;

        try {
            String line;
            while ((line = br.readLine()) != null) {

                Matcher coordinateMatcher = coordinatePattern.matcher(line);
                coordinateMatcher.find();
                whs = coordinateMatcher.group(0).replace(" ",""); // [5, 10]
                String[] temp1 = whs.substring(1,whs.length()-1).split(",");
                w = Integer.parseInt(temp1[0]);
                h = Integer.parseInt(temp1[1]);

                Matcher rgbMatcher = rgbPattern.matcher(line);
                boolean m = rgbMatcher.find();
                rgbs = rgbMatcher.group(0).replace(" ",""); // (10, 94, 50)
                String[] temp = rgbs.substring(1,rgbs.length()-1).split(",");

                result[w][h][0] = Integer.parseInt(temp[0]);
                result[w][h][1] = Integer.parseInt(temp[1]);
                result[w][h][2] = Integer.parseInt(temp[2]);

            }
        } catch (IOException e) {
            System.err.printf("Input error: %s%n", e.getMessage());
            System.exit(1);
        }

        return  arrayToBufferedImage(result);
    }

    public static BufferedImage arrayToBufferedImage(int[][][] arr) {
        BufferedImage img = new BufferedImage(arr.length, arr[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int pixel = 0;
                for (int k = 0; k < 3; k++) {
                    pixel += arr[i][j][k] << (16 - 8 * k);
                }
                img.setRGB(i, j, pixel);
            }
        }

        return img;
    }

    public static void main(String[] args) {
        /* For testing image regex */
        BufferedImage img = imageRegex("mystery.txt", 400, 400);

        File outputfile = new File("output_img.jpg");
        try {
            ImageIO.write(img, "jpg", outputfile);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
