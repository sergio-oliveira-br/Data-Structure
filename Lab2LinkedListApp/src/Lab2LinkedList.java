/*
 * LAB in Class
 * 31th Jan 2024
 * Author Sergio Oliveira
 */


/*
 * In the class we have developed our own List
 * interface and an implementation of that
 * interface using links called LinkedList.
 * The code Listing shows an addition of
 * three methods to the interface,
 * you are tasked to provide an implementation
 * of these three methods in the LinkedList class.
 */

/*
 * All three require you to traverse the list,
 * as we have previously done in the toString() method.
 * The logic is similar in all three,
 * we must find the targeted node and then inset before, or after, or remove.
 * We should throw an exception if the node is not found.
 * Test these methods by adding a removing elements,
 * what happens if we insert after the last node?
 * What if we insert before the first node?
 */

//class definition

//instance variable




//Node class definition
class Node<T>
{
    //instance variables
    T myData;              //list element    *** this going to be the data part
    Node<T> next;          //sucessor link   *** this is our reference to the next Node in the List

    //constructor -> this one has only have the data part and NO reference Node to point to.
    Node(T myData)
    {
        this.myData = myData;
        this.next = null;
    }
}

public class Lab2LinkedList<T>
{
    //variables for head and tail of linkedlist
    private Node<T> first;      //this is the first that I know
    private Node<T> last;       //this is the last that I know

    //building the list
    public Lab2LinkedList()
    {
        //start at null, because I didn't entered any data yet
        first = null;
        last = null;
    }

    //start looking at the method
    public Boolean isEmpty()
    {
        return first == null;
    }

    //to see the size
    public int size()
    {
        int count = 0;
        Node <T> current = first;

        while (current != null)
        {
            //There is an element at current
            count++;
            current = current.next;
        }
        return count;
    }

    //Add an element to the end of the list
    public void add(T elementX)
    {
        //if there are no elements in the list then:
        if (isEmpty())
        {
            first = new Node<>(elementX);
            last = first;
        }

        //if there are elements in the list then:
        else
        {
            last.next = new Node<>(elementX);   //set the last element next pointer to a new node
            last = last.next;                   //and now set the last element to null
        }
    }

    //Add an element at a given index
    public void add(int index, T elementX)
    {
        //this is an exception, if the user try to insert the new element out of the bounds
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();

        //this is to input the element at index 0, if the user pick up the option to insert at index 0
        if(index == 0)
        {
            Node<T> newNode0 = new Node<>(elementX);
            newNode0.next = first;

            first = newNode0;

            //new element goes at beginning
            if (last == null)
            {
                last = newNode0;
            }
            return;
        }

        //set pred to node that will be the predecessor of new node
        Node<T> pred = first;
        for (int k = 1; k < index -1; k++)
        {
            pred = pred.next;
        }

        //splice (connect) in a node containing the new element
        Node<T> newNodeX = new Node<>(elementX);
        newNodeX.next = pred.next;
        pred.next = newNodeX;

        //check if is there new last element
        if(pred.next.next == null)
        {
            last = null;
        }
    }

    //method to traverse through the linked list and return a string that comprises
    //of all the strings contained within the linked list
    public String toString ()
    {
        String str = "";
        Node<T> current = first;

        while (current != null)
        {
            str += " @ " + (current.myData);
            current = current.next;
        }
        return str;
    }

    //Main method for testing
    public static void main(String[] args)
    {
        Lab2LinkedList<String> myListX = new Lab2LinkedList<>();

        //adding elements
        myListX.add("Sergio");
        myListX.add("Vinicio");
        myListX.add("Silva");
        myListX.add("Oliveira");
        myListX.add("Bye Bye");

        //Adding an element by the method
        myListX.add(3, "Djow");
        myListX.add(0, "Hello");

        Node <String> current = myListX.first;
        //Starts at the first node

        //printing the elements
        while (current != null)
        {
            System.out.println(current.myData);
            current = current.next;             //Moving to the next node
        }

        //printing the size
        System.out.println("The size of the list is: " + myListX.size());

        //applying the method toString
        System.out.println("The list using to String: " + myListX.toString());
    }
}
