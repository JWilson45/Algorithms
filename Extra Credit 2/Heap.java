/*
Jason Wilson
Thursday, April 16th 2020
CMPT435L 111 20S
*/

import java.io.*;

public class Heap {

	public int[] heap; // array heap used as a Heap

	public int n; // number of nodes

	public Heap(int givenarray[]) throws IOException // constructor
	{
		heap = new int[givenarray.length]; // allocate array heap
		System.arraycopy(givenarray, 0, heap, 0, givenarray.length);
		// initialize array heap from input parameter
		// create a Heap from unordered array

		n = heap.length; // get the number of nodes

		for (int i = n / 2 - 1; i >= 0; i--) // from n/2 downto 1
		{
			Heapify(i); // call Heapify method

		} // end for

	}// end constructor

	// ------------------------------------------------------------------------
	public void Heapify(int i) // utility routine to percolate down from index i
	{
		int left, r, min, tmp; // declare variables

		left = 2 * i + 1; // left child
		r = 2 * i + 2; // right child
		// left child of heap[i] stored at heap[2i+1]
		// right child of heap[i] stored at heap[2i+2]

		if (left < n && heap[left] < heap[i]) // find smallest child
			min = left; // save index of smaller child
		else
			min = i;

		if (r < n && heap[r] < heap[min])
			min = r; // save index of smaller child

		if (min != i) // swap and percolate, if necessary
		{
			tmp = heap[i]; // exchange values at two indices
			heap[i] = heap[min];
			heap[min] = tmp;
			Heapify(min); // call Heapify

		} // end if

	}// end method Heapify

	// ------------------------------------------------------------------------
	public void Insert(int key) // insert new node with key value = key
	{ // Parent of node i is at node i/2 ... assume i/2 = floor(i/2)

		int i; // declare variables

		n++; // increment # nodes
		i = n - 1;

		while (i > 0 && heap[(i - 1) / 2] > key) // percolate up
		{
			heap[i] = heap[(i - 1) / 2];
			i = (i - 1) / 2;

		} // end while

		heap[i] = key; // set heap[i] equal to key

	}// end method Insert()

	// ------------------------------------------------------------------------
	public int Delete_root() // remove node with minimum value
	{
		int min; // declare variables

		if (n < 1) // if n is less than 1
		{
			System.out.println("error"); // display error
			return -1; // return -1
		} else {
			min = heap[0];
			heap[0] = heap[n - 1]; // replace root with last element in Heap
			n--; // reduce Heap size
			Heapify(0); // percolate new root downwards
			return min; // return min

		} // end if

	}// end method Delete_root()

	// ------------------------------------------------------------------------
	public int Empty() // return if Heap is empty or not
	{
		if (n == 0) // if it's empty
			return 1;
		else
			return 0; // not empty

	}// end method Update()
	// ------------------------------------------------------------------------

	public void Heapsort(int givenarray[]) // sort the heap
	{
		heap = new int[givenarray.length];
		System.arraycopy(givenarray, 0, heap, 0, givenarray.length);

		n = heap.length;

		for (int i = n / 2 - 1; i >= 0; i--)
		{
			Heapify(i);
		} // end for


	}// end method Heapsort()

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int examplearray[] = {1,3,6,5,9,8};

		Heap A = new Heap(examplearray);

		A.Heapsort(examplearray);

		for(int i = 0; i < examplearray.length; i++) {
				System.out.println(A.heap[i]);
		}
		//complete the method to sort the given heap
	}

}// end Heap class
