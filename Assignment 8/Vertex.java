/*
Jason Wilson
Thursday, April 16th 2020
CMPT435L 111 20S
*/

public class Vertex {
	public char lable;// node label, i.e., node "A", "B", or, "0", "1"
	public boolean wasVisited;
	public int cycleflag;

	public Vertex(char givenlable) {
		lable = givenlable;
		wasVisited = false;
		cycleflag = -1;
	}
}
