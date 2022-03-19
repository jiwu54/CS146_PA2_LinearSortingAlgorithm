package exercises;

/**
 * FileName: IntegerToSort.java
 * 
 * Use to prove and explain if Counting Sort and Bucket Sort is a stable algorithm.
 * 
 * @author JianBin Wu
 *
 */
public class IntegerToSort {
    /** integer to create a IntegerToSort object */
    private int integer;

    /** integer to create a IntegerToSort object */
    private int subscript;

    /**
     * Construct an Object with a integer and subscript
     * @param integer integer
     * @param subscript subscript
     */
    public IntegerToSort(int integer, int subscript){
        this.integer = integer;
        this.subscript = subscript;
    }

    /**
     * Get the integer
     * @return integer
     */
    public int getInteger() {
        return integer;
    }

    /**
     * Get the subscript
     * @return subscript
     */
    public int getSubscript() {
        return subscript;
    }
}
