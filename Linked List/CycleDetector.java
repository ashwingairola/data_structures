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
  public Node start = null;

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
  Floyd’s Cycle-Finding Algorithm (aka Floyd's Tortoise and Hare Algorithm):
  1. This is the fastest method.
  2. Traverse linked list using two pointers.
  3. Move one pointer by one and other pointer by two.
  4. If these pointers meet at some node then there is a loop.
  5. If pointers do not meet then linked list doesn’t have loop.
  */
  public boolean containsCycle()
  {
    Node tortoise = start, hare = start;
    while(tortoise != null && hare != null && hare.next != null)
    {
      hare = hare.next.next;
      tortoise = tortoise.next;
      if(hare == tortoise)
      {
        return true;
      }
    }
    return false;
  }
}

public class CycleDetector
{
  public static void main(String[] args)
  {
    MyLinkedList list = new MyLinkedList();
    list.addNode(new Node(1));
    list.addNode(new Node(2));
    list.addNode(new Node(3));
    list.addNode(new Node(4));
    list.addNode(new Node(5));
    list.start.next.next.next.next.next = list.start; // Making a cycle
    if(list.containsCycle())
    {
      System.out.println("This list has a cycle.");
    }
    else
    {
      System.out.println("No cycle detected.");
    }
  }
}
