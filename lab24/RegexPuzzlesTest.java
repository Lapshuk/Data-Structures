import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by romanlapshuk on 8/8/17.
 */
public class RegexPuzzlesTest {
    @Test
    public void urlRegex() throws Exception {
        String[] list = {"(randomstuff1234https://www.eecs.berkeley.edu/blah.htmlyoullneverfindyourextracredit)",
                "hello world","1234https://www.eecs", "(https://en.wikipedia.org/greed.htmltry23andfindmenow)",
                "(http://www.cs61bl.github.io/yolo.html)"};
        ArrayList<String> out = (ArrayList)RegexPuzzles.urlRegex(list);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("(randomstuff1234https://www.eecs.berkeley.edu/blah.htmlyoullneverfindyourextracredit)");
        expected.add("(https://en.wikipedia.org/greed.htmltry23andfindmenow)");
        expected.add("(http://www.cs61bl.github.io/yolo.html)");

        RegexPuzzles p = new RegexPuzzles();
        assertEquals(expected, out);
    }

    @Test
    public void findStartupName() throws Exception {
        String[] list = {"Datahey.tv",
                "hello world","1234https://www.eecs", "mylo.io",
                "(http://www.cs61bl.github.io/yolo.html)"};
        ArrayList<String> out = (ArrayList)RegexPuzzles.findStartupName(list);
        System.out.println(out);
    }

    @Test
    public void imageRegex() throws Exception {
    }

    @Test
    public void arrayToBufferedImage() throws Exception {
    }

    @Test
    public void main() throws Exception {
    }

}