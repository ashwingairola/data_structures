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

public class SwapNodes
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

  public void swap(int key1, int key2)
  {
    Node current = start, prev, x1, x2, prev1, prev2;
    prev = x1 = x2 = prev1 = prev2 = null;
    while(current != null)
    {
      if(key1 == current.key)
      {
        x1 = current;
        prev1 = prev;
      }

      if(key2 == current.key)
      {
        x2 = current;
        prev2 = prev;
      }

      if(x1 != null && x2 != null)
      {
        break;
      }

      prev = current;
      current = current.next;
    }

    if(x1 == null || x2 == null)
    {
      System.out.println("Swap impossible");
    }
    else
    {
      if(prev1 != null)
      {
        prev1.next = x2;
      }
      else
      {
        start = x2;
      }

      if(prev2 != null)
      {
        prev2.next = x1;
      }
      else
      {
        start = x1;
      }

      Node temp = x1.next;
      x1.next = x2.next;
      x2.next = temp;
    }
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    SwapNodes list = new SwapNodes();
    list.addNode(new Node(1));
    list.addNode(new Node(2));
    list.addNode(new Node(3));
    list.addNode(new Node(4));
    list.addNode(new Node(5));
    list.addNode(new Node(6));
    System.out.println("Original list:");
    list.display();
    System.out.println("Enter 2 keys to swap:");
    int key1 = sc.nextInt(), key2 = sc.nextInt();
    list.swap(key1, key2);
    System.out.println("The list after swapping is:");
    list.display();
  }
}
