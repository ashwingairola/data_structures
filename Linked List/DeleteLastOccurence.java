// Delete last occurrence of an item from linked list
// Given a liked list and a key to be deleted.
// Delete last occurrence of key from linked.
// The list may have duplicates.
//
// Example:
// Input:   1->2->3->5->2->10, key = 2
// Output:  1->2->3->5->10
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

  public void deleteLastOccurenceOf(int key)
  {
    deleteLastOccurenceOf(start, null, key);
    // Reset the counter flag for the next deletion
    lastOccurenceCount = 0;
  }

  private void deleteLastOccurenceOf(Node current, Node prev, int key)
  {
    // If the current node is null (list empty or the last node), return
    if(current == null)
    {
      return;
    }

    // Recursively traverse to the last node.
    if(current != null)
    {
      deleteLastOccurenceOf(current.next, current, key);
    }

    // If the last occurence of the key is found
    if(current.key == key && lastOccurenceCount == 0)
    {
      // If the current node is start
      if(prev == null)
      {
        start = current.next;
      }
      else
      {
        prev.next = current.next;
      }
      // Delete the last occurence
      current.next = null;
      // Make sure the deletion occurs only once.
      ++lastOccurenceCount;
    }
  }
}

public class DeleteLastOccurence
{
  public static void main(String[] args)
  {
    MyLinkedList list = new MyLinkedList();
    list.addNode(new Node(1));
    list.addNode(new Node(2));
    list.addNode(new Node(3));
    list.addNode(new Node(5));
    list.addNode(new Node(2));
    list.addNode(new Node(10));
    System.out.println("Original List:");
    list.display();
    list.deleteLastOccurenceOf(2);
    System.out.println("List after deleting last occurence of 2:");
    list.display();
  }
}
