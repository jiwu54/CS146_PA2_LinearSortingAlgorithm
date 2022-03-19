package exercises;

import java.util.Arrays;

/**
 * FileName: CountingSort.java
 * 
 * Implementation of Counting Sort, 
 * following the pseudo codes from the book Introduction To Algorithms Third Edition
 * 
 * @author JianBin Wu
 *
 */
public class CountingSort {

	/**
	 * Counting Sort to sort an array
	 * @param A Target array to sort
	 * @param B The result array
	 * @param k The range of numbers
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
		System.out.println("Array C: " + Arrays.toString(C));
		for(int i = 1; i < k; i++) 
		{
			C[i] = C[i] + C[i-1];
		}

		System.out.println( "Array C: " +  Arrays.toString(C));
		for (int j = A.length; j > 0; j--) {
			B[C[A[j-1]]-1] = A[j-1];
			C[A[j-1]] = C[A[j-1]] - 1;
			System.out.println("Array C: " + Arrays.toString(C));
			System.out.println("Array B:" + Arrays.toString(B));
		}
		
	}


}
