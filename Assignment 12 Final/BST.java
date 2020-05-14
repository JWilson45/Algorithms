/*
Jason Wilson
Algorithm Analysis and Design
Professor Bowu
5/14/2020
*/

import java.util.*;

public class BST implements Iterable
{

   private Node root;
   private Comparator comparator;

   public BST()
   {
      root = null;
      comparator = null;
   }

   public BST(Comparator comp)
   {
      root = null;
      comparator = comp;
   }

   private int compare(int x, int y)
   {
      if(comparator == null)
      {
    	if(x>y)
    		return 1;
  		else if (x==y)
   			return 0;
 		else
    		return -1;
      }
      else
      return comparator.compare(x,y);
   }

/*****************************************************
*
*            INSERT
*
******************************************************/
   public void insert(int data, int score)
   {
      root = insert(root, data, score);
   }
   private Node insert(Node p, int toInsert, int score)
   {
      if (p == null)
         return new Node(toInsert, score);

      if (compare(toInsert, p.data) == 0)
      	return p;

      if (compare(toInsert, p.data) < 0)
         p.left = insert(p.left, toInsert, score);
      else
         p.right = insert(p.right, toInsert, score);

      return p;
   }

/*****************************************************
*
*            SEARCH
*
******************************************************/
   public Node search(int toSearch)
   {
      return search(root, toSearch);
   }
   private Node search(Node p, int toSearch)
   {
      if (p == null)
         return null;
      else
      if (compare(toSearch, p.data) == 0)
      	return p;
      else
      if (compare(toSearch, p.data) < 0)
         return search(p.left, toSearch);
      else
         return search(p.right, toSearch);
   }


/*****************************************************
*
*            AVERAGE
*
******************************************************/
    public double average(int date1, int date2) {
      ArrayList<Integer> arr = getRange(date1, date2);

      double total = 0;

      for (int a: arr) {

        total += search(a).score;

      }

      return total / arr.size();

   }


 /*************************************************
  *
  *            GET RANGE
  *
  **************************************************/

   // Function to get a range of elements from the BST
   public ArrayList getRange(int date1, int date2) {
     // Make sure the range is organized properly
     if (date1 > date2) {
       int tmpDate = date1;
       date1 = date2;
       date2 = tmpDate;
     }

     ArrayList<Integer> rangeArr = new ArrayList<Integer>();

     range(root, date1, date2, rangeArr);

     // Print arraylist rangeArr
     // for (int a : rangeArr) {
     //   System.out.println(a);
     // }

     return rangeArr;
   }

   // Iterate through the BST to find only the elements witnin the range
   public void range(Node root, int startDate, int endDate, ArrayList rangeArr) {
     if (root != null) {

       // if the data of the node is within the search area, add to the array and recurr
       if (root.data >= startDate && root.data <= endDate) {
         range(root.left, startDate, endDate, rangeArr);
         rangeArr.add(root.data);
         range(root.right, startDate, endDate, rangeArr);
       }

       // else if outside the range..
       else if (root.data < startDate) {
         //recurr right
         range(root.right, startDate, endDate, rangeArr);
       }
       else {
         //recurr left
         range(root.left, startDate, endDate, rangeArr);
       }
     }
   }


/*****************************************************
*
*            DELETE
*
******************************************************/

   public void delete(int toDelete)
   {
      root = delete(root, toDelete);
   }
   private Node delete(Node p, int toDelete)
   {
      if (p == null)  throw new RuntimeException("cannot delete.");
      else
      if (compare(toDelete, p.data) < 0)
      p.left = delete (p.left, toDelete);
      else
      if (compare(toDelete, p.data)  > 0)
      p.right = delete (p.right, toDelete);
      else
      {
         if (p.left == null) return p.right;
         else
         if (p.right == null) return p.left;
         else
         {
         // get data from the rightmost node in the left subtree
            p.data = retrieveData(p.left);
         // delete the rightmost node in the left subtree
            p.left =  delete(p.left, p.data) ;
         }
      }
      return p;
   }
   private int retrieveData(Node p)
   {
      while (p.right != null) p = p.right;

      return p.data;
   }

   // Function to gather a range of elements and delete them by accessing the
   // delete function
   public void rangeDelete(int start, int end) {
     ArrayList<Integer> rangeToDelete = getRange(start, end);

     for (int n: rangeToDelete) {
       delete(n);
     }
   }


/*************************************************
 *
 *            TRAVERSAL
 *
 **************************************************/

   public void preOrderTraversal()
   {
      preOrderHelper(root);
   }
   private void preOrderHelper(Node r)
   {
      if (r != null)
      {
         System.out.print(r.data+" ");
         preOrderHelper(r.left);
         preOrderHelper(r.right);
      }
   }

   public void inOrderTraversal()
   {
      inOrderHelper(root);
   }
   private void inOrderHelper(Node r)
   {
      if (r != null)
      {
         inOrderHelper(r.left);
         System.out.print(r.data+" ");
         inOrderHelper(r.right);
      }
   }


/*****************************************************
*
*            TREE ITERATOR
*
******************************************************/

   public Iterator iterator()
   {
      return new MyIterator();
   }
   //pre-order
   private class MyIterator implements Iterator
   {
      Stack<Node> stk = new Stack<Node>();

      public MyIterator()
      {
         if(root != null) stk.push(root);
      }
      public boolean hasNext()
      {
         return !stk.isEmpty();
      }

      public Integer next()
      {
         Node cur = stk.peek();
         if(cur.left != null)
         {
            stk.push(cur.left);
         }
         else
         {
            Node tmp = stk.pop();
            while( tmp.right == null )
            {
               if(stk.isEmpty())
            	   return cur.data;
               tmp = stk.pop();
            }
            stk.push(tmp.right);
         }

         return cur.data;
      }//end of next()

      public void remove()
      {

      }
   }//end of MyIterator


/*****************************************************
*
*            the Node class
*
******************************************************/

   private class Node
   {
      private int data;
      private Node left, right;
      private int score;

      public Node(int data, Node l, Node r, int score)
      {
         left = l; right = r;
         this.data = data;
         this.score = score;
      }

      public Node(int data, int score)
      {
         this(data, null, null, score);
      }


   } //end of Node



   // def of global variable for keeping track of index
   static int index;


   public static void main(String[] args)
   {
      int[] dates = {20200116,20200117,20200217,20200219,20200319, 20200310};
      int[] scores = {88, 66, 55, 44, 33, 22};
      BST bst = new BST();
      for (int i = 0; i < dates.length; i++) {
        bst.insert(dates[i], scores[i]);
      }
      bst.inOrderTraversal();
      System.out.println();

      System.out.println("The average between scores from dates 20200117 and 20200219 is : " + bst.average(20200117, 20200219));
      //average between scores 66  55  44 = 55

      System.out.println("Deleting scores between 20200218 and 20200311...");
      bst.rangeDelete(20200218, 20200311);

      System.out.print("New binary tree: ");
      bst.inOrderTraversal();
      System.out.println();

   }

}//end of BST
