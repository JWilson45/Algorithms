/*
Jason Wilson
Thursday, May 7th 2020
CMPT435L 111 20S
*/

public class SubsetSumDP {

	public static boolean subsetSum(int[] A, int x) {

		int aSize = A.length + 1;
		int sumSize = x + 1;
		boolean[][] Sum = new boolean[aSize][sumSize];

		// Set the frist coulmn to True
		for(int i = 0; i < aSize; i++) {
			Sum[i][0] = true;
		}

		// Set the first row excluding [0][0] to False
		for(int j = 1; j < sumSize; j++) {
			Sum[0][j] = false;
		}

		// Complete the rest of the table for refrence
		for(int i = 1; i < aSize; i++) {
			for(int j = 1; j < sumSize; j++) {

				Sum[i][j] = A[i-1] > j ? Sum[i-1][j] : Sum[i-1][j]||Sum[i-1][j-A[i-1]];

			}
		}


		// Code that will print out the T/F table
		/*
		System.out.print("   ");
		for (int i = 0;i < x + 1; i++) {
			System.out.print(i + " ");
		}

		System.out.println();

		System.out.println(" ---------------------");

		System.out.print("0| ");

		for (int i = 0; i < A.length + 1; i++) {
			for (int j = 0; j < x + 1; j++) {
				System.out.print((Sum[i][j] ? "T" : "F") + " ");
			}
			System.out.println();
			System.out.print(i + 1 + "| ");
		}
		*/

		return Sum[A.length][x];
}

	public static void main(String[] args) {

		int[] A = {1, 3, 5, 2, 8};


		int x = 9;

		System.out.println("There exists a subset in A[] with sum = " + x + " : " + subsetSum(A, x) );
		// Expected output: true
	}

}
