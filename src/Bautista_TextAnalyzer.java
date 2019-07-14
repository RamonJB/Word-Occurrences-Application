
import java.util.*;
import java.io.*;

/**
 * Parsing a .txt file and outputting the 20 most common words from that .txt
 * file. Updated for Assignment 7 to add getter methods for the wordCounter and
 * the wordCountList and remove the main function.
 * 
 * @author Ramon Bautista
 * @date 06/22/19
 *
 */
public class Bautista_TextAnalyzer {

    // HashMap that contains the word for the key and a WordCountContainer for
    // the value (the word itself and how many times it appears in the text).
    private HashMap<String, Bautista_WordCountContainer> wordCounter;

    // List of WordCountContainers that will be used to order the entries from
    // the HashMap wordCounter.
    private List<Bautista_WordCountContainer> wordCountList;

    /**
     * TextAnalyzer constructor. Takes in the .txt file to parse and puts all of
     * the words from the text and the number of times they appear into the
     * HashMap wordCounter.
     * 
     * @param file The .txt file to analyze.
     * @throws FileNotFoundException Exception thrown if the file isn't found.
     */
    public Bautista_TextAnalyzer(File file) throws FileNotFoundException {
        // Initiating the HashMap.
        this.wordCounter = new HashMap<>();

        Scanner sc = new Scanner(file);

        // Parsing the .txt file and putting each word and the number of times
        // it appears into the HashMap wordcounter.
        while (sc.hasNextLine()) {
            // Splitting the line by spaces and putting each word into the
            // String[] words.
            String line = sc.nextLine();
            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++) {
                // Taking the currentWord and putting it to lowercase to avoid
                // recounting different words due to capitalization.
                String currentWord = words[i].toLowerCase();

                // If the word isn't in the HashMap, put it in the HashMap and
                // increment its' count to 1.
                if (wordCounter.get(currentWord) == null) {
                    wordCounter.put(currentWord,
                            new Bautista_WordCountContainer(currentWord, 1));
                }

                // Else the word IS in the HashMap, so we just increment
                // its' count.
                else {
                    wordCounter.get(currentWord).increasewordCount();
                }
            }
        }

        // Close the scanner.
        sc.close();

        // Organize the top 20 entries in the wordCountList.
        organizeEntries();
    }

    /**
     * Getter method for wordCountList that contains the ordered entries of
     * words.
     * 
     * @return wordCountList, list that contains the ordered entries of words.
     */
    public List<Bautista_WordCountContainer> getwordCountList() {
        return wordCountList;
    }

    /**
     * Getter method for HashMap wordCounter.
     * 
     * @return wordCounter, HashMap that contains unordered entries of words.
     */
    public HashMap<String, Bautista_WordCountContainer> getwordCounter() {
        return wordCounter;
    }

    /**
     * Helper method that prints out the 20 most common words from the scanned
     * file in order from ascending to descending.
     */
    public void topTwentyEntries() {
        System.out.println("   Word\t\t Word Count");

        int i = 0;
        for (Bautista_WordCountContainer entry : wordCountList) {
            i++;
            System.out.println(i + ") " + entry.toString());

            if (i == 20) {
                break;
            }
        }
    }

    /**
     * Helper method that takes all of the entries from HashMap wordCounter and
     * puts them into a list of WordCountContainer objects to be ordered from
     * ascending to descending.
     */
    private void organizeEntries() {
        // Each entry is essentially a HashMap entry and we're sorting it by the
        // value of each entry (i.e. the wordCount) so we get to keep both the
        // key (i.e. the word) and its' respective wordCount.
        wordCountList = new ArrayList<Bautista_WordCountContainer>(
                wordCounter.values());

        // Sorting the list using the WordCountComparator puts the list in
        // ascending order so I just reverse the list to put it in descending
        // order.
        Collections.sort(wordCountList, new Bautista_WordCountComparator());
        Collections.reverse(wordCountList);
    }

}
