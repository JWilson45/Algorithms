/*
Jason Wilson
Thursday, February 6th 2020
CMPT435L 111 20S
*/

public class Problem2 {

	public static int missingnumber(int[] A)
	{
		/*
		Input: a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers from 1 to n is missing in the list.
		Output: find the missing integer
		Let the input array be [2, 4, 1, 6, 3, 7, 8]. Elements in this list are in the range of 1 to 8. There are no duplicates, and 5 is missing. Your algorithm needs to return 5.
		Design an algorithm that solves this problem.
		*/

		// Complete this method

		int[] arrTest = new int[A.length + 1];			// array holding all values of A(n + 1)
		int num = 0;


		for (int i = 0; i < arrTest.length; i++) {

			arrTest[i] = i + 1				// initilize the test array with numbers 1 through A.length + 1

		}


		for (int i = 0; i < A.length; i++) {

			arrTest[A[i] - 1] = 0;			// remove all elements that are in both A and arrTest

		}


		for (int i : arrTest) {		// for all elements in arrTest

			if (i != 0) {		// find the element that is not equal to 0 (missing from A)

				num = i;

				break;

			}

		}

		return num; 		// return the one remaining number in arrTest

	}


	public static void main(String[] args) {
		// Test your majority method

		int[] testarray1 = {2, 4, 1, 6, 3, 7, 8};

		int[] testarray2 = {6, 3, 4, 5, 1};


		System.out.println("The missing number in testarray1 "+ missingnumber(testarray1));
		System.out.println("The missing number in testarray2 "+ missingnumber(testarray2));

	}

}
