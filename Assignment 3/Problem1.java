/*
Jason Wilson
Thursday, February 20th 2020
CMPT435L 111 20S
*/

public class Problem1 {

	public static int count(double[] A, double x)
	{
		// given sorted array A, and a value x, return the number of times x occurs in A
		// complete the method count() here
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type or parameters

    int start = 0;
    int end = A.length;
    int mid = (start + end) / 2;
		int leftIndex = 0;
		int rightIndex = 0;

		while (start <= end) {

			mid = (start + end) / 2;

	   	if ((mid == 0 && A[mid] == x) || (A[mid] == x && A[mid - 1] < x)) {
				end = mid - 1;
				leftIndex = mid;
	    }
	    else if (A[mid] < x) {
	      start = mid + 1;
	    }
	    else {
	      end = mid - 1;
	    }

		} // end while

		start = 0;
		end = A.length;

		while (start <= end) {

			mid = (start + end) / 2;

			if ((mid == A.length - 1 && A[mid] == x) || (A[mid] == x && A[mid + 1] > x)) {
				start = mid + 1;
				rightIndex = mid;

			}

			else if (A[mid] > x) {

				end = mid - 1;

			}

			else {

				start = mid + 1;

			}

		} // end while

		// Returns the count of elements x in array A[]
		return rightIndex - leftIndex + 1;


	} // end F(count)




	public static void main(String[] args) {
		// test your count() method here

		double[] testarray = {1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0};
		double t1 = 2.1;
		double t2 = 7.5;
		double t3 = 1.3;
		System.out.println(t1+" appears "+ count(testarray, t1) + " times");
		System.out.println(t2+" appears "+ count(testarray, t2) + " times");
		System.out.println(t3+" appears "+ count(testarray, t3) + " times");


	}

}
