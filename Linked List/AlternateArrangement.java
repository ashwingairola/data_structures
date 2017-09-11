// Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
// Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
/*
Algorithm:
1) Find the middle point using tortoise and hare method.
2) Split the linked list in two halves using found middle point in step 1.
3) Reverse the second half.
4) Do alternate merge of first and second halves.
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

  // 1) Find the middle point using tortoise and hare method.
  // 2) Split the linked list in two halves using found middle point in step 1.
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

  // 3) Reverse the second half.
  private void reverse(Node node, Node prev)
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

  // 4) Do alternate merge of first and second halves.
  public static Node alternateMerge(Node node1, Node node2)
  {
    if(node1 == null)
    {
      return node2;
    }

    if(node2 == null)
    {
      return node1;
    }

    if(node1.next != null && node2.next != null)
    {
      node1.next = alternateMerge(node1.next, node2.next);
    }
    node2.next = node1.next;
    node1.next = node2;
    return node1;
  }
}

public class AlternateArrangement
{
  public static void main(String[] args)
  {
    MyLinkedList list1 = new MyLinkedList();
    list1.addNode(new Node(1));
    list1.addNode(new Node(2));
    list1.addNode(new Node(3));
    list1.addNode(new Node(4));
    System.out.println("Original list:");
    list1.display();

    MyLinkedList list2 = new MyLinkedList();
    list2.start = list1.split();
    list2.reverse();
    list2.display();
    list1.start = MyLinkedList.alternateMerge(list1.start, list2.start);
    list1.display();
  }
}
