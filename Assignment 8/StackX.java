/*
Jason Wilson
Thursday, April 16th 2020
CMPT435L 111 20S
*/

public class StackX {
	private final int SIZE = 20;
	private int[] st;
	private int top;

	public StackX() {
		st = new int[SIZE];
		top = -1;
	}

	public void push(int j) {
		st[++top] = j;
	}

	public int pop() {
        if (top == 0) {
            top = -1;
            return -1;
        }
        return st[--top];
    }

	public int peek() {
		return st[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}
