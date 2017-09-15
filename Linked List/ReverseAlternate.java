/*
Reverse alternate K nodes in a Singly Linked List
Given a linked list,
write a function to reverse every alternate k nodes (where k is an input to the function)
in an efficient way.

Example:
Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
Output:   3->2->1->4->5->6->9->8->7->NULL.
*/
/*
Algorithm:
1. Reverse the linked list till count reaches k.
2. Align the pointers correctly (use false current and previous pointers to save the locations).
3. Iterate through the next k just updating the current and prev pointers.
4. Recursive call to reverseAlternate(current, prev, key).
*/
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
    if(start == null)
    {
      System.out.println("List empty.");
      return;
    }

    Node current = start;
    while(current != null)
    {
      System.out.print(current.key + " ");
      current = current.next;
    }
    System.out.println("");
  }

  public void reverseAlternate(int k)
  {
    reverseAlternate(start, null, k);
  }

  // Method to alternately reverse a linked list.
  private void reverseAlternate(Node current, Node prev, int k)
  {
    if(current == null)
    {
      return;
    }

    Node next = null, falseStart = current, falsePrev = prev;
    int count = 0;
    while(current != null && count < k)
    {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      ++count;
    }

    falseStart.next = next;
    if(falsePrev == null)
    {
      start = prev;
    }
    else
    {
      falsePrev.next = prev;
    }

    count = 0;
    while(current != null && count < k)
    {
      prev = current;
      current = current.next;
      ++count;
    }

    reverseAlternate(current, prev, k);
  }
}

public class ReverseAlternate
{
  public static void main(String[] args)
  {
    MyLinkedList list = new MyLinkedList();
    list.addNode(new Node(1));
    list.addNode(new Node(2));
    list.addNode(new Node(3));
    list.addNode(new Node(4));
    list.addNode(new Node(5));
    list.addNode(new Node(6));
    list.addNode(new Node(7));
    list.addNode(new Node(8));
    list.addNode(new Node(9));
    System.out.println("Original list:");
    list.display();
    list.reverseAlternate(3);
    System.out.println("List after alternate reversal:");
    list.display();
  }
}
