// Given a singly linked list of characters, write a function that returns true if the given list is palindrome, else false.
/*
Algorithm:
1. Find the median of the linked list.
2. Divide the list in two using the median.
3. Reverse the second half obtained after splitting.
4. Compare each character sequentially.
*/
class Node
{
  char key;
  Node next;

  public Node(char key)
  {
    this.key = key;
  }
}

class MyLinkedList
{
  public Node start = null, start1 = null;

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

  // 1. Find the median of the linked list.
  // 2. Divide the list in two using the median.
  public Node split()
  {
    Node fast = start, slow = start, prev = start;
    while(fast != null && fast.next != null)
    {
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;
    }
    prev.next = null;
    return slow;
  }

  // 3. Reverse the second half obtained after splitting.
  public void reverse(Node node, Node prev)
  {
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
    this.reverse(this.start, null);
  }

  // 4. Compare each character sequentially.
  public boolean isPalindrome()
  {
    MyLinkedList list2 = new MyLinkedList();
    list2.start = this.split();
    list2.reverse();
    Node node1 = this.start, node2 = list2.start;
    int count = 0;
    while(node1.next != null && node2.next != null)
    {
      if(node1.key != node2.key)
      {
        ++count;
      }
      node1 = node1.next;
      node2 = node2.next;
    }
    if(count > 0)
      return false;
    else
      return true;
  }
}

public class PalindromeList
{
  public static void main(String[] args)
  {
    MyLinkedList list = new MyLinkedList();
    list.addNode(new Node('R'));
    list.addNode(new Node('A'));
    list.addNode(new Node('D'));
    list.addNode(new Node('A'));
    list.addNode(new Node('R'));
    System.out.println("The list is:");
    list.display();
    boolean flag = list.isPalindrome();
    if(flag == true)
      System.out.println("The list is palindrome.");
    else
      System.out.println("The list is not palindrome.");
  }
}
