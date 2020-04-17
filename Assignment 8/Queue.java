/*
Jason Wilson
Thursday, April 16th 2020
CMPT435L 111 20S
*/

import java.util.LinkedList;

class Queue {

	private LinkedList queuelist;


	public Queue() {
		queuelist = new LinkedList<Integer>();

	}

	public void insert(int j) {//enqueue

		queuelist.add(j);
	}

	public int remove() {//dequeue
		return (int)queuelist.remove();

	}

	public boolean isEmpty() {

		return queuelist.isEmpty();

	}
}
