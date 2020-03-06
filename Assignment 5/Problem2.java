/*
Jason Wilson
Thursday, March 5th 2020
CMPT435L 111 20S
*/

public class Problem2 {

	public static boolean checksum(double[] s1, double[] s2, double x)
	{
		// complete the checksum() method to find out
		// if there exists a number from s1, and a number from s2
		// such that, their sum is exactly x
		// feel free to change method type and parameters
		// Full credist will awarded to algorithms O(n)

    int start = 0;
    int end = s2.length - 1;
		int arrLen = s2.length;

		 for(int i = 0; i < arrLen; i++) {

		        // If the sum of the elements at indexes s1[start] and s2[end] equal x...
		        if (s1[start] + s2[end] == x) {

							// Return true, soulution exists
		          return true;

		        // If the sum of the numbers is greater than x, decrease the index of the second array
		        } else if (s1[start] + s2[end] > x){

		          end--;

		        // If the sum is less than x, increase the index of the first array
		        } else {

		          start++;

		        }

		 }

		 return false;

	 }



	public static void main(String[] args) {

		double[] testarray1 = {1, 10, 45};
		double[] testarray2 = {-8, 4, 6};
		double target1 = 7;
		double target2 = 70;

		System.out.println("Does there exist a number from testarray1, and a number from testarray2, and their sum is "+ target1 + "?");
		System.out.println(checksum(testarray1,testarray2, target1));
		// should print true

		System.out.println("Does there exist a number from testarray1, and a number from testarray2, and their sum is "+ target2 + "?");
		System.out.println(checksum(testarray1,testarray2, target2));
		// should print false

	}

}
