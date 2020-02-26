
public class Problem2
{

public static Min2ndMin dcfindmin2ndmin(int[] A, int i, int j)
	{
		// Complete this method to find min and 2nd min in an array A
		// At most 3/2n-2 comparisons
		// Algorithms that make more comparisons will be scored out of 5 points
		// Complete the code from here
		// Feel free to change return type, parameters


		Min2ndMin pair = new Min2ndMin();

		if (j - i == 0) {

			pair.min = i;
			pair.min2nd = j;

		}
		else if (j - i == 1) {

			if (A[i] > A[j]) {
				pair.min = j;
				pair.min2nd = i;
			} else {
				pair.min = i;
				pair.min2nd = j;
			}

		} else {

			int mid = (i + j) / 2;

			int startL = i;
			int endL = mid;

			int startR = mid + 1;
			int endR = j;

			Min2ndMin pairL = new Min2ndMin();
			Min2ndMin pairR = new Min2ndMin();

			pairL = dcfindmin2ndmin(A, startL, endL);
			pairR = dcfindmin2ndmin(A, startR, endR);

			// System.out.println("PairL: " + pairL.min + " " + pairL.min2nd);
			// System.out.println("PairR: " + pairR.min + " " + pairR.min2nd);

			if (A[pairL.min] > A[pairR.min]) {

				pair.min = pairR.min;

				pair.min2nd = min(A, pairL.min, pairR.min2nd);

				// (A[pairL.min] < A[pairR.min])
			} else {

				pair.min = pairL.min;

				pair.min2nd = min(A, pairR.min, pairL.min2nd);

			}

		}

		System.out.println("Pair: " + pair.min + " " + pair.min2nd);

		return pair;

	}

	public static int min(int[] A, int a, int b) {

		if (A[a] > A[b])
			return b;

		else return a;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method
		int[] givenarray = {100,2,3,4,5,6,7,67,32};

		// Test your method
		Min2ndMin pair = new Min2ndMin();
		pair = dcfindmin2ndmin(givenarray, 0, givenarray.length-1);
		int min2nd = pair.min2nd;
		int min = pair.min;
		System.out.println("The min and 2ndmin of the given array are "+ givenarray[min] + " and "+ givenarray[min2nd] +".");
		// Your method should return 2 and 3



	}


}



		// 	if (A[pairL.min] > A[pairR.min]) {
		//
		// 		pair.min = pairR.min;
		//
		// 		if (A[pairL.min] > A[pairR.min2nd]) {
		//
		// 			pair.min2nd = pairR.min2nd;
		//
		// 		} else {
		//
		// 			pair.min2nd = pairL.min;
		//
		// 		}
		//
		// 	} else {
		//
		// 		pair.min = pairL.min;
		//
		// 		if (A[pairR.min] > A[pairL.min2nd]) {
		//
		// 			pair.min2nd = pairR.min2nd;
		//
		// 		} else {
		//
		// 			pair.min2nd = pairR.min;
		//
		// 		}
		//
		// 	}
		//
		// }
