
import java.util.Comparator;

/**
 * Comparator for sorting the entries within the WordCounter HashMap in
 * Bautista_TextAnalyzer.
 * 
 * @author Ramon Bautista
 * @date 05/24/19
 *
 */
public class Bautista_WordCountComparator
        implements Comparator<Bautista_WordCountContainer> {

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     * 
     * Compares each WordCountContainer entry by its' value (i.e. its'
     * wordCount) which is how the list will be sorted, then reversed for
     * assignment purposes.
     */
    @Override
    public int compare(Bautista_WordCountContainer word1,
            Bautista_WordCountContainer word2) {
        int word1Count = word1.getwordCount();
        int word2Count = word2.getwordCount();

        return Integer.compare(word1Count, word2Count);
    }

}
