package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * FileName: Tester.java
 * 
 * A tester to test out the implementation of the sorting algorithms
 * @author JianBin Wu
 *
 */
public class Tester {

    /** An ArrayList of IntegerToSort Object*/
    private static ArrayList<IntegerToSort> integerToSorts;
    /** Testing array use for Counting Sort and Bucket Sort */
    private static int[] A = {8, 8, 2, 9, 4, 2, 3, 5, 4, 9, 3, 7, 4, 7, 2};
    /** Result array of counting sort */
    private static int[] result = new int[A.length];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. CountingSort (Exercise 1)");
        System.out.println("2. Radix Sort (Exercise 2)");
        System.out.println("3. Bucket Sort (Exercise 3)");

        int selection = scanner.nextInt();
        while (selection == 1 || selection == 2 || selection == 3) {
            //perform counting sort if select 1
            if (selection == 1) {
                countingSort(); // Sort Array A using counting sort.
                System.out.println("-----------------------");
                System.out.println("1. CountingSort (Exercise 1)");
                System.out.println("2. Radix Sort (Exercise 2)");
                System.out.println("3. Bucket Sort (Exercise 3)");
            }
            //perform radix sort if select 2
            if (selection == 2) {
                //RadixSort
                System.out.println("-----------------------");
                System.out.println("Radix Sort");
                System.out.println("Test Array (30 Random Hex Number): ");

                // generate 30 hex number
                String[] hex = RadixSort.generateHexNumList();
                System.out.println(Arrays.toString(hex));
                // sort the generated 30 hex number
                String[] a = RadixSort.radixSort(hex,4);
                System.out.println("Result: ");
                System.out.println(Arrays.toString(a));

                System.out.println("-----------------------");
                System.out.println("1. CountingSort (Exercise 1)");
                System.out.println("2. Radix Sort (Exercise 2)");
                System.out.println("3. Bucket Sort (Exercise 3)");
            }

            //perform bucket sort if select 3
            if (selection == 3) {
                bucketSort(); // Sort Array A using bucket sort.
                System.out.println("-----------------------");
                System.out.println("1. CountingSort (Exercise 1)");
                System.out.println("2. Radix Sort (Exercise 2)");
                System.out.println("3. Bucket Sort (Exercise 3)");
            }

            selection = scanner.nextInt();

            }

        //exit if select any other number
        if( selection != 1 && selection != 2 && selection != 3) {
            System.out.println("Exit");
            scanner.close();
        }
    }

    /**
     * Use counting sort from CountingSort class to sort an ArrayList
     */
        public static void countingSort () {
            System.out.println("Test Array:");
            integerToSorts = new ArrayList<IntegerToSort>();
            for (int i = 0; i < A.length; i++) {
                //creat integerToSorts object for every element in testing array
                integerToSorts.add(new IntegerToSort(A[i], i));
            }

            for (IntegerToSort integerToSort : integerToSorts) {
                System.out.print(" " + integerToSort.getInteger() + "_" + integerToSort.getSubscript() + " ");
            }
            System.out.println(" ");
            System.out.println("Counting Sort: ");
            System.out.println("-----------------------");
            CountingSort.countingSort(A, result, 10);

            // sync result
            ArrayList<IntegerToSort> temp = new ArrayList<IntegerToSort>();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < integerToSorts.size(); j++) {
                    if (result[i] == integerToSorts.get(j).getInteger()) {
                        temp.add(new IntegerToSort(integerToSorts.get(j).getInteger(), integerToSorts.get(j).getSubscript()));
                        integerToSorts.remove(j);
                    }
                }
            }
            integerToSorts = temp;
            System.out.println("-----------------------");
            System.out.println("Result: ");
            for (IntegerToSort integerToSort : integerToSorts) {
                System.out.print(" " + integerToSort.getInteger() + "_" + integerToSort.getSubscript() + " ");
            }
            System.out.println(" ");
            System.out.println("Array Sorted");

        }


    /**
     * Use Bucket Sort from BucketSort class to sort an ArrayList
     */
    public static void bucketSort () {
            System.out.println("Test Array:");
            //creat integerToSorts object for every element in testing array
            integerToSorts = new ArrayList<IntegerToSort>();
            for (int i = 0; i < A.length; i++) {
                integerToSorts.add(new IntegerToSort(A[i], i));
            }
            for (IntegerToSort integerToSort : integerToSorts) {
                System.out.print(" " + integerToSort.getInteger() + "_" + integerToSort.getSubscript() + " ");
            }
            System.out.println(" ");
            System.out.println("BucketSort Result:  ");
            int[] bucketResult = BucketSort.bucketSort(A);

            // sync result
            ArrayList<IntegerToSort> temp = new ArrayList<IntegerToSort>();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < integerToSorts.size(); j++) {
                    if (bucketResult[i] == integerToSorts.get(j).getInteger()) {
                        temp.add(new IntegerToSort(integerToSorts.get(j).getInteger(), integerToSorts.get(j).getSubscript()));
                        integerToSorts.remove(j);
                    }
                }
            }
            integerToSorts = temp;
            for (int i = 0; i < integerToSorts.size(); i++) {
                System.out.print(" " + integerToSorts.get(i).getInteger() + "_" + integerToSorts.get(i).getSubscript() + " ");
            }
            System.out.println(" ");
            System.out.println("Array Sorted");
        }



    }

