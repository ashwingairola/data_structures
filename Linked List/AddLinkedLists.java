/*
Add two numbers represented by linked lists:
Given two numbers represented by two linked lists,
write a function that returns sum list.
The sum list is linked list representation of addition of two input numbers.
It is not allowed to modify the lists.
Also, not allowed to use explicit extra space (Hint: Use Recursion).

Example
Input:
  First List: 5->6->3  // represents number 563
  Second List: 8->4->2 //  represents number 842
Output
  Resultant list: 1->4->0->5  // represents number 1405
*/
/*
Algorithm:
1.  Send the two lists to addLists(list1, list2).
2.  Compare their lengths. Add a padding of nodes with key=0 to the shorter list,
    till both their lengths are equal. Eg.,
    list1: 1->4->5->3, list2: 5->6->3. After adjustLength(shorterList, count, maxCount):
    list1: 1->4->5->3, list2: 0->5->6->3.
3.  Now call the overloaded addLists(node1, node2, prev1, prev2, carry).
    The variable carry is initially 0.
4.  Recursively traverse to the ends of the two lists.
5.  Now sum = node1.key + node2.key + carry.
6.  Then node1.key = sum % 10 (we will be storing the result in list1),
    and carry = sum / 10.
7.  We need to propagate the carry to the previous nodes.
    If prev1 != null (default), then add the carry to prev1's key (prev1.key += carry).
    Else if prev2 != null, do the above to prev2's key instead.
    Else (FINAL CARRY CONDITION) create a new node, point it towards the original list1.start,
    set the start to this new node, and store the final carry in the new start.
8.  The result will appear in list1.
*/
class Node
{
  int key;
  Node next;

  public Node() {}

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

  private void setStart(Node start)
  {
    this.start = start;
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

  private int adjustLength(MyLinkedList list, int count, int maxCount)
  {
    if(count == maxCount)
    {
      return count;
    }

    Node newStart = new Node(0);
    newStart.next = list.getStart();
    list.setStart(newStart);
    return adjustLength(list, count+1, maxCount);
  }

  public void addLists(MyLinkedList list1, MyLinkedList list2)
  {
    Node start1 = list1.getStart(), start2 = list2.getStart();
    int count1 = 0, count2 = 0;
    while(start1 != null)
    {
      count1++;
      start1 = start1.next;
    }

    while(start2 != null)
    {
      count2++;
      start2 = start2.next;
    }

    if(count1 < count2)
    {
      count1 = adjustLength(list1, count1, count2);
    }
    else if(count2 < count1)
    {
      count2 = adjustLength(list2, count2, count1);
    }

    addLists(list1.getStart(), list2.getStart(), null, null, 0);
  }

  private void addLists(Node node1, Node node2, Node prev1, Node prev2, int carry)
  {
    if(node1.next != null && node2.next != null)
    {
      addLists(node1.next, node2.next, node1, node2, carry);
    }

    int sum = node1.key + node2.key + carry;
    node1.key = sum % 10;
    carry = sum / 10;

    if(prev1 != null)
    {
      prev1.key += carry;
    }
    else if(prev2 != null)
    {
      prev2.key += carry;
    }
    else
    {
      if(carry != 0)
      {
        Node newStart = new Node();
        newStart.key = carry;
        newStart.next = node1;
        this.setStart(newStart);
      }
    }
  }
}

public class AddLinkedLists
{
  public static void main(String[] args)
  {
    MyLinkedList list1 = new MyLinkedList();
    // list1.addNode(new Node(1));
    list1.addNode(new Node(5));
    list1.addNode(new Node(6));
    list1.addNode(new Node(3));

    MyLinkedList list2 = new MyLinkedList();
    // list2.addNode(new Node(1));
    list2.addNode(new Node(4));
    list2.addNode(new Node(5));
    list2.addNode(new Node(8));

    System.out.println("List 1:");
    list1.display();
    System.out.println("List 2:");
    list2.display();

    list1.addLists(list1, list2);
    System.out.println("Result:");
    list1.display();
  }
}
