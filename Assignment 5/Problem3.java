/*
Jason Wilson
Thursday, March 5th 2020
CMPT435L 111 20S
*/
public class Problem3 {

	public static void commonelements(double[] s1, double[] s2)
	{

		int i = 0, j = 0;


		// two pointer algorithm
		while (i < s1.length && j < s2.length)
		{
			// if index s1[i] equals index s2[j]
			if (s1[i] == s2[j])
			{

				System.out.print(s1[i] + " ");
				i++;
				j++;

			}
			//s2 is bigger than s1
			else if (s1[i] < s2[j]) {

				i++;
				//s1 is bigger than s2
			} else {

				j++;
			}
		}
	}



	public static void main(String[] args) {
		double[] testarray1 = {0, 0, 0, 1, 2, 3, 97, 98};
		double[] testarray2 = {0, 1, 2, 3, 4, 4, 10, 98, 100, 100};


		System.out.println("Elements that occur in both arrays: ");
		commonelements(testarray1,testarray2);
		//should output 0, 1, 2, 3, 98

	}

}
