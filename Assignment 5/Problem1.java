/*
Jason Wilson
Thursday, March 5th 2020
CMPT435L 111 20S
*/
public class Problem1 {

	public int findmaxdiff(int[] A, int start, int end) {

				// Base case, if array size == 1
				if (start - end == 0) {
					return -1;
				}

				// get the midpoint of the array
        int mid = start + (end - start) / 2;

				// recursive calls cutting the array in half
        int diffL = findmaxdiff(A, start, mid);
        int diffR = findmaxdiff(A, mid + 1, end);

				// get the leftmost minimum element
				int minL = A[start];
				for (int i = start + 1; i <= mid; i++) {
					if(A[i] < minL) {
						minL = A[i];
					}
				}

				// get the rightmost maximum element
				int maxR = A[mid];
				for (int i = mid + 1; i <= end; i++) {
					if(A[i] > maxR) {
						maxR = A[i];
					}
				}

				// Compare the left and right sections of the array
        int newDiff = maxR - minL;

				// Find the maximum element between the left and right half,
				// compared to newDiff
				int result = Math.max(newDiff, Math.max(diffL,diffR));

        return result;
    }




	public static void main(String[] args) {
		Problem1 diff = new Problem1();

		int[] testarray1 = {2, 3, 10, 6, 4, 8, 1};
		// maxdiff: 8

		int[] testarray2 = {7, 9, 1, 6, 3, 2};
		// maxdiff: 5

		int start = 0;
		int end1 = testarray1.length - 1;
		int end2 = testarray2.length - 1;

		System.out.println("MaxDiff of 1: " + diff.findmaxdiff(testarray1,start,end1));
		System.out.println("MaxDiff of 2: " + diff.findmaxdiff(testarray2,start,end2));



	}
}
