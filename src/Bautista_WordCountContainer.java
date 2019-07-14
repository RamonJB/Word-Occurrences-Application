
/**
 * Object type that will be used in the TextAnalyzer to store a word and its'
 * count. Contains basic setter and getter methods for both values, an
 * incrementer for wordCount, and a String formatter for entries.
 * 
 * @author Ramon Bautista
 * @date 05/24/19
 *
 */
public class Bautista_WordCountContainer {

    // The word found while parsing the file.
    private String word;

    // The amount of times the word appears while parsing the file.
    private int wordCount;

    /**
     * WordCountContainer constructor that takes in a word and how many times it
     * has appeared.
     * 
     * @param word      The word that's found in the text.
     * @param wordCount The number of times the word appears in the text.
     */
    public Bautista_WordCountContainer(String word, int wordCount) {
        this.word = word;
        this.wordCount = wordCount;
    }

    /**
     * word getter method
     * 
     * @return String of the word
     */
    public String getWord() {
        return word;
    }

    /**
     * wordCount getter method
     * 
     * @return int of the number of times that a respective word appears.
     */
    public int getwordCount() {
        return wordCount;
    }

    /**
     * Word setter method
     * 
     * @param word String of the word to change the entry's word to.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * wordCount setter method
     * 
     * @param wordCount the int to change the entry's wordCount to.
     */
    public void setwordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    /**
     * wordCount incrementer (adds one to the wordCount of an entry)
     */
    public void increasewordCount() {
        wordCount++;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     * 
     * String version of each entry which helps with formatting.
     */
    public String toString() {
        return String.format("%-11s \t\t %-3d", word, wordCount);
    }

}
