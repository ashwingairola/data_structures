import java.util.Scanner;

class Node
{
  int key;
  Node next;

  public Node(int key)
  {
    this.key = key;
  }
}

class MyLinkedList
{
  private Node start = null;

  public void addNode(Node node)
  {
    if(start == null)
    {
      start = node;
    }
    else
    {
      Node current = start;
      while(current.next != null)
      {
        current = current.next;
      }
      current.next = node;
      node.next = null;
    }
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
  /*
  Method: Use two pointers
  1. Maintain two pointers – reference pointer and main pointer.
  2. Initialize both reference and main pointers to head.
  3. First move reference pointer to n nodes from head.
  4. Now move both pointers one by one until reference pointer reaches end.
  5. Now main pointer will point to nth node from the end.
  6. Return main pointer.
  */
  public Node getNthFromLast(int n)
  {
    Node referencePointer = start, mainPointer = start;
    int count = 0;
    while(count < n)
    {
      if(referencePointer == null)
      {
        return null;
      }
      referencePointer = referencePointer.next;
      count++;
    }

    while(referencePointer != null)
    {
      referencePointer = referencePointer.next;
      mainPointer = mainPointer.next;
    }
    return mainPointer;
  }
}

public class NthElementFromLast
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    MyLinkedList list = new MyLinkedList();
    list.addNode(new Node(1));
    list.addNode(new Node(2));
    list.addNode(new Node(3));
    list.addNode(new Node(4));
    list.addNode(new Node(5));
    System.out.println("The list is:");
    list.display();
    System.out.print("Find which nth element from the end: ");
    int nthFromEnd = sc.nextInt();
    Node nthNodeFromEnd = list.getNthFromLast(nthFromEnd);
    if(nthNodeFromEnd != null)
    {
      System.out.println("The nth element from last is: " + list.getNthFromLast(nthFromEnd).key);
    }
    else
    {
      System.out.println("Index out of bounds.");
    }
  }
}
