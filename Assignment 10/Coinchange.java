/*
Jason Wilson
Thursday, April 30th 2020
CMPT435L 111 20S
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coinchange {

	public static int greedycoinchange(int givenvalue, int[] givencoins, int coins)
	{

		// for all of the coins available to use...
		for (int i = 0; i < givencoins.length; i++) {

			// While the current coin (givencoin[i]) can fit within the given value...
			while ((givenvalue - givencoins[i]) >= 0) {

				// Adjust the total based on the value of the coin taken and incriment the counter
				givenvalue = givenvalue - givencoins[i];

				coins++;

			}

		}

		// Return amt of coins required
		return coins;

	}

	public static void main(String[] args)
	{
		int n = 0; // To make a change of n cents

		Scanner reader = new Scanner(System.in);

		System.out.println("Please enter the value you want to make change: ");

		n = reader.nextInt();

		// Infinite supply of quarters, dimes, nickles, and pennies
		int[] coins = {25, 10, 5, 1}; //Sorted already


		System.out.println("The greedycoinchange algorithm uses "+ greedycoinchange(n, coins, 0)+" coins for "+ n + " cents");
	}

}
