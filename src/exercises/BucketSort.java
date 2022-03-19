package exercises;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * FileName: BucketSort.java
 * 
 * Implementation of Bucket Sort, 
 * following the pseudo codes from the book Introduction To Algorithms Third Edition
 * 
 * @author JianBin Wu
 *
 */
public class BucketSort {
	
	/**
	 * BucketSort to sort an array
	 * @param A The target array to sort
	 * @return A result array
	 */
	public static int[] bucketSort(int[] A) {
		int n = A.length;
		int [] result =  new int[A.length];
		ArrayList<LinkedList<Integer>> B = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			//create buckets using LinkList
			B.add(i, new LinkedList<>());
		}
		for (int i = 0 ; i < n; i++) {
			//store integers in specific bucket
				B.get(A[i]).add(A[i]);
			}

		for(int i = 0; i < 10; i++) {
			//create array for each bucket
			int[] C = new int[B.get(i).size()];
			for(int j = 0; j < B.get(i).size(); j++) {
				C[j] = B.get(i).get(j);
			}
			//insertion sort to sort each bucket
			for(int k = 1 ; k < C.length ; k++)
			{
				int key = C[k];
				int l = k - 1;
				while(l > -1 && C[l] > key)
				{
					C[l + 1] = C[l];
					l = l - 1;
				}
				C[l + 1] = key;

			}
			//update LinkList
			for(int m = 0; m < B.get(i).size(); m++) {
				 B.get(i).set(m,C[m]);
			}

		}
		//concatenate LinkList in to array
		int count = 0;
		for(int i = 0; i < 10; i++){
			if(B.get(i).size() != 0){
				for(int j = 0; j < B.get(i).size(); j++){
					result[count] = B.get(i).get(j);
					count++;
				}
			}
		}
		return result;
	}

}




