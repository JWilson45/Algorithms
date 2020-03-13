/*
Jason Wilson
Thursday, March 12th 2020
CMPT435L 111 20S
*/

import java.util.Arrays;

public class Problem3
{

    public static void threeway(int A[], int start, int end)
		//complete the code from here
		//given an array A[], write a function that re-arrange elements in A[] that pivot and
		//elements=pivot are placed in the middle, elements < pivot are on the left handside
		// elements > pivot are on the right handside.
		//in-place, O(n) expected
    {
        if (start < end) {

            int p = partition(A, start, end);

						// Recursive call ot three way with pivot for left and right of p
            threeway(A, start, p - 1);
            threeway(A, p + 1, end);
        }
    }

		public static int partition(int A[], int start, int end)
    {
			// p = end of A
      int p = A[end];

			// i = the smallest element in array A[]
      int i = start - 1;


      for (int j = start; j < end; j++) {

  			// If element at index A[j] < p...
    		if (A[j] < p) {
      		i++;

        	// then swap approptiate elements
        	int tmp = A[i];
        	A[i] = A[j];
					A[j] = tmp;

        }
      }

      // final swap before completion
      int tmp = A[i + 1];
      A[i + 1] = A[end];
      A[end] = tmp;

			// OUTPUT the index of p
      return i + 1;
    }
		

    public static void main(String args[])
    {
        int testarray[] = {1, 2, 2, 2, 6, 1, 7, 0, -5, 2, 8, 1, 3, 1, 1};
        int n = testarray.length;

        Problem3 object = new Problem3();
        object.threeway(testarray, 0, n-1);

        System.out.print("The Array Sorted: ");

        for (int i = 0; i < testarray.length; i++)
            System.out.print(testarray[i]+", ");
    }
}
