/* Union and Intersection of two Linked Lists
Given two Linked Lists, create union and intersection lists that contain union and intersection of the elements present in the given lists.
Order of elments in output lists doesn’t matter.

Example:

Input:
   List1: 10->15->4->20
   lsit2:  8->4->2->10
Output:
   Intersection List: 4->10
   Union List: 2->8->20->4->15->10
*/
import java.util.HashSet;

class Node
{
  int key;
  Node next;

  public Node() {}

  public Node(int key)
  {
    this.key = key;
  }
}

class MyLinkedList
{
  private Node start;

  public Node getStart()
  {
    return start;
  }

  public void addNode(Node node)
  {
    if(start == null)
    {
      start = node;
      return;
    }

    Node current = start;
    while(current.next != null)
    {
      current = current.next;
    }
    current.next = node;
  }

  public void display()
  {
    Node current = start;
    while(current != null)
    {
      System.out.print(current.key + " ");
      current = current.next;
    }
    System.out.println("");
  }
}

public class UnionIntersectionLinkedList
{
  public static void main(String[] args)
  {
    MyLinkedList list1 = new MyLinkedList();
    list1.addNode(new Node(10));
    list1.addNode(new Node(15));
    list1.addNode(new Node(4));
    list1.addNode(new Node(20));
    list1.display();

    MyLinkedList list2 = new MyLinkedList();
    list2.addNode(new Node(8));
    list2.addNode(new Node(4));
    list2.addNode(new Node(2));
    list2.addNode(new Node(10));
    list2.display();

    MyLinkedList result = getIntersection(list1, list2);
    if(result == null)
      System.out.println("No intersection.");
    else
    {
      System.out.println("Intersection:");
      result.display();
    }

    result = getUnion(list1, list2);
    if(result == null)
      System.out.println("No union.");
    else
    {
      System.out.println("Union:");
      result.display();
    }
  }

  // Method to obtain the intersection of two linked lists.
  public static MyLinkedList getIntersection(MyLinkedList list1, MyLinkedList list2)
  {
    HashSet<Integer> set = new HashSet<>();
    Node temp = list1.getStart();
    while(temp != null)
    {
      set.add(temp.key);
      temp = temp.next;
    }

    temp = list2.getStart();
    MyLinkedList intersection = (temp == null) ? null : new MyLinkedList();

    while(temp != null)
    {
      if(set.contains(temp.key))
      {
        Node temp1 = new Node();
        temp1.key = temp.key;
        intersection.addNode(temp1);
      }
      temp = temp.next;
    }
    return intersection;
  }

  // Method to obtain the union of two linked lists.
  public static MyLinkedList getUnion(MyLinkedList list1, MyLinkedList list2)
  {
    HashSet<Integer> set = new HashSet<>();

    Node temp = list1.getStart();
    while(temp != null)
    {
      set.add(temp.key);
      temp = temp.next;
    }

    temp = list2.getStart();
    while(temp != null)
    {
      set.add(temp.key);
      temp = temp.next;
    }

    MyLinkedList union = new MyLinkedList();
    for(int key : set)
    {
      union.addNode(new Node(key));
    }

    return union;
  }
}
