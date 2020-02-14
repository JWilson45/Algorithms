/*
Jason Wilson
Thursday, February 13th 2020
CMPT435L 111 20S
*/

public class Problem6 {

  public static int squareroot(int x)
	{
		// given a positive integer x, return square root of x
		// if x is not a perfect square, return the floor of its square root
		// complete the method squareroot() here
		// O(log n) expected

    int start = 1;
    int end = x;
    int mid = 0;
    int midSquare;
    int result = 0;

    while (start <= end) {

      mid = start + (end - start) / 2;  // Formula to find the midpoint
      midSquare = mid * mid;            // Square the midpoint

      // Best case, will return mid as answer if x is a prefect square
      if (midSquare == x) {

        return mid;

        // If the midpoint squared is greater than x,
        // discard the right half of the search area.
      } else if (midSquare > x) {

        end = mid - 1;

        // else, discard the left half of the search area
      } else {

        start = mid + 1;
        result = mid;


      }
    }

    return result;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here

		int x1 = 9;
		int x2 = 5;
		int x3 = 17;
		System.out.println("The square root of " + x1 + " is " + squareroot(x1));
		System.out.println("The square root of " + x2 + " is " + squareroot(x2));
		System.out.println("The square root of " + x3 + " is " + squareroot(x3));


	}

}
