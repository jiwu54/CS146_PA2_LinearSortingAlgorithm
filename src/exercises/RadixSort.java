package exercises;

import java.util.Random;

/**
 * FileName: RadixSort.java
 * 
 * Implementation of Radix Sort, 
 * following the pseudo codes from the book Introduction To Algorithms Third Edition
 * 
 * @author JianBin Wu
 *
 */
public class RadixSort {

    /**
     * Radix Sort, sort element with ASCII code
     * @param A Target Array to sort
     * @param d Number of digit of the elements
     * @return The result array
     */
    public static String[] radixSort(String[] A, int d) {

        for(int i = d ; i >= 0 ; i--){
            // convert digits in to ASCII code
            int[] asciiToSort = new int[30];
            for(int j = 0 ; j <  A.length; j++) {
                int k = A[j].charAt(i);
                asciiToSort[j] = k;
            }
            int[] hexResult = new int[30];
            // sort digits using counting sort and store result in array hexResult
            countingSort(asciiToSort,hexResult,103);

            // sync array A with the sorting result (base on array hexResult)
            String[] temp = new String[30];
            int counter = 0;
            for(int k = 0; k < hexResult.length; k++) {
                for (int o = 0; o < A.length; o++) {
                    if(A[o] != null){
                       if(hexResult[k] == (int)A[o].charAt(i)){
                            temp[counter] = A[o];
                            counter++;
                            A[o] = null;
                        }
                    }
                }

            }

            //set A to temp array in order to sort the next digit
            A = temp;
        }

        return A;

    }

    /**
     * Counting Sort for Radix Sort
     * @param A Target Array to Sort
     * @param B Result Array after sort
     * @param k Range of numbers 
     */
    public static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k];
        for (int i = 0; i < k; i++)
        {
            C[i] = 0;
        }
        for(int j = 0; j < A.length; j++)
        {
            C[A[j]] = C[A[j]]+1;
        }
        for(int i = 1; i < k; i++)
        {
            C[i] = C[i] + C[i-1];
        }

        for (int j = A.length; j > 0; j--) {
            B[C[A[j-1]]-1] = A[j-1];
            C[A[j-1]] = C[A[j-1]] - 1;
        }

    }

    /**
     * Generate 30 random Hex number
     * @return 30 random Hex number
     */
    public static String[] generateHexNumList()
    {
        Random random = new Random();
        String[] hex = new String[30];
        for (int i = 0; i < 30; i++) {
            int hexNum = random.nextInt(0x100000 - 0x10000) + 0x10000;
            String hexS = Integer.toHexString(hexNum);;
            hex[i] = hexS;
        }
        return hex;
    }




}
