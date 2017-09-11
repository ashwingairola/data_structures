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

  public static Node merge(Node node1, Node node2)
  {
    if(node1 == null)
    {
      return node2;
    }

    if(node2 == null)
    {
      return node1;
    }

    if(node1.key < node2.key)
    {
      node1.next = merge(node1.next, node2);
      return node1;
    }
    else
    {
      node2.next = merge(node1, node2.next);
      return node2;
    }
  }
}

public class MergeSortedLinkedLists
{
  public static void main(String[] args)
  {
    MyLinkedList list1 = new MyLinkedList();
    list1.addNode(new Node(5));
    list1.addNode(new Node(7));
    list1.addNode(new Node(9));
    System.out.println("List 1:");
    list1.display();

    MyLinkedList list2 = new MyLinkedList();
    list2.addNode(new Node(4));
    list2.addNode(new Node(6));
    list2.addNode(new Node(8));
    System.out.println("List 2:");
    list2.display();

    Node newStart = MyLinkedList.merge(list1.start, list2.start);
    MyLinkedList list3 = new MyLinkedList();
    list3.start = newStart;
    System.out.println("Merged list:");
    list3.display();
  }
}
