// Delete alternate nodes of a Linked List
// Given a Singly Linked List, starting from the second node delete all alternate nodes of it.
// For example, if the given linked list is 1->2->3->4->5 then your function should convert it to 1->3->5,
// and if the given linked list is 1->2->3->4 then convert it to 1->3.
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
  // Instance variable to count if the last occurence has been found.
  private int lastOccurenceCount;

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

  // Method to delete alternate elements.
  public void deleteAlternate()
  {
    if(start == null || start.next == null)
    {
      return;
    }

    Node prev = start, current = start.next;
    while(current != null && current.next != null)
    {
      Node node = current;
      current = current.next.next;
      prev.next = node.next;
      node.next = null;
      prev = prev.next;
    }

    if(prev.next != null)
    {
      prev.next = current.next;
    }
  }
}

public class DeleteAlternate
{
  public static void main(String[] args)
  {
    // List containing odd elements
    MyLinkedList list1 = new MyLinkedList();
    list1.addNode(new Node(1));
    list1.addNode(new Node(2));
    list1.addNode(new Node(3));
    list1.addNode(new Node(4));
    list1.addNode(new Node(5));
    System.out.println("Original list 1:");
    list1.display();
    list1.deleteAlternate();
    System.out.println("List 1 after alternate deletion:");
    list1.display();
    System.out.println("");

    // List containing even elements
    MyLinkedList list2 = new MyLinkedList();
    list2.addNode(new Node(1));
    list2.addNode(new Node(2));
    list2.addNode(new Node(3));
    list2.addNode(new Node(4));
    System.out.println("Original list 2:");
    list2.display();
    list2.deleteAlternate();
    System.out.println("List 2 after alternate deletion:");
    list2.display();
  }
}
