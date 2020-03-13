/*
Jason Wilson
Thursday, March 12th 2020
CMPT435L 111 20S
*/

public class LinkedList {

    // The LinkedList Node class
    private class Node {

        int data;
        Node next;

        Node(int gdata) {
            this.data = gdata;
            this.next = null;
        }

        Node sortLinkedList(Node h) {

            // Base Case
            if (h == null || h.next == null) { // If the head of the node is null...

                return h; // return

            }

            // get list mid and set next mid to null
            Node mid = returnMid(h);
            Node nextmid = mid.next;
            mid.next = null;

            // Apply sortLinkedList on left and right half of list
            Node leftLink = sortLinkedList(h);
            Node rightLink = sortLinkedList(nextmid);

            // Merge leftLink and rightLink
            Node sorted = merge(leftLink, rightLink);

            // OUTPUT sorted list
            return sorted;

        }

        Node merge(Node a, Node b) {

            Node output = null;

            if (a == null) { // Base case 1
                return b;
            }
            if (b == null) {  // Base case 2
                return a;
            }

            // if a.data <= b.data then set output to the greater value
            // and run invoke merge
            if (a.data <= b.data) {
                output = a;
                output.next = merge(a.next, b);
            } else {
                output = b;
                output.next = merge(a, b.next);
            }

            // Output merge
            return output;

        }

    }

    // The LinkedList fields
    Node head;

    // Constructor
    LinkedList(int gdata) {
        this.head = new Node(gdata);
    }

    public void Insertend(int gdata) {
        Node current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        Node newnode = new Node(gdata);
        current.next = newnode;

    }

    public void Listprint() {
        Node current = this.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();

    }

    // Return mid function
    public static Node returnMid(Node head) {

        if (head == null) {
            return head;
        }

        Node s1 = head;
        Node s2 = head;

        // Search for the mid point
        while (s2.next != null && s2.next.next != null) {

            s1 = s1.next;
            s2 = s2.next.next;

        }

        // return s1
        return s1;
    }

    public void Listsort(Node start) {
        // Complete this method to sort a Linked list
        // Return the first node in the sorted list
        // Feel free to change the method type, add/remove parameters
        // Full credit (30 points) will be awarded for an algorithm that is O(nlog n).
        // Algorithms that are O(n^2) slower will be scored out of 10 points.

        start = start.sortLinkedList(start);

    }

    public static void main(String[] args) {

        LinkedList exlist = new LinkedList(0);
        exlist.Insertend(1);
        exlist.Insertend(5);
        exlist.Insertend(2);
        exlist.Insertend(7);
        exlist.Insertend(10);
        exlist.Insertend(3);

        exlist.Listprint();
        // output: 0 1 5 2 7 10 3
        exlist.Listsort(exlist.head);
        exlist.Listprint();
        // output should be: 0 1 2 3 5 7 10

    }

}
