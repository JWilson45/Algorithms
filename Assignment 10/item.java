/*
Jason Wilson
Thursday, April 30th 2020
CMPT435L 111 20S
*/


public class item {
	public int id;
	public double value;
	public int size;
	public double density;


	public item( int givenid, double givenvalue, int givensize)
	{
		id = givenid;

		size = givensize;

		value = givenvalue;

		density = value/size;
	}

}
