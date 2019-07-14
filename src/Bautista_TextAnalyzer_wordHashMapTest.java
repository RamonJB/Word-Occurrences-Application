
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

/**
 * Using the JUnit testing framework to test the Bautista_TextAnalyzer wordList
 * method to ensure it contains all words and their word count in the
 * HashMap<String, Bautista_WordCountContainer>.
 * 
 * @author Ramon Bautista
 * @date 06/30/19
 *
 */
class Bautista_TextAnalyzer_wordHashMapTest {

    @Test
    void test() throws FileNotFoundException {
        // Setting up the text analyzer to accept the .txt file for the purpose
        // of the test, testPassage.txt.
        File file = new File(
                "C:\\insert\\path\\to\\testPassage.txt");
        Bautista_TextAnalyzer testAnalyzer = new Bautista_TextAnalyzer(file);

        // Getting the hashMap that the constructor creates from the analysis.
        HashMap<String, Bautista_WordCountContainer> wordMap = testAnalyzer
                .getwordCounter();

        // Adding in the wordCountContainer entries that make up the test
        // results which we compare to.
        HashMap<String, Bautista_WordCountContainer> testMap = new HashMap<>();

        testMap.put("engineer", new Bautista_WordCountContainer("engineer", 4));
        testMap.put("software", new Bautista_WordCountContainer("software", 3));
        testMap.put("developer",
                new Bautista_WordCountContainer("developer", 1));
        testMap.put("electrical",
                new Bautista_WordCountContainer("electrical", 1));
        testMap.put("mechanical",
                new Bautista_WordCountContainer("mechanical", 1));
        testMap.put("civil", new Bautista_WordCountContainer("civil", 1));
        testMap.put("architect",
                new Bautista_WordCountContainer("architect", 1));
        testMap.put("medical", new Bautista_WordCountContainer("medical", 1));
        testMap.put("doctor", new Bautista_WordCountContainer("doctor", 1));

        assertTrue(wordMap.equals(testMap));
    }

}
