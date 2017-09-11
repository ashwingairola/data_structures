// Program to reverse a linked list.
class Node
{
  int data;
  Node next;

  Node(int data)
  {
    this.data = data;
  }
}

public class ReverseLinkedList
{
  public Node start = null, start1 = start;

  public void addAtEnd(Node node)
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
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println("");
  }

  private void reverse(Node node, Node prev)
  {
    if(node == null)
    {
      System.out.println("List empty! Nothing to reverse.");
      return;
    }

    if(node.next != null)
    {
      reverse(node.next, node);
    }

    if(node == start)
    {
      node.next = null;
      start = start1;
    }
    else
    {
      if(node.next == null)
      {
        start1 = node;
      }
      node.next = prev;
    }
  }

  public void reverse()
  {
    reverse(start, null);
  }

  public static void main(String[] args)
  {
    ReverseLinkedList list = new ReverseLinkedList();
    list.addAtEnd(new Node(1));
    list.addAtEnd(new Node(2));
    list.addAtEnd(new Node(3));
    list.addAtEnd(new Node(4));
    list.display();
    list.reverse();
    list.display();
  }
}
