/*
Jason Wilson
Thursday, February 6th 2020
CMPT435L 111 20S
*/

public class Problem1 {

	public static int reverse(int x)
	{
		/*Given a 32-bit signed integer x, reverse digits of x.
		Example 1:
		Input: 123
		Output: 321
		Example 2:
		Input: -123
		Output: -321
		Example 3:
		Input: 120
		Output: 21
		*/

		int sigFig;								// variable for holding the extracted significant figure
		int reversed = 0;					// Result variable, will be returned with reversed int
		boolean negative = false;	// negative flag


		if (x < 0) {							// if input x is smaller than 0
			negative = true;				// set the negative flag to true
			x *= -1;								// and make x positive
		}

		while (x > 0) {						// while input x is greater than 0

			sigFig = x % 10;				// extract the significant figure
			x = x / 10;							// remove the significant figure from x
			reversed = (reversed * 10) + sigFig;	//build the reversed number

		}

		if (negative) {						// if the number was origionally negative
      reversed *= -1;					// change the number back to negative
		}

		return reversed;




	}



	public static void main(String[] args) {

		int test1 = 123;
		int test2 = -95;
		int test3 = 890;


		System.out.println("Input :" + test1 + " Output: " + reverse(test1));
		System.out.println("Input :" + test2 + " Output: " + reverse(test2));
		System.out.println("Input :" + test3 + " Output: " + reverse(test3));



	}
}
