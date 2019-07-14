
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
// imports that allow to assertEquals between two lists.
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Using the JUnit testing framework to test the Bautista_TextAnalyzer wordList
 * method to ensure it contains all words and their word count in the
 * List<String, Bautista_WordCountContainer>.
 * 
 * @author Ramon Bautista
 * @date 06/30/19
 *
 */
class Bautista_TextAnalyzer_wordListTest {

    @Test
    void test() throws FileNotFoundException {
        // Setting up the text analyzer to accept the .txt file for the purpose
        // of the test, testPassage.txt.
        File file = new File(
                "C:\\insert\\path\\to\\testPassage.txt");
        Bautista_TextAnalyzer testAnalyzer = new Bautista_TextAnalyzer(file);

        // Getting the word list that the constructor creates from the analysis.
        List<Bautista_WordCountContainer> list = testAnalyzer
                .getwordCountList();

        // Adding in the wordCountContainer entries into the test results that
        // we'll compare to.
        List<Bautista_WordCountContainer> testList = new ArrayList<Bautista_WordCountContainer>();

        testList.add(new Bautista_WordCountContainer("engineer", 4));
        testList.add(new Bautista_WordCountContainer("software", 3));
        testList.add(new Bautista_WordCountContainer("developer", 1));
        testList.add(new Bautista_WordCountContainer("electrical", 1));
        testList.add(new Bautista_WordCountContainer("mechanical", 1));
        testList.add(new Bautista_WordCountContainer("civil", 1));
        testList.add(new Bautista_WordCountContainer("architect", 1));
        testList.add(new Bautista_WordCountContainer("medical", 1));
        testList.add(new Bautista_WordCountContainer("doctor", 1));

        assertThat(list, is(testList));
    }

}
