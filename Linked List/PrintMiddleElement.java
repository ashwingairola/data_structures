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

  public Node findMiddle()
  {
    Node fastPointer = start, slowPointer = start;
    while(fastPointer != null && fastPointer.next != null)
    {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;
    }
    return slowPointer;
  }
}

public class PrintMiddleElement
{
  public static void main(String[] args)
  {
    MyLinkedList list = new MyLinkedList();
    list.addNode(new Node(1));
    list.addNode(new Node(2));
    list.addNode(new Node(3));
    list.addNode(new Node(4));
    list.addNode(new Node(5));
    System.out.println("The list is:");
    list.display();
    System.out.println("The middle element is: " + list.findMiddle().key);
  }
}
