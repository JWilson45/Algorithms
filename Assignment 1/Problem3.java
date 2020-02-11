/*
Jason Wilson
Thursday, February 6th 2020
CMPT435L 111 20S
*/

public class Problem3 {

	public static boolean majority(int[] A)
	{
		/*
		Input: an array A of n integers (positive, negative, or 0), elements sorted in ascending order.
		Output: if there exists a majority element.
		An element is a majority if it appears more than n/2 times. For example, if the input list is:
		{0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 7}
		The output should be true, as 0 appears 6 times (>n/2 = 11/2 times).
		However, if the input list is:
		{0, 0, 0, 1, 1, 2, 3, 10, 10}
		The majority element does not exist.
		Design an algorithm that solves this problem.
		*/

		// Complete this method

    int half = A.length / 2;			// divide A.length by 2 to get the upper bound of the search area

    int i = 0;			// lower bound
    int j = half;		// upper bound


    while (j < A.length) {		// while the upper bound is less than A.length...

      if (A[i] == A[j]) {		// if element A[i] equals element A[j] there is a majority element
        return true;
      }


      i++;
      j++;


    }


    return false;		// if the end of the loop is reached, there is no majority element


	}



	public static void main(String[] args) {
		// Test your majority method

		int[] testarray1 = {0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 7};

		int[] testarray2 = {0, 0, 0, 1, 1, 2, 3, 10, 10};


		System.out.println("Does there exist a majoirty element in testarray1? "+ majority(testarray1));
		System.out.println("Does there exist a majoirty element in testarray2? "+ majority(testarray2));

	}

}
