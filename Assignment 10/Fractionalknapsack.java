/*
Jason Wilson
Thursday, April 30th 2020
CMPT435L 111 20S
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Fractionalknapsack {



public static void sortitems(ArrayList<item> svd)
{
	// Sort items by density in descending order

	Collections.sort(svd, new Comparator<item>(){
		public int compare(item o1, item o2){
				if(o1.density == o2.density)
							return 0;
									return o1.density > o2.density ? -1 : 1;
																								}
																});


}

public static double greedyfractionalknapsack(ArrayList<item> svd, int S){

	int value = 0;

	// Iterate throught the array adding items until the "bag" is full
	for(int i = 0; i< svd.size(); i++){

		// if the bag is full, return the value
		if (S == 0) {
			return value;
		}

		// The the value of Item i can fit in the "bag"...
		if(svd.get(i).size <= S){

			// set value with the new item i value places in the "bag"
			value += svd.get(i).value;

			// Adjust the remaining size of the "bag"
			S -= svd.get(i).size;

			// Else, the item i cannot fit into the "bag"...
		} else {

			// divide the item i into the fraction that will fit into the bag, making
			// S = 0 / the "bag" becomes full
			double fracItem = ((double)(S)/(double)(svd.get(i).size)) * svd.get(i).value;

			double fracSize = ((double)(S)/(double)(svd.get(i).size)) * svd.get(i).size;

			// S = 0 because the item did not fit and needs to fill the remaining
			// portion of the bag
			S -= fracSize;

			// Set the value based on the fraction of the item taken
			value += fracItem;

		}

	}
	return value;

}




public static void main(String[] args) {
								int max_size,n;

								ArrayList<item> items=new ArrayList();
								// item 1, value 6, size 1
								items.add(new item(1, 6, 1));
								// item 2, value 10, size 2
								items.add(new item(2, 10, 2));
								// item 3, value 12, size 3
								items.add(new item(3, 12, 3));
								// the size of your knapsack
								max_size=5;
								// sort items by density
								sortitems(items);

								System.out.println("The maximum value we can place into the knapsack is "+ greedyfractionalknapsack(items, max_size));



}


}
